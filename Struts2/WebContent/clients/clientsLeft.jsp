<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags" %>


你好！
<s:property value="#session.user.name" />
&nbsp;&nbsp;
<a href="/Struts2/index.jsp">注销</a>


<div class="page">
	<section class="demo">
		<ul class="menu">
			<li><a href="<s:url value="user/clientsIndex"/>"><strong>首页</strong></a>
				<br>
			<li><a
				href="<s:url value="order/clientsselectTypeOrders"/>?id=<s:property value="#session.user.id"/>"><strong>我的订单</strong></a>
				<br>
			<li><a
				href="<s:url value="collect/selectclientsCollect"/>?id=<s:property value="#session.user.id"/>"><strong>我的收藏</strong></a>
				<br>
			<li><a
				href="<s:url value="/user/clientsselectUser"/>?id=<s:property value="#session.user.id"/>"><strong>修改个人信息</strong></a>
				<br>
		</ul>
	</section>

</div>