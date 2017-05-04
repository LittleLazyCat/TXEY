<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Main Header -->
<header class="main-header">

	<!-- Logo -->
	<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>快易收</b></span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>快易收</b>后台</span>
	</a>

	<!-- Header Navbar -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<a href="javascript:;" class="sidebar-toggle" data-toggle="offcanvas"
			role="button" style="font-size :14px;padding-bottom: 9px;"> <span class="sr-only">导航开关</span>
		</a>
		<!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="javascript:;" class="dropdown-toggle"
					data-toggle="dropdown"> <!-- The user image in the navbar--> <img
						src="${pageContext.request.contextPath}/static/AdminLTE/dist/img/user.jpg" class="user-image"
						alt="User Image" /> <!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-xs">${user.name}</span>
				</a>
					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header"><img src="${pageContext.request.contextPath}/static/AdminLTE/dist/img/user.jpg"
							class="img-circle" alt="User Image" />
							<p>
								${user.name} <small>上次登录${user.lastLogin}</small>
							</p></li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="javascript:;" data-url="user/editPwd" data-model='dialog' class="btn btn-default btn-flat">修改密码</a>
							</div>
							<div class="pull-right">
								<a href="logout" class="btn btn-default btn-flat">退出</a>
							</div>
						</li>
					</ul>
				</li>
				<!-- Control Sidebar Toggle Button -->
				<li><a href="javascript:;" data-toggle="control-sidebar"><i
						class="fa fa-gears"></i></a></li>
			</ul>
		</div>
	</nav>
</header>