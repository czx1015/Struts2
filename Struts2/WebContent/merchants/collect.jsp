<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>展示页</title>
<link rel="stylesheet" type="text/css" href="/Struts2/css/main.css">
<script src="/Struts2/js/fun.js" type="text/javascript"></script>
<style type="text/css">
a {
	font-size: 16px
}

a:link {
	color: blue;
	text-decoration: none;
}

#box {
	width: 23%;
	height: 170px;
	background: #ffffff;
	display: inline;
}

#box1 {
	display: inline;
	float: left;
	border: 1px solid #ffffff;
	background: #eff7ff;
	margin-left: 2%;
	margin-top: 20px;
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
			<div id="box">
				<s:iterator value="collects">
					<div id="box1">
						<a
							href="<s:url value="/type/merchantsdetails"/>?id=<s:property value="ty_id"/>">
							<img
							src="${pageContext.request.contextPath}/image/${imageFileName}"
							style="width: 250px; height: 200px"><br> <s:property
								value="ty_name" /> : <s:property
								value="introduction" /><br> 价格￥<s:property value="price" /><br>
							收藏时间：<s:property value="date" /><br>
							<s:if test="us_id!=#session.user.id">收藏的用户：<s:property value="us_id" /></s:if>
							<s:else>本号收藏</s:else>
						</a>
						<form action="deleteCollect">
							<input type="text" hidden="hidden" name="id" value="<s:property value="#session.user.id"/>">
					        <input type="text" hidden="hidden" name="collect.us_id" value="<s:property value="us_id"/>">
					        <input type="text" hidden="hidden" name="collect.ty_id" value="<s:property value="ty_id"/>">
					        <input type="submit" value="取消收藏"/>
					    </form>
					</div>
				</s:iterator>
			</div>
		</div>
	</div>
</body>
</html>
