<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>login page</title>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/Struts2/css/main.css">
<script src="/Struts2/js/fun.js" type="text/javascript"></script>
<script type="text/javascript">
	//提交检验
	function checkForm(form) {
		var username = form.username.value;
		var reg = /^[a-zA-Z][a-zA-Z0-9]{3,15}$/; //用户名由英文字母和数字组成的4-16位字符，以字母开头
		var pwd = form.pwd.value;
		var repwd = form.repwd.value;
		var reg1 = /^[a-zA-Z0-9]{4,10}$/; //密码由英文字母和数字组成的4-10位字符
		var email = form.email.value;
		var reg2 = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/; //邮箱  例如web@sohu.com /w为可用于标识符的字符（不包括美元符号）
		var phone = form.phone.value;
		var reg3 = /^1\d{10}$/; //电话号码1开头其余为0~9长度为11的数字
		if (reg.test(username) == false) {
			alert("用户名不正确!");
			return false;
		} else if (reg1.test(pwd) == false) {
			alert("密码不正确！");
			return false;
		} else if (pwd != repwd) {
			alert("两次输入密码不一致！");
			return false;
		} else if (reg2.test(email) == false) {
			alert("邮箱不正确！");
			return false;
		} else if (reg3.test(phone) == false) {
			alert("号码不正确！");
			return false;
		} else {
			return true;
		}
	}
	$(function() {
		$("#username").blur(function() {
			//1、失去焦点，获得输入框的内容
			var usernameInput = $(this).val();
			//2、去服务端校验该用户名是否存在
			$.post("${pageContext.request.contextPath}/ajax.action", {
				"user.name" : usernameInput
			}, function(data) {
				var isExist = data.isExist;
				//3、根据返回的isExist动态地显示信息
				if (isExist) {
					//该用户存在
					alert('用户名已存在');
				}
			}, "json");
		});
	});
</script>
<style type="text/css">
body {
	text-align: center;
}

.middle {
	margin-top: 150px;
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
			<div class="middle">
				<form action="adminupdateUser" method="post"
					onsubmit="return checkForm(this)">
					<input type="text" hidden="hidden" name="user.id"
						value="<s:property value="#session.user.id"/>">
					<div>
						用户名&nbsp;&nbsp;&nbsp;&nbsp;：<input id="username" name="user.name"
							value="<s:property value="#session.user.name"/>" />
					</div>
					<span style="color: red;">*4-16位字符，以字母开头</span><br>
					<div>
						密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input
							type="password" id="pwd" name="user.pwd"
							value="<s:property value="#session.user.pwd"/>" />
					</div>
					<span style="color: red;">*英文字母和数字组成的4-10位字符</span><br>
					<div>
						确认密码：<input type="password" id="repwd" value="" />
					</div>
					<br>
					<div>
						邮箱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input id="email"
							name="user.email"
							value="<s:property value="#session.user.email"/>" />
					</div>
					<span style="color: red;">*例如web@sohu.com </span><br>
					<div>
						电话号码：<input id="phone" name="user.phone"
							value="<s:property value="#session.user.phone"/>" />
					</div>
					<span style="color: red;">*1开头其余为0~9长度为11的数字</span><br>
					<br> <input type="submit" onclick="false" value="提交" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="reset" value="重填" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
