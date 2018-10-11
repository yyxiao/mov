package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
  
/**
 * ClassName:DBHelper
 *
 * (jdbc连接数据库)
 *
 * @project demotime4
 *
 * @author xiao
 *
 * @date   2015-3-27 下午2:24:28	
 *
 * @class xyy.util.DBHelper
 *
 */ 
public class DBHelper {  
	//加载JDBC驱动
    public static final String driverName = "com.mysql.jdbc.Driver"; 
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public DBHelper(String sql) {
        try {
//        	ReadProperties rp = new ReadProperties("/jdbc.properties");
//        	String url = StringHelper.toString(rp.getProperty("mysql_address"));
//        	String userName = StringHelper.toString(rp.getProperty("mysql_user"));
//        	String userPwd = StringHelper.toString(rp.getProperty("mysql_pwd"));
        	//指定连接类型 
        	Class.forName(driverName);
        	//获取连接  
//            conn = DriverManager.getConnection(url, userName, userPwd);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8", "root", "root");
            //准备执行语句
            pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }

    public DBHelper(String sql, String params[]) {
        try {
            //指定连接类型
            Class.forName(driverName);
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8", "root", "root");
            //准备执行语句
            pst = conn.prepareStatement(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  