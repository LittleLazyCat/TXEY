<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
<title>快易收管理平台</title>

<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="${ctx}/static/AdminLTE/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/AdminLTE/plugins/bootstrapDialog/bootstrap-dialog.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/AdminLTE/plugins/datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/AdminLTE/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css">
<!-- Font Awesome Icons -->
<link href="${ctx}/static/AdminLTE/dist/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<%-- <!-- Ionicons -->
<link
	href="${ctx}/static/AdminLTE/dist/css/ionicons.min.css"
	rel="stylesheet" type="text/css" /> --%>
<!-- Theme style -->
<link href="${ctx}/static/AdminLTE/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/AdminLTE/dist/css/skins/skin-blue.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/AdminLTE/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/AdminLTE/plugins/iCheck/minimal/blue.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/adjust.css" rel="stylesheet" type="text/css">

</head>
<body class="skin-blue" data-spy="scroll" data-target="#scrollspy">

	<div class="wrapper">
		<jsp:include page="../module/header.jsp"></jsp:include>
		<jsp:include page="../module/menu_side.jsp"></jsp:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" id="navTab"></div>
		<!-- /.content-wrapper -->

		<jsp:include page="../module/footer.jsp"></jsp:include>
		<jsp:include page="../module/control-sidebar.jsp"></jsp:include>
	</div>
	<!-- ./wrapper -->


	<!-- jQuery 2.1.4 -->
	<script src="${ctx}/static/AdminLTE/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="${ctx}/static/AdminLTE/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="${ctx}/static/AdminLTE/dist/js/app.min.js" type="text/javascript"></script>
	<!-- SlimScroll 1.3.0 -->
	<script src="${ctx}/static/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
	<!-- jquery form 3.51.0 -->
	<script src="${ctx}/static/js/jquery.form.min.js" type="text/javascript"></script>
	<!-- jquery valid 1.13.1 -->
	<script src="${ctx}/static/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/jquery-gv-validate.js" type="text/javascript"></script>
	<script src="${ctx}/static/AdminLTE/plugins/datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script src="${ctx}/static/AdminLTE/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<!-- DataTables plugin -->
	<script src="${ctx}/static/AdminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="${ctx}/static/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="${ctx}/static/AdminLTE/plugins/iCheck/icheck.min.js"></script>
	<script src="${ctx}/static/AdminLTE/plugins/bootstrapDialog/bootstrap-dialog.min.js"></script>

	<!-- custom js -->
	<script src="${ctx}/static/js/admin.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/gv.common.js"></script>
	<script src="${ctx}/static/kindeditor/kindeditor-min.js" charset="utf-8" ></script>
	<script src="${ctx}/static/kindeditor/lang/zh_CN.js" charset="utf-8" ></script>
</body>
</html>