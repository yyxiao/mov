/**
 * MoveAction.java
 * com.action
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年2月24日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package com.action;

import java.util.List;

import com.entity.Reward;
import com.service.EmployeeService;
import org.apache.log4j.Logger;

import com.service.WechatService;

 
public class MoveAction {
	
private static Logger logger = Logger.getLogger(MoveAction.class);
	
	private static WechatService ws = new WechatService();
	private static EmployeeService es = new EmployeeService();
	
	
	public static void main(String[] args) {
		
//		String a = "omtrc623";
//		String b = es.encode(a);
//		System.out.println(b);
		//微信公共号ID
		String wechatId = args[0];
		String mobile = args[1];
		String email = args[2];
		String pwd = args[3];
		String business = args[4];
		String userName = "";
		if(args.length>5){
			userName = args[5];
		}

		//获取departmentId
		int departmentId = ws.findDepartmentIdByWechatId(wechatId);
		//获取companyId
		int companyId = ws.findCompanyIdByDepartmentId(departmentId);
		//获取employeeId
		int employeeId = es.findEmployeeIdByDepartmentId(departmentId);
		if(departmentId!=0){
			logger.info("获取departmentId:"+departmentId);
			//备份积分信息
			boolean savaReward = es.saveReward(departmentId);
			if(savaReward){
				//删除原积分信息
				boolean deleteReward = es.deleteReward(departmentId);
			}
			//获取积分信息
			List<Reward> rewards = es.findRewards(departmentId);
			//更新员工积分数据
			if(!rewards.isEmpty()){
				es.saveRewards(rewards);
			}
			//添加积分结余总数
			boolean addReward = es.addReward(departmentId);
			//备份这些认证员工相关的申请状态操作记录
			boolean saveOperation = es.saveOperation(departmentId);
			//删除操作记录
			boolean delOperation = es.deleteOperation(departmentId);
			//删除积分配置
			boolean delAwardConfig = ws.deleteAwardConfig(departmentId);
			//添加积分配置
			boolean saveAwardConfig = ws.saveAwardConfig(departmentId);
			//加密
			pwd = es.encode(pwd);
			//查询插入的hr账号ID
			int accountId = es.add(employeeId, mobile, departmentId, userName, pwd, email);
			//撤下职位
			boolean updatePosition = ws.updatePosition(departmentId, accountId);
			//迁移职位申请
			boolean updateApp = ws.updateApplication(departmentId);
			//公司更新关联hr
			boolean updateCompany = ws.updateCompany(companyId, employeeId, business);
			//更新迁移标识
			boolean updateWechat = ws.updateWechat(wechatId);
			//更新mp中hr数据
			int num = es.updateHr(departmentId);
		}else{
			logger.info("wechatId="+wechatId+"不存在！");
		}
	}

}
