<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #15B69A;
		margin: 0;
		color: #ffffff;
	}
	a {
		text-transform:none;
		text-decoration:none;
		color: #ffffff;
		font-weight: 900;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">九职船舶工程学院图书管理系统</h1>
<div style="font-size: 10pt; line-height: 10px;">
<c:choose>
	<c:when test="${empty sessionScope.sessionUser}">
		<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">图书用户登录</a> |&nbsp;
		<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">注册图书用户</a> |&nbsp;
		<a href="<c:url value='/adminjsps/login.jsp'/>" target="_parent">登录后台</a>
	</c:when>
	<c:otherwise>
		图书会员：${sessionScope.sessionUser.loginname}&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/CartItemServlet?method=myCart'/>" target="body">我的借阅车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/OrderServlet?method=myOrders'/>" target="body">我的借阅清单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/jsps/user/pwd.jsp'/>" target="body">修改密码</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/quitAction.action'/>" target="_parent">退出</a>&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="#" >联系我们</a>
	</c:otherwise>
</c:choose>




</div>
  </body>
</html>
