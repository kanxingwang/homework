package com.web4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.web4.dao.UsersDao;
import com.web4.dao.connection;
import com.web4.entity.User;

public class UserDaoimpl extends connection implements UsersDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	public int addUser(User u) {
		// TODO Auto-generated method stub
		int num=0;
		String sql="insert into user(userid,username,password,email,grade) values(?,?,?,?,?)";
		try{
			num=update(sql,u.getUserid(),u.getUsername(),u.getPassword(),u.getEmail(),u.getGrade());
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	public int delUser(int userid) {
		// TODO Auto-generated method stub
		int num=0;
		String sql="delete from users where userid=?";
		try{
			num=update(sql,userid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	public User findUserByid(int userid) {
		// TODO Auto-generated method stub
		User u=null;
		String sql="select * from user where userid=?";
		rs=Query(sql,userid);
		try{
			if(rs.next())
				u=new User();}
			catch(Exception e){
				e.printStackTrace();
			}
			return u;
			
	}
	public List<User> getAlluser() {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		String sql="select * from user";
		rs=Query(sql);
		try{
			while(rs.next()){
				User u=new User();
				list.add(u);
			}}catch(Exception e){
				e.printStackTrace();
			}
			return list;
		
	}
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		int num=0;
		String sql="update user set userid=?,username=?,password=?,email=?,grade=?";
		try{
			num=update(sql,u.getUserid(),u.getUsername(),u.getPassword(),u.getEmail(),u.getGrade());
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	
}
