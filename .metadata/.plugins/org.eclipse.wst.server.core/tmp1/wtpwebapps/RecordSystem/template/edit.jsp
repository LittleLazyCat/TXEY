<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/zzsc-demo.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/tinyselect.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/note.css" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
<script src="<%=request.getContextPath()%>/js/note.js"></script>
<title>添加记录</title>
</head>
<body>
	<form action="addRecord.html" method="post">
		<div class="zzsc-container">
			<div class="zzsc-content">
				<div class="row">
					<div class="cell">
						<div class="desc">报修科室</div>
						<select id="dept" name="dept" style="width: 100%;">
							<c:forEach var="dept" items="${deptList}">
								<option id="${dept.ksid}" value="${dept.ksid}">${dept.ksmc}</option>
							</c:forEach>
						</select>
					</div>
					<div class="cell">
						<div class="desc">联系方式</div>
						<select id="contact" name="contact" style="width: 100%;">
							<c:forEach var="contact" items="${contactList}">
								<option id="${contact.lyid}" value="${contact.lyid}">${contact.lymc}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="cell">
						<div class="desc">问题类型</div>
						<select id="kind" name="kind" style="width: 100%;">
							<c:forEach var="kind" items="${kindList}">
								<option id="${kind.lxid}" value="${kind.lxid}">${kind.lxmc}</option>
							</c:forEach>
						</select>
					</div>
					<div class="cell">
						<div class="desc">接收人员</div>
						<select id="employee" name="employee" style="width: 100%;">
							<c:forEach var="employee" items="${employeeList}">
								<option id="${employee.ygid}" value="${employee.ygid}">${employee.ygxm}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row">

					<div class="cell">
						<div class="desc">问题来源</div>
						<select id="method" name="method" style="width: 100%;">
							<c:forEach var="method" items="${methodList}">
								<option id="${method.fsid}" value="${method.fsid}">${method.fsmc}</option>
							</c:forEach>
						</select>
					</div>
					<div class="cell">
						<div class="desc">修复时间</div>
						<select id="time" name="time" style="width: 100%;">
							<c:forEach var="time" items="${timeList}">
								<option id="${time.sjid}" value="${time.sjid}">${time.sjmc}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="cell">
						<div class="desc">问题情况说明</div>
						<div class="fmitem">
							<div class="fmipt">
								<textarea class="u-ipt" id="wtms" name="wtms" rows="10"></textarea>
							</div>
						</div>
					</div>
					<div class="cell">
						<div class="desc">维修备注</div>
						<div class="fmitem">
							<div class="fmipt">
								<textarea class="u-ipt" id="wxbz" name="wxbz" rows="10"></textarea>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

		<script src="<%=request.getContextPath()%>/js/jquery-1.11.0.min.js"
			type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/tinyselect.js"></script>
		<script>
			/* Create select elements */
			$("#dept").tinyselect();
			$("#contact").tinyselect({
				showSearch : false
			});

			$("#kind").tinyselect({
				showSearch : false
			});

			$("#employee").tinyselect({
				showSearch : false
			});
			$("#method").tinyselect({
				showSearch : false
			});

			$("#time").tinyselect({
				showSearch : false
			});

			$("#havoc").show()
		</script>
		<div style="text-align: center;">
			<input type="submit" id="btn_add" value="添加记录" />
		</div>

		<div
			style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei';">
			<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗.
				不支持IE8及以下浏览器。</p>
			<p>
				来源：<a href="http://172.16.1.11:8080" target="_blank">桐乡二院</a>
			</p>
		</div>
	</form>
</body>
</html>