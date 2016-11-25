/**
 * EmployeeService.java
 * com.service
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年1月19日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.entity.Reward;
import com.util.DBHelper;
import com.util.HashKit;
import com.util.StringHelper;


 
public class EmployeeService {
	
	DBHelper db = null;  
	ResultSet resultSet = null;
	
	private Logger logger = Logger.getLogger(EmployeeService.class);
	
	/**
	 * (备份员工的积分数据)
	 * @param departmentId
	 * @return
	 * @throws SQLException
	*/
	public boolean saveReward(int departmentId){
		Boolean bl = true;
		String sql = "insert into bak_sys_reward select * from sys_reward where employee_id in (select id from sys_employee where department_id = "+departmentId+")";
		try {
			db = new DBHelper("set names utf8mb4");
			db.pst.executeUpdate();
			int ret = db.pst.executeUpdate(sql);
			if (ret >= 0) {
            	logger.info("保存积分备份信息成功！" + ret);
            }else{
            	bl = false;
    			logger.info("保存积分备份信息失败！");
            }
			db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("保存积分备份信息失败！" + e);
		}
		return bl;
	}
	
	/**
	 * (更新员工积分数据)
	 * @param departmentId
	 * @return
	 * @throws SQLException
	*/
	public boolean saveRewards(List<Reward> rewards){
		Boolean bl = true;
		try {
			for(Reward reward:rewards){
				String sql = "UPDATE sys_employee SET award="+reward.getReward()+" WHERE id= "+reward.getId();
				db = new DBHelper(sql);
				int ret = db.pst.executeUpdate();
				if (ret >= 0) {
	            	logger.info("更新员工积分信息成功！" + ret +"测试"+sql);
	            }else{
	            	bl = false;
	    			logger.info("更新员工积分信息失败！");
	            }
			}
			db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("更新员工积分信息失败！" + e);
		}
		return bl;
	}
	
	/**
	 * (获取积分列表)
	 * @param departmentId
	 * @return
	*/
	public List<Reward> findRewards(int departmentId){
		List<Reward> rewards = new ArrayList<Reward>();
		String sql = "select employee_id, SUM(award) AS award from sys_reward where employee_id in (select id from sys_employee where department_id = "
				+departmentId+")GROUP BY employee_id";
		db = new DBHelper(sql);
		try {
			//获取结果集
			resultSet = db.pst.executeQuery();
			if(!StringHelper.isEmptyObject(resultSet)){
				while(resultSet.next()){
					Reward reward = new Reward();
					reward.setId(resultSet.getInt(1));
					reward.setReward(resultSet.getInt(2));
					rewards.add(reward);
				}
			}
			logger.info("查询积分列表成功！"+rewards.size());
			db.close();
		}catch(Exception e){
			logger.info("查询积分列表失败！");
		}
		return rewards;
	}
	
	/**
	 * (删除原始积分)
	 * @param departmentId
	 * @return
	 * @throws SQLException
	*/
	public boolean deleteReward(int departmentId){
		Boolean bl = true;
		String sql = "DELETE FROM sys_reward WHERE employee_id IN ( SELECT id FROM sys_employee WHERE department_id = "+departmentId+")";
		db = new DBHelper(sql);
		try {
			int ret = db.pst.executeUpdate();
			//处理结果
            if(ret>=0){
            	// 删除成功
            	logger.info("删除积分信息成功！" + ret);
            }else{
    			logger.info("删除积分信息失败！");
            }
            db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("删除积分信息失败！" + e);
		}
		return bl;
	}
	
	/**
	 * (添加积分结余总数)
	 * @param departmentId
	 * @return
	 * @throws SQLException
	*/
	public boolean addReward(int departmentId){
		Boolean bl = true;
		//填写sql语句
		String sql = "INSERT INTO sys_reward ( employee_id, reason, award, _create_time, application_id, recom_wxuser, update_time ) "
				+ " SELECT employee_id, 'moving', SUM(award) AS award, _create_time, application_id, recom_wxuser, update_time "
				+ " FROM bak_sys_reward WHERE employee_id IN ( SELECT id FROM sys_employee WHERE department_id = "+departmentId+") GROUP BY employee_id";
		db = new DBHelper(sql);
		try {
			int ret = db.pst.executeUpdate();
			//处理结果
            if(ret>=0){
            	logger.info("添加积分信息成功！ " + ret);
            }else{
            	bl = false;
            	logger.info("添加积分信息失败！");
            }
            db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("添加积分信息失败！" + e);
		}
		return bl;
	}
	
	/**
	 * (备份这些认证员工相关的申请状态操作记录)
	 * @param departmentId
	 * @return
	 * @throws SQLException
	*/
	public boolean saveOperation(int departmentId){
		Boolean bl = true;
		//填写sql语句
		String sql = "insert into bak_hr_operation_record(id, admin_id, department_id, app_id, status_id, opt_time) "
				+ " select id, admin_id, department_id, app_id, status_id, opt_time from hr_operation_record where department_id = " + departmentId;
		
		db = new DBHelper(sql);
		try {
			int ret = db.pst.executeUpdate();
			//处理结果
            if(ret>=0){
            	// 添加成功
            	logger.info("备份操作记录成功！" + ret);
            }else{
            	bl = false;
    			logger.info("备份操作记录失败！");
            }
            db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("备份操作记录失败！" + e);
		}
		return bl;
	}
	
	/**
	 * (删除操作记录)
	 * @param departmentId
	 * @return
	*/
	public boolean deleteOperation(int departmentId){
		Boolean bl = true;
		//填写sql语句
		String sql = "DELETE FROM hr_operation_record WHERE department_id = " + departmentId;
		db = new DBHelper(sql);
		try {
			int ret = db.pst.executeUpdate();
			//处理结果
            if(ret>=0){
            	// 删除成功
            	logger.info("删除操作记录成功！" + ret);
            }else{
    			logger.info("删除操作记录失败！");
            }
            db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("删除操作记录失败！" + e);
		}
		return bl;
	}
	
	/**
	 * (添加公司hr)
	 * @param position
	 * @return
	*/
	public int add(int employeeId, String mobile, int departmentId, String userName, String pwd, String email){
		int id = 0;
		String sql = "INSERT INTO hr_account(id,department_id,mobile,password,username,email,account_type) "
				+ " VALUES("+employeeId+", "+departmentId+",'"+mobile+"', '"+pwd+"', '"+userName+"', '"+email+"' ,2)";
		db = new DBHelper(sql);
		try {
			int ret = db.pst.executeUpdate();
			//处理结果
            if(ret>0){
            	// 更新成功
				resultSet = db.pst.getGeneratedKeys();  
	            if(resultSet.next()) {
	            	id = resultSet.getInt(1); 
	            }
	            if(id!=0){
	            	// 添加成功
	            	logger.info("hr账号保存成功！id = " + id);
	            }else{
	    			logger.info("hr账号保存失败！");
	            }
            }
            db.close();
		} catch (Exception e) {
			logger.info("hr账号保存失败！" + e);
		}
		return id;
	}
	
	/**
	 * (查询employeeId)
	 * 
	 * @param departmentId
	 * @return
	 */
	public int findEmployeeIdByDepartmentId(int departmentId) {
		int employeeId = 0;
		String sql = "SELECT * from sys_employee where role_id != 0 AND department_id = " + departmentId + " ORDER BY id DESC";
		db = new DBHelper(sql);
		try {
			//获取结果集
			resultSet = db.pst.executeQuery();
			if(!StringHelper.isEmptyObject(resultSet)){
				while(resultSet.next()){
					employeeId = resultSet.getInt(1);
				}
			}
			logger.info("查询成功！employeeId:"+employeeId);
			db.close();
		}catch(Exception e){
			logger.info("查询失败！");
		}
		return employeeId;
	}
	
	/**
	 * (更改mp中hr账号密码)
	 * @param departmentId
	 * @param MoSeeker123(密码)
	 * @return
	*/
	public int updateHr(int departmentId){
		int num = 0;
		String sql = "UPDATE sys_employee SET `password`='91b15551f16b13f00fdc16d897bdc3a5b73667d9'  WHERE department_id = " + departmentId + " AND `role_id`!=0";
		db = new DBHelper(sql);
		try {
			num = db.pst.executeUpdate();
			//处理结果
            if(num>0){
            	// 添加成功
            	logger.info("更改mp中hr账号密码成功！num = " + num);
            }else{
    			logger.info("更改mp中hr账号密码失败！");
            }
            db.close();
		} catch (Exception e) {
			logger.info("更改mp中hr账号密码失败！" + e);
		}
		return num;
	}
	
	
	/**
	 * (hr加密)
	 * @param pwd
	 * @return
	*/
	public String encode(String pwd){
		String a1 = HashKit.md5(pwd);
		
		String b1 = HashKit.sha1(a1);
		return b1;
	}
	
	/**
	 * (mp加密)
	 * @param pwd
	 * @return
	*/
	public String encodeMp(String pwd){
		String passsword = HashKit.sha1(pwd);
		return passsword;
	}
	
}
