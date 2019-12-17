<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>index.html</title>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/Struts2/css/main.css">
<script src="/Struts2/js/fun.js" type="text/javascript"></script>
<script type="text/javascript">
   //提交检验
function checkForm(form) {
	var num = form.number.value;
	var patrn = /^[1-9][0-9]*$/;
	var pri = form.price.value;
	if (form.typename.value == "") {
		alert("请填写商品类型!");
		return false;
	} 
	else if (form.name.value == "") {
		alert("请填写商品名称！");
		return false;
	}  
	else if (form.introduction.value == "") {
		alert("请填写商品简介！");
		return false;
	}  
	else if (form.image.value == "") {
		alert("请上传商品图片！");
		return false;
	}  
	else if (!patrn.test(pri)) {
		alert("请填写商品价格！");
		return false;
	}  
	else if (!patrn.test(num)) {
		alert("请填写商品库存！");
		return false;
	}  
	 else {
		return true;
	}
}
</script>
<style type="text/css">
.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 88);
}

.white_content {
	display: none;
	position: absolute;
	top: 25%;
	left: 25%;
	width: 55%;
	height: 55%;
	padding: 20px;
	border: 10px solid orange;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}

table {
	background-color: black;
	width: 100%;
	text-align: center;
}

tr {
	background-color: white;
}

form {
	margin: 0px;
	display: inline
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
			<h4>商品信息如下：</h4>
			<a href="JavaScript:void(0)" onclick="openDialog()">添加商品</a>
			<table>
				<tr>
					<th>商品ID</th>
					<th>商品类型</th>
					<th>商品名称</th>
					<th>商品图片</th>
					<th>类型简介</th>
					<th>商品价格</th>
					<th>商品数量</th>
					<th>所属店铺</th>
					<th>操作</th>
					<th>商品最近操作时间</th>
				</tr>
				<s:iterator value="types">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="typename" /></td>
						<td><s:property value="name" /></td>
						<td><img
							src="${pageContext.request.contextPath}/image/${imageFileName}"
							style="width: 50px; height: 50px"></td>
						<td><s:property value="introduction" /></td>
						<td><s:property value="price" /></td>
						<td><s:if test="number<=10"><s:property value="number" /><p style="color: red">库存不足</p></s:if> <s:else><s:property value="number" /></s:else></td>
						<td><s:property value="user.name" /></td>
						<td>
							<form action="admindeleteType">
					        <input type="text" hidden="hidden" name="role" value="<s:property value="#session.user.role"/>">
					        <input type="text" hidden="hidden" name="id" value="<s:property value="#session.user.id"/>">
					        <input type="text" hidden="hidden" name="type.id" value="<s:property value="id"/>">
					        <input type="submit" value="删除"/>
					        </form>
					         <form action="adminselectType">
					        <input type="text" hidden="hidden" name="id" value="<s:property value="id"/>">
					        <input type="submit" value="修改"/>
					        </form>
					        <form action="adminup">
					        <input type="text" hidden="hidden" name="id" value="<s:property value="id"/>">
					        <input type="submit" value="进货"/>
					        </form>
					        <form action="adminout">
					        <input type="text" hidden="hidden" name="id" value="<s:property value="id"/>">
					        <input type="submit" value="出货"/>
					        </form>
						</td>
						<td><s:property value="date" /></td>
					</tr>
				</s:iterator>
			</table>
			<div id="light" class="white_content">
				<h1>添加商品</h1>
				<hr />
				<s:form action="adminaddType" method="post"
					enctype="multipart/form-data" onsubmit="return checkForm(this)"
					namespace="/">
					<s:textfield label="商品类型" id="typename" name="type.typename"
						value="" />
					<s:textfield label="商品名称" id="name" name="type.name" value="" />
					<s:textfield label="商品简介" id="introduction"
						name="type.introduction" value="" />
					<s:file label="商品图片" id="image" size="30" name="image" />
					<s:textfield label="商品价格" id="price" name="type.price" value="" />
					<s:textfield label="商品数量" id="number" name="type.number" value="" />
					<input type="text" name="type.us_id" hidden="hidden"
						value="<s:property value="#session.user.id"/>">
					<s:submit onclick="false" value="添加" />
					<s:reset value="重填" />
				</s:form>
				<a href="javascript:void(0)" onclick="closeDialog()">点这里关闭本窗口</a>
			</div>
			<div id="fade" class="black_overlay"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
        $(function(){
        })
        function openDialog(){
            document.getElementById('light').style.display='block';
            document.getElementById('fade').style.display='block'
        }
        function closeDialog(){
            document.getElementById('light').style.display='none';
            document.getElementById('fade').style.display='none'
        }
    </script>
</html>
