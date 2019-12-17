<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>index.html</title>
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
			<h1>出入库页</h1>
			<table>
				<tr>
					<th>商品ID</th>
					<th>商品类型</th>
					<th>商品名称</th>
					<th>出/入库</th>
					<th>商品单价</th>
					<th>出/入库数量</th>
					<th>总价</th>
					<th>商品图片</th>
					<th>出/入库时间</th>
				</tr>
				<s:iterator value="orders">
					<tr>
						<td><s:property value="type.id" /></td>
						<td><s:property value="type.typename" /></td>
						<td><s:property value="type.name" /></td>
						<td><s:if test="tag>0">入库</s:if> <s:else>出库</s:else></td>
						<td><s:property value="type.price" /></td>
						<td><s:property value="number" /></td>
						<td><s:if test="tag==0"><s:property value="totalPrice" /></s:if></td>
						<td><img
							src="${pageContext.request.contextPath}/image/${type.imageFileName}"
							style="width: 50px; height: 50px"></td>
						<td><s:property value="date" /></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
</body>
</html>
