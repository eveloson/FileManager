<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="resource/layui/css/layui.css"  media="all">
<link rel="stylesheet" href="resource/css/laypage.css" />  
<script type="text/javascript" src="resource/js/layer/laypage.js"></script>  
<title>title</title>
<!--<link rel="stylesheet" href="" />-->
<style type="text/css">
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  font-weight: 300;
}
.wrapper {
  background: #50a3a2;
  background: -webkit-linear-gradient(top left, #50a3a2 0%, #53e3a6 100%);
  background: linear-gradient(to bottom right, #50a3a2 0%, #53e3a6 100%);
  opacity: 0.8;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
/*   margin-top: -200px; */
  overflow: hidden;
}
.container {
  max-width: 60%;
  margin: 0 auto;
  padding: 80px 0;
  height: 400px;
/*   text-align: center; */
}
.bg-bubbles {
/*   position: absolute; */
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
}
.bg-bubbles li {
  position: absolute;
  list-style: none;
  display: block;
  width: 40px;
  height: 40px;
  background-color: rgba(255, 255, 255, 0.15);
  bottom: -160px;
  -webkit-animation: square 25s infinite;
  animation: square 25s infinite;
  -webkit-transition-timing-function: linear;
  transition-timing-function: linear;
}
.bg-bubbles li:nth-child(1) {
  left: 10%;
}
.bg-bubbles li:nth-child(2) {
  left: 20%;
  width: 80px;
  height: 80px;
  -webkit-animation-delay: 2s;
          animation-delay: 2s;
  -webkit-animation-duration: 17s;
          animation-duration: 17s;
}
.bg-bubbles li:nth-child(3) {
  left: 25%;
  -webkit-animation-delay: 4s;
          animation-delay: 4s;
}
.bg-bubbles li:nth-child(4) {
  left: 40%;
  width: 60px;
  height: 60px;
  -webkit-animation-duration: 22s;
          animation-duration: 22s;
  background-color: rgba(255, 255, 255, 0.25);
}
.bg-bubbles li:nth-child(5) {
  left: 70%;
}
.bg-bubbles li:nth-child(6) {
  left: 80%;
  width: 120px;
  height: 120px;
  -webkit-animation-delay: 3s;
          animation-delay: 3s;
  background-color: rgba(255, 255, 255, 0.2);
}
.bg-bubbles li:nth-child(7) {
  left: 32%;
  width: 160px;
  height: 160px;
  -webkit-animation-delay: 7s;
          animation-delay: 7s;
}
.bg-bubbles li:nth-child(8) {
  left: 55%;
  width: 20px;
  height: 20px;
  -webkit-animation-delay: 15s;
          animation-delay: 15s;
  -webkit-animation-duration: 40s;
          animation-duration: 40s;
}
.bg-bubbles li:nth-child(9) {
  left: 25%;
  width: 10px;
  height: 10px;
  -webkit-animation-delay: 2s;
          animation-delay: 2s;
  -webkit-animation-duration: 40s;
          animation-duration: 40s;
  background-color: rgba(255, 255, 255, 0.3);
}
.bg-bubbles li:nth-child(10) {
  left: 90%;
  width: 160px;
  height: 160px;
  -webkit-animation-delay: 11s;
          animation-delay: 11s;
}
@-webkit-keyframes square {
  0% {
    -webkit-transform: translateY(0);
            transform: translateY(0);
  }
  100% {
    -webkit-transform: translateY(-700px) rotate(600deg);
            transform: translateY(-700px) rotate(600deg);
  }
}
@keyframes square {
  0% {
    -webkit-transform: translateY(0);
            transform: translateY(0);
  }
  100% {
    -webkit-transform: translateY(-700px) rotate(600deg);
            transform: translateY(-700px) rotate(600deg);
  }
}
</style>
</head>
<body>
<div class="wrapper">
	<div class="container">	
		<fieldset align="center" class="layui-elem-field layui-field-title" style="margin-top: 50px;">
	  	<legend>我的文件</legend>
		</fieldset>  
			
				<table align="center" class="layui-table" lay-skin="line">
					<thead>
						<th>文件名</th>
	      				<th>大小</th>
	     				<th>上传时间</th>
	    				<th>操作</th>
					</thead>
					<tbody>	
					<c:forEach var="doc" items="${requestScope.docs}">
						<tr>
							<td>
								<a href="doc/download.do?docId=${doc.docId}">
								<img src="resource/img/file.png" style="width: 20px;height: 20px;display: inline;">
								${doc.docNameO}
								</a>
							</td>
							<td>${doc.docSize}</td>
							<td>${doc.docCtime}</td>
							<td>	<a href="doc/rename.do?docId=${doc.docId}">重命名</a>&nbsp;&nbsp;&nbsp;
									<a href="doc/remove.do?docId=${doc.docId}">删除</a></td>
						</tr>
					</c:forEach>
						 
						
					</tbody>
					<tfoot align="center">
					<tr >
					<td colspan="4">
						<span>
							总记录数：${requestScope.page.total_rows }条，当前第${requestScope.page.current_page }页，总共${requestScope.page.total_page }页
						</span>
						<c:if test="${requestScope.page.current_page==1 }">
						<span>首页</span>
						</c:if>
						<c:if test="${requestScope.page.current_page > 1 }">
						<a href="doc/list.do?current_page=1">首页</a>
						</c:if>
						<a href="doc/list.do?current_page=${requestScope.page.current_page-1}">上一页</a>
						<a href="doc/list.do?current_page=${requestScope.page.current_page +1}">下一页</a>
						<a href="doc/list.do?current_page=${requestScope.page.total_page }">尾页</a>
						<form action="doc/list.do" method="get" style="display:inline;">
							前往<input type="text" name="current_page" value="${requestScope.page.current_page }" style="width:50px;text-align:center;">页
							<input type="submit" value="GO">
						</form>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<a href="upload.html">上传文件</a>
					</td>
				</tr>
			</tfoot>
					
				</table>

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
</body>
</html>