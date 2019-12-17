<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>index.html</title>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/Struts2/css/main.css">
<script src="/Struts2/js/fun.js" type="text/javascript"></script>
<style type="text/css">
.box {
	text-align: center;
}

　　　　　　* {
	margin: 0;
	padding: 0;
	border: 0;
	outline: 0
}

ul, li {
	list-style: none;
}

a {
	text-decoration: none;
}

a:hover {
	cursor: pointer;
	text-decoration: none;
}

a:link {
	text-decoration: none;
}

img {
	vertical-align: middle;
}

li .number, .kucun {
	display: inline-block;
	font-size: 12px;
	color: #808080;
	vertical-align: sub;
}

.count .num-jian, .input-num, .num-jia {
	display: inline-block;
	width: 28px;
	height: 28px;
	line-height: 28px;
	text-align: center;
	font-size: 18px;
	color: #999;
	cursor: pointer;
	border: 1px solid #e6e6e6;
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
			<h1>支付页</h1>
			<h4>订单如下</h4>
			<form action="clientssubmitOrder" method="post">
							<input type="text" hidden="hidden" name="id" value="<s:property value="type.id"/>">
							<input type="text" hidden="hidden" name="order.ty_id"
								value="<s:property value="order.ty_id"/>"> <input
								type="text" name="order.us_id" hidden="hidden"
								value="<s:property value="order.us_id"/>"> <input
								type="text" hidden="hidden" name="order.me_id"
								value="<s:property value="order.me_id"/>"> <input
								type="text" hidden="hidden" name="order.tag" value="<s:property value="order.tag"/>" /> 
							商品单价：<input type="text" hidden="hidden" name="order.ty_price" value="<s:property value="order.ty_price"/>">
							<s:property value="order.ty_price"/>
							<br>
							订单数量：<input type="text" hidden="hidden" name="order.number" value="<s:property value="order.number"/>">
							<s:property value="order.number"/>
							<br>
							订单总价：<input type="text" hidden="hidden" name="order.totalPrice" value="<s:property value="order.totalPrice"/>">
							<s:property value="order.totalPrice"/>
							<br>
							收件人：<input type="text" hidden="hidden" name="order.name" value="<s:property value="order.name"/>">
							<s:property value="order.name"/>
							<br> 
							收件电话：<input type="text" hidden="hidden" name="order.phone" value="<s:property value="order.phone"/>">
							<s:property value="order.phone"/>
							<br> 
							收件地址：<input type="text" hidden="hidden" name="order.address" value="<s:property value="order.address"/>">
							<s:property value="order.address"/>
							<br> 
							<br>
							<br>
						<input type="submit" value="立即支付" />
						</form>
			</div>
		</div>
</body>
</html>
