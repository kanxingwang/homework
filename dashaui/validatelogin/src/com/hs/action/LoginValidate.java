package com.hs.action;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 * ��action����дvalidate(),ʵ���Զ�����֤����Ҫ�̳�ActionSuptort�����Ѿ��Զ�������validate������
 */
public class LoginValidate extends ActionSupport {
	//���������������ݡ�
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
	
	//У�鷽��,�����е� �����а���������У�顣
	public void Validate(){
		if(username.trim().length()<6 || username.trim().length()>15){
			this.addFieldError("username","�û�������");
		}
		if(username.trim().length()>6 ||username.trim().length()<15){
			this.addFieldError("password","�������");
		}                                                             
	}
	//��¼��ҵ�������߼�
	public String loginMethod(){
		if(username.equals("hs") && password.contentEquals("123")){
			ActionContext.getContext().getSession().put("user",username);
			return "loginOk";
		}
		else{
			this.addFieldError("err","���¼�ɹ�");
			return "loginFail";
		}
	}
	
	//��ȻҲ��������valid����ȷ������validXxx�ķ�ʽ.validate �Ӵ���ķ����������Ծ��嵽ĳһ��������
	public void validateLoginMethod(){
		//��֤�û���
		if(username==null || username.trim().contentEquals("")){
			this.addFieldError("username","�û�������Ϊ��");
		}else if(!Pattern.matches("[a-zA-Z]{6,15}",username.trim())){
			this.addFieldError("username","�û���������6-15��֮�䲢��ֻ��Ϊ��ĸ");
		}
		//��֤����
		if(password==null || password.trim().contentEquals("")){
			this.addFieldError("password","���벻��Ϊ��");
		}else if(!Pattern.matches("\\d{6-15}",username.trim())){
			this.addFieldError("password","���볤����6-15��֮��");
		}
	}
	
	
}
