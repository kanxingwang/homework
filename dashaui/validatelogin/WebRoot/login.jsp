<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 标签库 -->
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>登录页面</title>
	<meta charset="utf-8">
  </head>
  <body>
    <s:form action="login" method="post">
  		<s:textfield label="用户名:" name="username"></s:textfield>
  		<s:password label="密码" name="password"></s:password>
  		<s:submit value="登录"></s:submit>
  		<s:fielderror><s:param>username</s:param> </s:fielderror>
  		<s:fielderror><s:param>password</s:param> </s:fielderror>
  	</s:form>
  </body>
</html>
