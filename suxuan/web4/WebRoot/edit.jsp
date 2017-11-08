<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <h1>修改页面</h1>
    <form action="servletusers?do=edit" method="post">
    <input type="hidden" name="id" value="${edituser.userid }">
    姓名：<input name="name" value="${edituser.username }"><br>
    密码：<input name="password1" value="${edituser.password1 }" ><br>
 email:<input name="email1" value="${edituser.email1} }"/><br/>
 grade:<input name="grade1" value="${edituser.grade1} }"/><br/>
    <input type="submit" value="修改" > <input type="reset">
    </form>
  </body>
</html>
