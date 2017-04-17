<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<form method="post" action="login">
		<input type="hidden" name="origUrl" value="${origUrl}" />
		<c:if test="${not empty errInfo}">
			<p style="color: red;">${errInfo}</p>
		</c:if>
		<p>
			username:<input type="text" name="name">
		</p>
		<p>
			password:<input type="password" name="password">
		</p>
		<p>
			<input type="submit" value="登录" />
		</p>
	</form>
</body>
</html>