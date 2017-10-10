package com.hs.action;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 * 在action中重写validate(),实现自定义验证。需要继承ActionSuptort，它已经自动包含了validate方法。
 */
public class LoginValidate extends ActionSupport {
	//属性驱动接受数据。
	private String username;
	private String password;
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
	
	//校验方法,对所有的 方发中包含的数据校验。
	public void Validate(){
		if(username.trim().length()<6 || username.trim().length()>15){
			this.addFieldError("username","用户名错误");
		}
		if(username.trim().length()>6 ||username.trim().length()<15){
			this.addFieldError("password","密码错区");
		}                                                             
	}
	//登录的业务处理逻逻辑
	public String loginMethod(){
		if(username.equals("hs") && password.contentEquals("123")){
			ActionContext.getContext().getSession().put("user",username);
			return "loginOk";
		}
		else{
			this.addFieldError("err","你登录成功");
			return "loginFail";
		}
	}
	
	//当然也可以设置valid更精确。采用validXxx的方式.validate 加处理的方法名。可以具体到某一个方法。
	public void validateLoginMethod(){
		//验证用户名
		if(username==null || username.trim().contentEquals("")){
			this.addFieldError("username","用户名不能为空");
		}else if(!Pattern.matches("[a-zA-Z]{6,15}",username.trim())){
			this.addFieldError("username","用户名长度在6-15个之间并且只能为字母");
		}
		//验证密码
		if(password==null || password.trim().contentEquals("")){
			this.addFieldError("password","密码不能为空");
		}else if(!Pattern.matches("\\d{6-15}",username.trim())){
			this.addFieldError("password","密码长度在6-15个之间");
		}
	}
	
	
}
