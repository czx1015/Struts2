<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>index.html</title>

<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="/Struts2/css/main.css">
<script src="/Struts2/js/fun.js" type="text/javascript"></script>
<style type="text/css">
table {
	background-color: black;
	width: 100%;
	text-align: center;
}

tr {
	background-color: white;
}
</style>

</head>

<body>
	<div class="main">
		<div class="main_left" id="frmTitle">
			<jsp:include page="adminLeft.jsp" />
		</div>
		<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>
		<div class="main1">
			<h3>用户信息</h3>
			<a href="user/add">添加用户</a>
			<table>
				<tr>
					<th>用户ID</th>
					<th>用户名</th>
					<th>密码</th>
					<th>邮箱</th>
					<th>电话</th>
					<th>用户类型</th>
					<th>操作</th>
				</tr>
				<s:iterator value="users">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="pwd" /></td>
						<td><s:property value="email" /></td>
						<td><s:property value="phone" /></td>
						<td><s:if test="role>0">普通用户</s:if> <s:else>商家</s:else></td>
						<td><a
							href="<s:url value="/user/deleteUser"/>?id=<s:property value="id"/>">删除</a>
							<a
							href="<s:url value="/user/adminselectUser"/>?id=<s:property value="id"/>">修改</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</body>
</html>
