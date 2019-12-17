<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>index.html</title>
<link rel="stylesheet" type="text/css" href="/Struts2/css/main.css">
<script src="/Struts2/js/fun.js" type="text/javascript"></script>
<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=GBK">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<style type="text/css">
body {
	text-align: center;
}

select {
	width: 173px;
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
			<h1>商品信息修改</h1>
			<form action="updateType" method="post" enctype="multipart/form-data">
				<input type="text" hidden="hidden" name="id" value="<s:property value="#session.user.id"/>">
				<input type="text" hidden="hidden" name="type.id"
					value="<s:property value="type.id"/>">  商品类型:<input
					type="text" name="type.typename"
					value="<s:property value="type.typename"/>" /><br />
				<br /> 商品名称:<input type="text" name="type.name"
					value="<s:property value="type.name"/>" /><br />
				<br /> 商品简介:<input type="text" name="type.introduction"
					value="<s:property value="type.introduction"/>" /><br />
				<br /> 商品图片:<img style="height: 50px"
					src="${pageContext.request.contextPath}/image/<s:property value="type.imageFileName"/>">
				<br>
				<br> <input type="file" name="image"
					value="<s:property value="type.imageFileName"/>" /><br />
				<br /> 商品价格：<input type="text" name="type.price"
					value="<s:property value="type.price"/>" /><br />
				<br /> <input type="text" hidden="hidden" name="type.number"
					value="<s:property value="type.number"/>" /><br />
				<br /> <input type="submit" value="提交" />
			</form>
		</div>
	</div>
</body>
</html>
