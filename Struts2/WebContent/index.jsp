<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品信息管理系统</title>

<link rel="stylesheet" type="text/css" href="css/main.css">



</head>
<body>
	<div class="index">
		<form action="login.jsp" class="index_admin">
			<input type="hidden" name="type" value="admin"> <input
				type="submit" value="管理员登录" />
		</form>

		<form action="login.jsp" class="index_merchants">
			<input type="hidden" name="type" value="merchants"> <input
				type="submit" value="商家登录" />
		</form>

		<form action="login.jsp" class="index_clients">
			<input type="hidden" name="type" value="clients"> <input
				type="submit" value="用户登录" />
		</form>
	</div>

</body>
</html>