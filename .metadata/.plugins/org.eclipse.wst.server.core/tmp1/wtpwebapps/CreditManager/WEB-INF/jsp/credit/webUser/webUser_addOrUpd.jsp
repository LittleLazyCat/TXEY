<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="webUser/addOrUpd" method="post"
	id="defForm" callfn="refreshTable" enctype="multipart/form-data">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>
				<c:if test="${empty user.id}">新增</c:if><c:if test="${not empty user.id}">编辑</c:if>专家顾问
			</div>
		</div>
	</div>
	<input type="hidden" name="userHeadImages" value="${user.userHeadImages}"/>
	<input type="hidden" name="id" value="${user.id}"/>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="loginName" class="col-sm-2 control-label">专家名称：</label>
				<div class="col-sm-7">
					<input id="nickname" name="nickname" type="text" maxlength="10" value="${user.nickname}" class="form-control required" placeholder="请输入专家顾问名称"/>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">专家分类:</label>
				<div class="col-sm-7">
					<select name="userStatus" id="userStatus" class="form-control">
						<option value="7" <c:if test="${user.userStatus eq '7'}">selected</c:if> >资产处置专家</option>
						<option value="8" <c:if test="${user.userStatus eq '8'}">selected</c:if>>资深诉讼律师</option>
						<option value="9" <c:if test="${user.userStatus eq '9'}">selected</c:if>>资深财经法治媒体人</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">图片:</label>
				<div class="col-sm-7">
					<div id="fileSelect"></div>
	                <span class="help-block m-b-none">
	                	<button type="button" class="btn btn-white btn-xs" onclick="addFileUpload()" id="addFileBtn"><span class="glyphicon glyphicon-plus-sign">添加文件</span></button> 
	           		</span>
					<!-- <input class="form-control required" type="file" name="uploadFile" id="uploadFile" accept=".jpg,.png,.jpeg,.gif,.bmp"/> -->
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">描述:</label>
				<div class="col-sm-7">
					<textarea id="description" name="description" class="form-control required" rows="7" maxlength="1000">${user.description}</textarea>
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
	function addFileUpload(){
		$("#fileSelect").append('<input class="form-control" type="file" name="uploadFile" id="uploadFile" required="required" accept=".jpg,.png,.jpeg,.gif,.bmp"/>');
		$("#addFileBtn").hide();
		$("#uploadFile").click();
	}
</script>