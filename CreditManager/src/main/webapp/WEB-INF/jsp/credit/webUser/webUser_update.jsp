<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="webUser/update" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>
				编辑用户
			</div>
		</div>
	</div>
	<input type="hidden" name="id" value="${user.id}"/>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="loginName" class="col-sm-2 control-label">用户昵称：</label>
				<div class="col-sm-7">
					<input id="userEmail" name="userEmail" readonly="readonly" type="text" maxlength="30" value="${user.userEmail}" class="form-control required" placeholder="请输入专家顾问名称"/>
				</div>
			</div>
			<div class="form-group">
				<label for="loginName" class="col-sm-2 control-label">用户手机：</label>
				<div class="col-sm-7">
					<input id="userPhone" name="userPhone" type="text" maxlength="30" value="${user.userPhone}" class="form-control required" placeholder="请输入专家顾问名称"/>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">用户类型:</label>
				<div class="col-sm-7">
					<select name="userType" id="userType" class="form-control">
						<option value="0" <c:if test="${user.userType eq 0}">selected</c:if>>债权用户</option>
						<option value="1" <c:if test="${user.userType eq 1}">selected</c:if>>处置用户</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">用户状态:</label>
				<div class="col-sm-7">
					<select name="userStatus" id="userStatus" class="form-control">
						<option value="1" <c:if test="${user.userStatus eq 1}">selected</c:if>>有效</option>
						<option value="-1" <c:if test="${user.userStatus eq -1}">selected</c:if>>无效</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">描述:</label>
				<div class="col-sm-7">
					<textarea id="description" name="description" class="form-control" rows="7" maxlength="1000">${user.description}</textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<button type="submit" class="btn btn-primary">保存</button>
	</div>
</form>
<script>
	$("#defForm").validate();
</script>