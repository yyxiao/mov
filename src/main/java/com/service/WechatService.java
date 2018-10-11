/**
 * WechatService.java
 * com.service
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年2月19日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
 */
package com.service;

import java.sql.ResultSet;

import com.util.DBHelper;
import com.util.StringHelper;
import org.apache.log4j.Logger;

public class WechatService {
	private Logger logger = Logger.getLogger(WechatService.class);
	
	DBHelper db = null;
	ResultSet resultSet = null;
	/**
	 * (查询departmentId)
	 * 
	 * @param wechatId
	 * @return
	 */
	public int findDepartmentIdByWechatId(String wechatId) {
		int departmentId = 0;
		String sql = "SELECT department_id FROM `sys_wechat` WHERE id = "
				+ wechatId;
		db = new DBHelper(sql);
		try {
			//获取结果集
			resultSet = db.pst.executeQuery();
			if(!StringHelper.isEmptyObject(resultSet)){
				while(resultSet.next()){
					departmentId = resultSet.getInt(1);
				}
			}
			logger.info("查询成功！");
			db.close();
		}catch(Exception e){
			logger.info("查询失败！");
		}
		return departmentId;
	}

	/**
	 * (删除积分配置)
	 * 
	 * @param departmentId
	 * @return
	 */
	public boolean deleteAwardConfig(int departmentId) {
		Boolean bl = true;
		// 填写sql语句
		String sql = "delete from hr_award_config where department_id = "
				+ departmentId;
		db = new DBHelper(sql);
		try {
			int ret = db.pst.executeUpdate();
			//处理结果
			if (ret > 0) {
				// 删除成功
				logger.info("删除配置记录成功！" + ret);
			} else {
				bl = false;
				logger.info("删除配置记录成功！");
			}
            db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("删除配置记录失败！" + e);
		}
		return bl;
	}

	/**
	 * (添加积分配置)
	 * 
	 * @param departmentId
	 * @return
	 */
	public boolean saveAwardConfig(int departmentId) {
		Boolean bl = true;
		// 填写sql语句
		String sql = "insert into hr_award_config(department_id, status_name, reward, description, template_id, tag) "
				+ " select "+ departmentId+", status as status_name, award as reward, description,id as template_id,tag "
				+ " from hr_award_config_template where award > 0";
		db = new DBHelper(sql);
		try {
			int ret = db.pst.executeUpdate();
			//处理结果
            if(ret>0){
            	// 添加成功
            	logger.info("添加配置成功！ "+ret);
            }else{
            	bl = false;
            	logger.info("添加配置失败！");
            }
            db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("添加配置失败！" + e);
		}
		return bl;
	}
	
	/**
	 * (撤下职位)
	 * @param departmentId
	 * @return
	*/
	public boolean updatePosition(int departmentId, int accountId){
		
		Boolean bl = true;
		//撤下职位
		String sql = "update hr_position set status = 1 where department_id = "+departmentId+" and status = 0 and stop_date is not null and stop_date < now()";
		//职位实习生转为兼职、校招
		String sql1 = "update hr_position set employment_type=1,candidate_source=1 WHERE department_id = "+departmentId+" AND employment_type =2";
		//更新职位发布者
		String sql2 = "update hr_position set publisher= "+accountId+" where department_id = "+departmentId;
		//更新职位面议数据
		String sql3 = "update hr_position set salary_top=0, salary_bottom=0 where "
				+ " salary='面议' and ISNULL(salary_top) AND ISNULL(salary_bottom) AND department_id = "+departmentId;
		//清洗mp已撤下职位数据
		String sql4 = "UPDATE hr_position set status=2 where department_id = "+departmentId+" and status=0 and stop_date<=adddate(now(),-15)";
		try {
			db = new DBHelper(sql);
			int ret = db.pst.executeUpdate();
			//处理结果
            if(ret>=0){
            	logger.info("撤下职位成功！" + ret);
            }else{
            	bl = false;
            	logger.info("撤下职位失败！");
            }
            //职位实习生转为兼职、校招
            int ret1 = db.pst.executeUpdate(sql1);
			//处理结果
            if(ret>=0){
            	logger.info("职位实习生转为兼职、校招成功！" + ret1);
            }else{
            	bl = false;
            	logger.info("职位实习生转为兼职、校招失败！");
            }
            //更新职位发布者
            int ret2 = db.pst.executeUpdate(sql2);
			//处理结果
            if(ret>=0){
            	logger.info("更新职位发布者成功！" + ret2);
            }else{
            	bl = false;
            	logger.info("更新职位发布者失败！");
            }
            //更新职位面议数据
            int ret3 = db.pst.executeUpdate(sql3);
            //处理结果
            if(ret>=0){
            	logger.info("更新职位面议数据成功！" + ret3);
            }else{
            	bl = false;
            	logger.info("更新职位面议数据失败！");
            }
            //清洗mp已撤下职位数据
            int ret4 = db.pst.executeUpdate(sql4);
            //处理结果
            if(ret>=0){
            	logger.info("清洗mp已撤下职位数据！" + ret4);
            }else{
            	bl = false;
            	logger.info("清洗mp已撤下职位数据失败！");
            }
            db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("撤下职位失败！" + e);
		}
		return bl;
	}
	
	/**
	 * (迁移公司下所有的职位申请)
	 * @param departmentId
	 * @return
	*/
	public boolean updateApplication(int departmentId){
		Boolean bl = true;
		// 填写sql语句
		String sql = "update job_application set app_tpl_id= 1, is_viewed=0 where department_id = " + departmentId;
		db = new DBHelper(sql);
		try {
			int ret = db.pst.executeUpdate();
			//处理结果
			if (ret >= 0) {
				// 职位申请迁移成功
				logger.info("职位申请迁移成功！" + ret);
			} else {
				logger.info("职位申请迁移失败！");
			}
            db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("职位申请迁移失败！" + e);
		}
		return bl;
	}

	/**
	 * (查询公司Id)
	 * @param departmentId
	 * @return
	*/
	public int findCompanyIdByDepartmentId(int departmentId) {
		int companyId = 0;
		String sql = "SELECT company_id FROM `sys_department` WHERE id = "
				+ departmentId;
		db = new DBHelper(sql);
		try {
			//获取结果集
			resultSet = db.pst.executeQuery();
			if(!StringHelper.isEmptyObject(resultSet)){
				while(resultSet.next()){
					companyId = resultSet.getInt(1);
				}
			}
			logger.info("查询成功公司Id:" + companyId);
			db.close();
		}catch(Exception e){
			logger.info("查询失败！");
		}
		return companyId;
	}
	
	/**
	 * 公司更新（idea错误提示比eclipse好很多）
	 * @param companyId
	 * @param accountId
	 * @param business
	 * @return
	 */
	public boolean updateCompany(int companyId,int accountId,String business){
		Boolean bl = true;
		// 填写sql语句
		String sql = "UPDATE sys_company SET hraccount_id = " + accountId
				+ " , business = '"+ business 
				+"' , update_time = (date_add(NOW(), INTERVAL - 1 MONTH)) WHERE id = " + companyId;
		db = new DBHelper(sql);
		try {
			int ret = db.pst.executeUpdate();
			//处理结果
			if (ret > 0) {
				logger.info("公司更新成功！");
			} else {
				logger.info("公司更新失败！");
			}
            db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("公司更新失败！" + e);
		}
		return bl;
	}
	
	/**
	 * (更新迁移标识)
	 * @param wechatId
	 * @return
	*/
	public boolean updateWechat(String wechatId) {
		Boolean bl = true;
		// 填写sql语句
		String sql = "UPDATE `sys_wechat` SET is_migrate = 0 WHERE id = " + wechatId;
		db = new DBHelper(sql);
		try {
			int ret = db.pst.executeUpdate();
			//处理结果
			if (ret > 0) {
				logger.info("更新迁移标识成功！");
			} else {
				logger.info("更新迁移标识失败！");
			}
            db.close();
		} catch (Exception e) {
			bl = false;
			logger.info("更新迁移标识失败！" + e);
		}
		return bl;
	}
}
