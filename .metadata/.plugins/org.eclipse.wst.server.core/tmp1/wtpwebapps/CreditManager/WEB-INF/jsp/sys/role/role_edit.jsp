<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" action="role/edit" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>修改角色</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<input type="hidden" name="roleId" value="${pd.roleId}" /> <label
					for="roleName" class="col-sm-2 control-label">角色名称</label>
				<div class="col-sm-7">
					<input id="roleName" name="roleName" value="${pd.roleName}"
						type="text" maxlength="32" minlength="2"
						class="form-control required" placeholder="请输入角色名称">
				</div>
			</div>
			<div class="form-group">
				<label for="removable" class="col-sm-2 control-label">可删除</label>
				<div class="col-sm-7">
					<select class="form-control" id="removable" name="removable">
						<option value="1"
							<c:if test="${pd.removable == 1}">selected</c:if>>是</option>
						<option value="0"
							<c:if test="${pd.removable == 0}">selected</c:if>>否</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="allocatable" class="col-sm-2 control-label">可分配</label>
				<div class="col-sm-7">
					<select class="form-control" id="allocatable" name="allocatable">
						<option value="1"
							<c:if test="${pd.allocatable == 1}">selected</c:if>>是</option>
						<option value="0"
							<c:if test="${pd.allocatable == 0}">selected</c:if>>否</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">描述</label>
				<div class="col-sm-7">
					<textarea id="description" name="description" class="form-control"
						rows="3">${pd.description}</textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="role/edit">
			<button type="submit" class="btn btn-primary">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
$("#defForm").validate();
</script>