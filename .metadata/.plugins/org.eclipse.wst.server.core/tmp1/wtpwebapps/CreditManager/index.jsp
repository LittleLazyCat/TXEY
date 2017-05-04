<%@ page language="java" import="java.util.*, com.gvtv.manage.base.util.Const"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty sessionScope.sessionUser}">
<jsp:forward page="/sys/index" />
</c:if>
<c:if test="${empty sessionScope.sessionUser}">
<jsp:forward page="/login_toLogin" />
</c:if>