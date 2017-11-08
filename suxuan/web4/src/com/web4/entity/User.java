package com.web4.entity;

public class User {
	public User(int userid,String username,String password,String email,int grade){
		this.userid=userid;
		this.username=username;
		this.password=password;
		this.email=email;
		this.grade=grade;
	}
	public User(){}
private int userid;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
private String username;
private String password;
private String email;
private int grade;
@Override
public String toString() {
	return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", email= "+ email +",grade="+ grade +"]";
}
}
