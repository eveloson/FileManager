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
th{align}
</style>
</head>
<body>
	<fieldset align="center" class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>我的文件</legend>
</fieldset>  
		<div>
			<table align="center" class="layui-table" lay-skin="line">
		<%-- 		  <colgroup>
				    <col width="150">
				    <col width="150">
				    <col width="200">
				    <col>
				  </colgroup> --%>
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
							<a href="doc/download.do?doc_id=${doc.doc_id}">
							<img src="resource/img/file.png" style="width: 20px;height: 20px;display: inline;">
							${doc.doc_name_o}
							</a>
						</td>
						<td>${doc.doc_size}</td>
						<td>${doc.doc_ctime}</td>
						<td>	<a href="dorename.do?doc_id=${doc.doc_id}">重命名</a>&nbsp;&nbsp;&nbsp;
								<a href="doremove.do?doc_id=${doc.doc_id}">删除</a></td>
					</tr>
				</c:forEach>
					 
					
				</tbody>
				<tfoot align="center">
				<tr >
				<td colspan="6">
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
					&nbsp;&nbsp;&nbsp;
					<a href="doc/upload.do">上传文件</a>
				</td>
			</tr>
		</tfoot>
				
			</table>
			
		</div>	
	<!--<script src="" type="text/javascript" charset="utf-8"></script>-->
</body>
</html>