<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
session = request.getSession();
String username=(String)session.getAttribute("name2");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
  
    ${sessionScope.realname } Login success!<br/><br/>
    
    <form method="post" action="searchAction">
    	<input type="text" name="input"/>
    	<input type="submit" value="Search"/>
    </form>
    
    <table width="400" height="50" border="1" >
    		<tr align="center">
    			<td>用户名</td>
    			<td>真实姓名</td>
    			<td colspan="2">操作</td>
    		</tr>
    	<c:forEach items="${list }" var="userinfo">
    		<tr align="center">
    			<td>${userinfo.username }</td>
    			<td>${userinfo.realname }</td>
    			<td><a href="deleteAction?userid=${userinfo.userid}">删除</a></td>
    			<td><a href="updateAction?userid=${userinfo.userid}">编辑</a></td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
