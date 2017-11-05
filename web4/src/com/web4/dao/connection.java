package com.web4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connection {
	public static final String driver="com.mysql.jdbc.Driver";
	public static final String url="jdbc:mysql://localhost:3306/users";
	public static final String user="root";
	public static final String password="sunxuan21";
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	public void getConnection(){
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int update(String sql,Object...obj){//这里可以插入的显示
		int num=0;
		getConnection();
		try{
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				pstmt.setObject(i+1, obj[i]);
			}
			num=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return num;
	}
	public ResultSet Query(String sql,Object...obj){
		getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				pstmt.setObject(i+1, obj[i]);
			}
			rs=pstmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	public void closeAll(){
		try{
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
