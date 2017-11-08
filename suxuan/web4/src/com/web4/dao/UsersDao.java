package com.web4.dao;

import java.util.List;

import com.web4.entity.User;

public interface UsersDao {
	public int addUser(User u);
	public int delUser(int userid);
	public int updateUser(User u);
	public User findUserByid(int userid);
	public List<User>getAlluser();
}
