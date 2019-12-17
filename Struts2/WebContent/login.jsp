<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>商品信息管理系统</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<h2>
		<a href="index.jsp">请选择登录方式</a>
	</h2>
	<div class="login">
		<c:choose>
			<c:when test="${param.type == 'admin'}">
				<div class="login1">
					<form action="login" method="post" class="login" name="login">
						<div class="login_sr">
							管理员登录<br /> <br /> <input type="hidden" name="type"
								value="admin"> <input type="text" name="name" id="aname"
								class="login_zh" placeholder="管理员账号"></input> <br> <br>
							<input type="password" name="pwd" id="apassword" class="mm"
								placeholder="密码"></input><br> <br> <input name="code"
								id="code" class="code" placeholder="验证码" /><br> <br>
							&nbsp;&nbsp;<img id="num" src="<s:url value="/user/yanzhengma"/>" />
						</div>
						<br> <br>
						<div class="login_submit">
							<input type="submit" value="登录" /> <input type="reset"
								value="重填" />
						</div>
					</form>
				</div>
			</c:when>

			<c:when test="${param.type == 'merchants'}">
				<div class="login1">
					<form action="login" method="post" class="login" name="login">
						<div class="login_sr">
							商家登录<br /> <br /> <input type="hidden" name="type"
								value="merchants"><input type="text" name="name"
								id="aname" class="login_zh" placeholder="商家账号"></input> <br>
							<br> <input type="password" name="pwd" id="apassword"
								class="mm" placeholder="密码"></input><br> <br> <input
								name="code" id="code" class="code" placeholder="验证码" /><br>
							<br> &nbsp;&nbsp;<img id="num"
								src="<s:url value="/user/yanzhengma"/>" /><br /> <br /> <a
								href="<s:url value="/register.jsp"/>">还没有账号，去注册</a>
						</div>
						<br> <br>
						<div class="login_submit">
							<input type="submit" value="登录" /> <input type="reset"
								value="重填" />
						</div>
					</form>
				</div>
			</c:when>

			<c:when test="${param.type == 'clients'}">
				<div class="login1">
					<form action="login" method="post" class="login" name="login">
						<div class="login_sr">
							用户登录<br /> <br /> <input type="hidden" name="type"
								value="clients"><input type="text" name="name"
								id="aname" class="login_zh" placeholder="用户账号"></input> <br>
							<br> <input type="password" name="pwd" id="apassword"
								class="mm" placeholder="密码"></input><br> <br> <input
								name="code" id="code" class="code" placeholder="验证码" /><br>
							<br> &nbsp;&nbsp;<img id="num"
								src="<s:url value="/user/yanzhengma"/>" /><br /> <br /> <a
								href="<s:url value="/register.jsp"/>">还没有账号，去注册</a>
						</div>
						<br> <br>
						<div class="login_submit">
							<input type="submit" value="登录" /> <input type="reset"
								value="重填" />
						</div>
					</form>
				</div>
			</c:when>
		</c:choose>
	</div>
</body>