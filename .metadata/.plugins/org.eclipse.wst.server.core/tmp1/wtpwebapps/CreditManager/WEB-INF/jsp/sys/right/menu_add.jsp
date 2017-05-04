<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" action="right/addMenu" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>新增${menuType == 1 ? '菜单' : '子菜单'}</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<input type="hidden" name="parentId" value="${parentId}" /> <input
					type="hidden" name="menuType" value="${menuType}" /> <label
					for="menuName" class="col-sm-2 control-label">名称</label>
				<div class="col-sm-7">
					<input id="menuName" name="menuName" type="text" maxlength="32"
						minlength="2" class="form-control required" placeholder="请输入名称">
				</div>
			</div>
			<div class="form-group">
				<label for="menuUrl" class="col-sm-2 control-label">路径</label>
				<div class="col-sm-7">
					<c:choose>
						<c:when test="${menuType == 1}">
							<input id="menuUrl" name="menuUrl" type="text" maxlength="32"
								class="form-control" value="#" readonly="readonly">
						</c:when>
						<c:otherwise>
							<input id="menuUrl" name="menuUrl" type="text" maxlength="32"
								class="form-control required" placeholder="请输入路径">
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group">
				<label for="menuOrder" class="col-sm-2 control-label">排序</label>
				<div class="col-sm-7">
					<input id="menuOrder" name="menuOrder" type="text" maxlength="32"
						class="form-control required" placeholder="请输入数值">
				</div>
			</div>
			<div class="form-group">
				<label for="removable" class="col-sm-2 control-label">可删除</label>
				<div class="col-sm-7">
					<select class="form-control" id="removable" name="removable">
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">描述</label>
				<div class="col-sm-7">
					<textarea id="description" name="description" class="form-control"
						rows="3"></textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="right/addMenu">
			<button type="submit" class="btn btn-primary">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
$("#defForm").validate();
</script>