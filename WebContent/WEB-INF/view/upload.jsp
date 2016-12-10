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
<title>title</title>
<!--<link rel="stylesheet" href="" />-->
</head>
<body align="center">
	<h1>文件上传</h1>
	<div >
		<form action="doc/upload.do" method="post" enctype="multipart/form-data">
			文件：
			<input type="file" name="doc"> <br> <br>
			<input type="submit" value="开始上传">
			<input type="reset" value="重置表单">
		</form>
	</div>

	<!--<script src="" type="text/javascript" charset="utf-8"></script>-->
</body>
</html>