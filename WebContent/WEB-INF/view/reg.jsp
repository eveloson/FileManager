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
<title>用户注册</title>
<script type="text/javascript">
function refrush_yzm(){
	var img_yzm = document.getElementById("yzm_img");
	var src_val = img_yzm.getAttribute("src").toString().split("?")[0];
	var new_src_val = src_val + "?ctime="+ new Date().getTime() ;
	img_yzm.setAttribute("src", new_src_val);
}
</script>
</head>
<body>
		<h1>用户注册</h1>
	<div>
		<form action="user/reg.do" method="post">
			账号：<br>
			<input type="text" name="user_name"> <br><br>
			
			密码：<br>
			<input type="password" name="user_pwd"> <br><br>
			
			确认密码：<br>
			<input type="password" name="user_pwd2"> <br><br>
			
			验证码：<br>
			<input type="text" name="user_yzm" style="width: 100px">
			<a href="JavaScript:void(0);" onclick="refrush_yzm();">
				<img alt="加载中..." src="getyzm.do" id="yzm_img">
			</a>
			<a href="JavaScript:void(0);" onclick="refrush_yzm()">看不清，换一张</a>
			 <br><br>
			
			<input type="submit" value="确认注册">
		</form>
	</div>
</body>
</html>