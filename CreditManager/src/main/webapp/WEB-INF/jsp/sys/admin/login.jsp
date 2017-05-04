<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
<link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
<title>管理后台登录</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap 3.3.4 -->
<link href="${ctx}/static/AdminLTE/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- jQuery 2.1.4 -->
<script src="${ctx}/static/AdminLTE/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script src="${ctx}/static/js/jquery.cookie.js"></script>
<script src="${ctx}/static/js/jquery.tips.js"></script>
</head>
<body style="background-color: #ecf0f5;">
	<div class="container" style="margin-top: 50px;">
		<div class="row">

			<div class="col-md-4 col-md-offset-4">
				<div id="testmsg" class="login-panel panel panel-default">
					<div class="panel-heading" id="test1">
						<h3 class="panel-title">
							<fmt:message key="sys.user.plogin" />
						</h3>
					</div>
					<div class="panel-body" id="loginbox">
						<form role="form" method="post" action="" name="loginForm"
							id="loginForm">
							<fieldset>
								<!-- 								<div class="form-group"> -->
								<!-- 									<div class="dropdown"> -->
								<!-- 									  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true"> -->
								<%-- 										   <c:set var="locale" value="<%=request.getParameter(\"locale\")%>" /> --%>
								<%-- 										   <c:choose> --%>
								<%-- 										   	<c:when test="${locale eq 'zh'}">中文</c:when> --%>
								<%-- 										   	<c:when test="${locale eq 'en'}">English</c:when> --%>
								<%-- 										   	<c:otherwise>语言</c:otherwise> --%>
								<%-- 										   </c:choose> --%>
								<!-- 									    <span class="caret"></span> -->
								<!-- 									  </button> -->
								<!-- 									  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1"> -->
								<!-- 									    <li role="presentation"><a  href="?locale=zh">中文</a></li> -->
								<!-- 									    <li role="presentation"><a  href="?locale=en">English</a></li> -->
								<!-- 									  </ul> -->
								<!-- 									</div> -->
								<!-- 								</div> -->
								<div class="form-group">
									<input class="form-control" placeholder="请输入用户名" id="loginName"
										name="loginName" type="text" />

								</div>
								<div class="form-group">
									<input class="form-control" placeholder="请输入密码" name="password"
										id="password" type="password" />

								</div>
								<div class="form-group">
									<input class="form-control" placeholder="验证码" type="text"
										id="code" name="code" style="width: 30%; float: left;">
									<img id="codeImg" alt="点击更换" title="点击更换"
										style="width: 40%; height: 34px; margin-left: 12px;" src="">
								</div>
								<!-- 								<div class="checkbox"> -->
								<!-- 									<label> <input name="rememberMe" onclick="savePaw();" -->
								<!-- 										type="checkbox" value="Remember Me">Remember Me -->
								<!-- 									</label> -->
								<!-- 								</div> -->
								<div class="row">
									<div class="col-md-5">
										<button type="button" onclick="severCheck();" class="btn btn-primary btn-block btn-flat"><fmt:message key="sys.user.login" /></button>
									</div>
									<!-- /.col -->
								</div>
<%-- 								<div class="form-group">

									<input type="button"
										value="<fmt:message key="sys.user.login" />"
										onclick="severCheck();"
										class="btn btn-lg btn-success btn-block">
								</div> --%>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
		<!-- Bootstrap 3.3.2 JS -->
	<script src="${ctx}/static/AdminLTE/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
<script type="text/javascript">
	//服务器校验
	function severCheck() {
		if (check()) {

			var loginName = $("#loginName").val();
			var password = $("#password").val();
			var code = "ksbadmtn1f2izwqy" + loginName + ",00," + password
					+ "ipvb5cxat0zn9eg7" + ",00," + $("#code").val();
			$.ajax({
				type : "POST",
				url : 'login_login',
				data : {
					keyData : code,
					tm : new Date().getTime()
				},
				dataType : 'json',
				cache : false,
				success : function(data) {

					console.log(data);

					if ("success" == data.result) {
						saveCookie();
						window.location.href = "<%=basePath%>";
					} else if ("usererror" == data.result) {
						$("#loginName").tips({
							side : 1,
							msg : "用户名或密码有误",
							bg : '#FF5080',
							time : 15
						});
						$("#loginName").focus();
					} else if ("codeerror" == data.result) {
						$("#code").tips({
							side : 1,
							msg : "验证码输入有误",
							bg : '#FF5080',
							time : 15
						});
						changeCode();
						$("#code").focus();
					} else {
						$("#loginName").tips({
							side : 1,
							msg : "缺少参数",
							bg : '#FF5080',
							time : 15
						});
						$("#loginName").focus();
					}
				}
			});
		}
	}

	$(document).ready(function() {
		changeCode();
		$("#codeImg").bind("click", changeCode);
	});

	$(document).keyup(function(event) {
		if (event.keyCode == 13) {
			$("#to-recover").trigger("click");
		}
	});

	function genTimestamp() {
		var time = new Date();
		return time.getTime();
	}

	function changeCode() {
		$("#codeImg").attr("src", "code?t=" + genTimestamp());
	}

	//客户端校验
	function check() {

		if ($("#loginName").val() == "") {

			$("#loginName").tips({
				side : 2,
				msg : '用户名不得为空',
				bg : '#AE81FF',
				time : 3
			});

			$("#loginName").focus();
			return false;
		} else {
			$("#loginName").val(jQuery.trim($('#loginName').val()));
		}

		if ($("#password").val() == "") {

			$("#password").tips({
				side : 2,
				msg : '密码不得为空',
				bg : '#AE81FF',
				time : 3
			});

			$("#password").focus();
			return false;
		}
		if ($("#code").val() == "") {

			$("#code").tips({
				side : 1,
				msg : '验证码不得为空',
				bg : '#AE81FF',
				time : 3
			});

			$("#code").focus();
			return false;
		}

		$("#loginbox").tips({
			side : 1,
			msg : '正在登录 , 请稍后 ...',
			bg : '#68B500',
			time : 10
		});

		return true;
	}

	function savePaw() {
		if (!$("#saveid").attr("checked")) {
			$.cookie('loginName', $("#loginName").val(), {
				expires : -1
			});
			$.cookie('password', $("#password").val(), {
				expires : -1
			});
			//$("#loginName").val('');
			//$("#password").val('');
		}
	}

	function saveCookie() {
		if ($("#saveid").attr("checked")) {
			$.cookie('loginName', $("#loginName").val(), {
				expires : 7
			});
			$.cookie('password', $("#password").val(), {
				expires : 7
			});
		}
	}
	function quxiao() {
		$("#loginName").val('');
		$("#password").val('');
	}

	jQuery(function() {
		var loginName = $.cookie('loginName');
		var password = $.cookie('password');
		if (typeof (loginName) != "undefined"
				&& typeof (password) != "undefined") {
			$("#loginName").val(loginName);
			$("#password").val(password);
			$("#saveid").attr("checked", true);
			$("#code").focus();
		}
	});
</script>
<script>
	//TOCMAT重启之后 点击左侧列表跳转登录首页 
	if (window != top) {
		top.location.href = location.href;
	}
</script>
</html>