package com.EasyBuy.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	
	//查询方法
		public ResultSet executeQuery(Connection con,String sql,Object [] params) {
			   ResultSet rs=null;
			  //获取执行对象
			  try {
				PreparedStatement prs=con.prepareStatement(sql);
				if(params!=null&&params.length>0) {
					for(int i=0;i<params.length;i++) {
						prs.setObject(i+1,params[i] );
					}
				}
				rs=prs.executeQuery();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return rs;
		}
		
		//增删改方法
		public int executeUpdate(Connection con,String sql,Object [] params) {
			   int  rowcount=0;
			  //获取执行对象
			  try {
				PreparedStatement prs=con.prepareStatement(sql);
				if(params!=null&&params.length>0) {
					for(int i=0;i<params.length;i++) {
						prs.setObject(i+1,params[i] );
					}
				}
				rowcount=prs.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return rowcount;
			  
		}
		
		public int executeInsert(Connection con,String sql,Object[] params){
			Long id = 0L;
			try {
				PreparedStatement pstm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				if(params!=null&&params.length>0) {
					for(int i=0;i<params.length;i++) {
						pstm.setObject(i+1,params[i] );
					}
				}
				pstm.executeUpdate();
				ResultSet rs = pstm.getGeneratedKeys(); 
				if (rs.next()) { 
					id = rs.getLong(1);
					//System.out.println("数据主键：" + id); 
				} 
				
			} catch (Exception e) {
				e.printStackTrace();
				id =null;
			}
			
			return id.intValue();
		}
}
