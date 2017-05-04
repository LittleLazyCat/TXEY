<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" action="user/editRole" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>分配角色</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<input type="hidden" name="userId" value="${userId}" />
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th width="10%">选择</th>
						<th width="10%">序号</th>
						<th width="30%">角色名称</th>
						<th width="30%">角色描述</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${roles != null && fn:length(roles) > 0}">
							<c:forEach items="${roles}" var="role" varStatus="vs">
								<tr>
									<td><label><input type="checkbox" name="roleIds"
											value="${role.roleId}" ${role.checked ? "checked" : ""}></label></td>
									<td>${vs.count}</td>
									<td>${role.roleName}</td>
									<td>${role.description}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5">没有相关数据</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="user/editRole">
			<button type="submit" class="btn btn-primary">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
$("#defForm").validate();
</script>