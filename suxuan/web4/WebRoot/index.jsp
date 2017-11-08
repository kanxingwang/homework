<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <base href="<%=basePath%>">
  <title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table {
	width: 600px;
	height: 300px;
}
td{ text-align:center;}
</style>
  <body>
  <h1>主页</h1>
	<table border="1px">
		<tr>
			<th>id</th>
			<th>姓名</th>
			<th>密码</th>
			<th>email</th>
			<th>grade</th>
		</tr>
		<c:forEach items="${list }" var="data">
			<tr>
				<td>${data.ids }</td>
				<td>${data.name }</td>
				<td>${data.password1 }</td>
				<td>${data.email1 }</td>
				<td>${data.grade1 }</td>
				<td><a href="servletusers?do=editbefore&id=${data.ids }">修改</a> <a
					href="servletusers?do=del&id=${data.ids }" onclick="javascript:return confirm('确认删除吗？');">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	
<a href="add.jsp">新增</a>
  </body>
</html>
