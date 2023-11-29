package com.EasyBuy.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;

public class DbUtil {
	
	//定义连接类
	private static DruidDataSource dataSource=new DruidDataSource();

	public Connection getCon()throws Exception{
		Class.forName(PropertiesUtil.getValue("driver"));
		Connection con=DriverManager.getConnection(PropertiesUtil.getValue("url"), PropertiesUtil.getValue("username"), PropertiesUtil.getValue("password"));
		/*dataSource.setDriver(new Driver());
		dataSource.setUrl(PropertiesUtil.getValue("url"));
		dataSource.setUsername(PropertiesUtil.getValue("username"));
		dataSource.setPassword(PropertiesUtil.getValue("password"));
		dataSource.setInitialSize(10);
		dataSource.setMaxActive(20);
		Connection con=dataSource.getConnection();*/
		return con;
	}
	
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			Connection con=dbUtil.getCon();
			if(con!=null) {
				System.out.println("连接成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}
