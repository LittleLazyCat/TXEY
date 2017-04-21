<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/note.css" />

<script src="<%=request.getContextPath()%>/js/note.js"></script>
<title>添加记录</title>
</head>
<body>
	<div class="contain_note">
		<div class="head_input">
			<div class="form">
				<form>
					<div>
						<select id="select1" style="width: 100%;">
							<option id="-1" value="1">1</option>
							<c:forEach var="dept" items="${deptList}">
								<option id="${dept.ksid}" value="${dept.ksmc}">${dept.ksmc}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<input type="text" id="txt_note" />
					</div>

					<div>
						<input type="button" id="btn_add" value="添加便签" />
					</div>

				</form>
			</div>
		</div>
		<div class="body_notes">
			<ul id="note">
			</ul>
		</div>
	</div>
	<div id="background">
		<img id="img_background" width="100%" height="100%" />
	</div>
</body>
</html>