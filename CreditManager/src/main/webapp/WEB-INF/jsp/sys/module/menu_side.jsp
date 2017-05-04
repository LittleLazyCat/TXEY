<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar" id="scrollspy">

		<!-- Sidebar user panel (optional) -->
		<%-- <div class="user-panel">
			<div class="pull-left image">
				<img
					src="${pageContext.request.contextPath}/static/AdminLTE/dist/img/user.jpg"
					class="img-circle" alt="User Image" />
			</div>
			<div class="pull-left info">
				<p>${user.name}</p>
				<!-- Status -->
				<a href="javascript:;"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div> --%>

		<!-- search form (Optional) -->
		<!-- 		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..." /> <span class="input-group-btn">
					<button type='submit' name='search' id='search-btn'
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form> -->
		<!-- /.search form -->

		<!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<li class="header">功能导航</li>
			<!-- Optionally, you can add icons to the links -->
		<c:forEach items="${menuList}" var="menu" varStatus="status">
			<li class="treeview"><a href="javascript:;"><i class="fa fa-th-list" style="font-size :14px;"></i> <span>${menu.menuName}</span><i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu">
					<c:forEach items="${menu.subMenu}" var="sub">
						<c:choose>
							<c:when test="${not empty sub.menuUrl}">
								<li><a href="${sub.menuUrl}" data-target="navTab" selected-css="true"><i class="fa fa-caret-right"></i>${sub.menuName}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:;" data-target="navTab"><i class="fa fa-caret-right"></i>${sub.menuName}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			
			</li>
		</c:forEach>
		</ul>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>
