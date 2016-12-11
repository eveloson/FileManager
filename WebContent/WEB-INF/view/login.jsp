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
<style type="text/css" href="resource/css/login.css"></style>
</head>
<body>
<!-- 	<h1>用户登录</h1>
	<div>
		<form action="user/login.do" method="post">
			用户名称：<br>
			<input type="text" name="user_name"><br><br>
			
			用户密码：<br>
			<input type="password" name="user_pwd"><br><br>
			
			<input type="submit" value="确认登录">
			<a href="user/reg.do">注册帐号</a>
		</form>
	</div>	 -->


<div class="wrapper">

	<div class="container">
		<h1>Welcome</h1>
		<form class="form">
			<input type="text" placeholder="Username">
			<input type="password" placeholder="Password">
			<button type="submit" id="login-button">Login</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	
</div>

<script type="text/javascript" src="resource/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$('#login-button').click(function(event){
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
});
</script>


</body>
</html>