<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>index.html</title>
<link rel="stylesheet" type="text/css" href="/Struts2/css/main.css">
<script src="/Struts2/js/fun.js" type="text/javascript"></script>
<style type="text/css">
#main3 {
	background: #ffffff;
	display: inline;
}

#text {
	display: inline;
	background: #eff7ff;
	margin-left: 20px;
	float: right;
	margin-right: 50px;
	font-size: 35px;
}

#jiage {
	background: #AAAAAA;
	height: 30px;
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

.btn-numbox {
	overflow: hidden;
	margin-top: 20px;
}

.btn-numbox li {
	float: left;
}

.btn-numbox li .number, .kucun {
	display: inline-block;
	font-size: 12px;
	color: #808080;
	vertical-align: sub;
}

.btn-numbox .count {
	overflow: hidden;
	margin: 0 16px 0 -20px;
}

.btn-numbox .count .num-jian, .input-num, .num-jia {
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

.btn-numbox .count .input-num {
	width: 58px;
	height: 26px;
	color: #333;
	border-left: 0;
	border-right: 0;
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
			<h1>详情页</h1>
			<div id="main3">
				<img style="height: 40%"
					src="${pageContext.request.contextPath}/image/<s:property value="type.imageFileName"/>">
				<div id="text">
					商品简介
					<s:property value="type.introduction" />
				</div>
				<a
					href="<s:url value="order/selectTypeOrders"/>?id=<s:property value="#session.user.id"/>">
					<s:iterator value="type">
						<div style="height: 150px; width: 25%; float: left;">
							店铺名：
							<s:property value="user.name" />
							<br> 联系电话：
							<s:property value="user.phone" />
							<br> 商家邮箱：
							<s:property value="user.email" />
							<br>
							<h4>联系商家</h4>
						</div>
					</s:iterator>
				</a>
				<div id="jiage">
					商品价格￥：
					<s:property value="type.price" />
				</div>
				<ul class="btn-numbox">
					<li><span class="number">数量</span></li>
					<li>
						<ul class="count">
							<li><span id="num-jian" class="num-jian">-</span></li>
							<li><s:form action="adminbuyData" method="post">
									<input type="text" hidden="hidden" name="type.id"
										value="<s:property value="type.id"/>">
									<s:textfield class="input-num" id="input-num"
										name="order.number" value="0" />
									<s:submit value="立即购买" />
								</s:form>
								<s:form action="admincollect" method="post">
								<input type="text" hidden="hidden" name="id" value="<s:property value="type.id"/>">
								<input type="text" hidden="hidden" name="collect.ty_id" value="<s:property value="type.id"/>">
								<input type="text" hidden="hidden" name="collect.price" value="<s:property value="type.price"/>">
								<input type="text" hidden="hidden" name="collect.me_id" value="<s:property value="type.us_id"/>">
								<input type="text" hidden="hidden" name="collect.us_id" value="<s:property value="#session.user.id"/>">
								<input type="text" hidden="hidden" name="collect.ty_name" value="<s:property value="type.name"/>">
								<input type="text" hidden="hidden" name="collect.introduction" value="<s:property value="type.introduction"/>">
								<input type="text" hidden="hidden" name="collect.imageFileName" value="<s:property value="type.imageFileName"/>">
									<s:submit value="立即收藏" />
								</s:form></li>
							<li><span id="num-jia" class="num-jia">+</span></li>
						</ul>
					</li>
					<li><span class="kucun">（库存:<s:property
								value="type.number" />）
					</span></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
  var num_jia = document.getElementById("num-jia");
  var num_jian = document.getElementById("num-jian");
  var input_num = document.getElementById("input-num");

  num_jia.onclick = function() {

      input_num.value = parseInt(input_num.value) + 1;
  }

  num_jian.onclick = function() {

      if(input_num.value <= 0) {
          input_num.value = 0;
      } else {

          input_num.value = parseInt(input_num.value) - 1;
      }

  }
  $("body").on("click",".num-jian",function (m) {
        var obj = $(this).closest("ul").find(".input-num");
        if (obj.val() <= 0) {
             obj.val(0);
        } else {
             obj.val(parseInt(obj.val()) - 1);
        }
        obj.change();
  });
  $("body").on("click",".num-jia",function (m) {
        var obj = $(this).closest("ul").find(".input-num");
        obj.val(parseInt(obj.val()) + 1);
        obj.change();
  });
    </script>
</html>
