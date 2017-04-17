<%@page import="com.netease.login.model.User,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login success</title>
</head>
<body>
	<%
		String username = (String)request.getAttribute("user");
		Date date = new Date();
		int hours = date.getHours();
		if (hours < 11 && hours >= 0) {
			out.print("早上好，");
		} else if (hours < 14) {
			out.print("中午好，");
		} else if (hours < 18) {
			out.print("下午好，");
		} else {
			out.print("晚上好，");
		}
		out.print(username);
		//2-10,11-13,14-17,18-1
	%>

	<p><button onclick="javascript:window.location.href=('./logout')" >退出</button></p>
</body>
</html>