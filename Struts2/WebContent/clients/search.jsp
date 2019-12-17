<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>展示页</title>
<link rel="stylesheet" type="text/css" href="/Struts2/css/main.css">
<script src="/Struts2/js/fun.js" type="text/javascript"></script>
<style type="text/css">
#box {
	width: 250px;
	height: 170px;
	background: #ffffff;
	display: inline;
}

#box1 {
	display: inline;
	float: left;
	border: 1px solid #ffffff;
	background: #eff7ff;
	margin-left: 20px;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="main">
		<div class="main_left" id="frmTitle">
			<jsp:include page="clientsLeft.jsp" />
		</div>
		<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>
		<div class="main1">
			<div class="container" style="text-align: center;">
				<form action="clientssearch" method="post">
					<input type="text" name="type.name" placeholder="请输入关键字"
						style="width: 300px; height: 30px;"> <input type="submit"
						value="搜索" style="width: 50px; height: 30px;">
				</form>
			</div>
			<div id="box">
				<s:iterator value="types">
					<div id="box1">
						<a
							href="<s:url value="/type/admindetails"/>?id=<s:property value="id"/>">
							<img
							src="${pageContext.request.contextPath}/image/${imageFileName}"
							style="width: 250px; height: 200px"> <br> <s:property
								value="introduction" /><br> 价格￥<s:property value="price" /><br>
							<s:property value="user.name" />
						</a>
					</div>
				</s:iterator>
			</div>
		</div>
	</div>
</body>
</html>
