<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="Bookmark" href="favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<h1>用户登录</h1>
	<div>
		<form action="user/login.do" method="post">
			用户名称：<br>
			<input type="text" name="user_name"><br><br>
			
			用户密码：<br>
			<input type="password" name="user_pwd"><br><br>
			
			<input type="submit" value="确认登录">
			<a href="user/reg.do">注册帐号</a>
		</form>
	</div>	
</body>
</html>