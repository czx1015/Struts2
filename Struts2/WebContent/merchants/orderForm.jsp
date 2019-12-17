<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>index.html</title>
<link rel="stylesheet" type="text/css" href="/Struts2/css/main.css">
<script src="/Struts2/js/fun.js" type="text/javascript"></script>
<style type="text/css">
#box {
	width: 40%;
	height: 350px;
	margin-top: 40px;
	color: red;
	background: #CCCCFF;
	float: left;
	margin-left: 6%;
}
</style>
</head>
<body>
	<div class="main">
		<div class="main_left" id="frmTitle">
			<jsp:include page="merchantsLeft.jsp" />
		</div>
		<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>
		<div class="main1">
			<h1>个人订单页</h1>
			<s:iterator value="orders">
				<div id="box">
					商品类型:
					<s:property value="type.typename" />
					商品名称:
					<s:property value="type.name" />
					商品简介:
					<s:property value="type.introduction" />
					<br />
					<br /> 商品图片:<img style="height: 50px"
						src="${pageContext.request.contextPath}/image/<s:property value="type.imageFileName"/>">
					<br>
					<br> 商品价格：
					<s:property value="type.price" />
					<br /> 订单数量：
					<s:property value="number" />
					<br>
					共计：<s:property value="totalPrice" />元
					<br /><br /> 收件人：
					<s:property value="name" />
					电话：
					<s:property value="phone" />
					<br /> 地址：
					<s:property value="address" />
					<br /> 下单时间：
					<s:property value="date" />
					<br /> 订单编号：
					<s:property value="id" />
					<br />
					<form action="deleteOrdert">
							<input type="text" hidden="hidden" name="id" value="<s:property value="#session.user.id"/>">
					        <input type="text" hidden="hidden" name="order.id" value="<s:property value="id"/>">
					        <input type="text" hidden="hidden" name="order.ty_id" value="<s:property value="type.id"/>">
					        <input type="text" hidden="hidden" name="order.number" value="<s:property value="number"/>">
					        <input type="text" hidden="hidden" name="order.tag" value="<s:property value="tag"/>">
					        <input type="submit" value="取消订单"/>
					</form>
				</div>
			</s:iterator>
		</div>
	</div>
</body>
</html>
