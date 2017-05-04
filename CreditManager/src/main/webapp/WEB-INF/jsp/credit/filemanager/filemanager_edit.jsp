<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="filemanager/edit" method="post" id="defForm" callfn="refreshTable">
<input type="hidden" name="id" value="${fileManager.id }">
<input type="hidden" name="downloadUrl" value="${fileManager.downloadUrl }">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>编辑法律文件模版</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="loginName" class="col-sm-2 control-label">文件类型</label>
				<div class="col-sm-7">
						<select name="fileType" id="fileType" class="form-control required" >
						<option value="1"  <c:if test="${fileManager.fileType == 1}">selected="selected"</c:if>>法律文书</option>
						<option value="2"  <c:if test="${fileManager.fileType == 2}">selected="selected"</c:if>>合同模版</option>
						<option value="3"  <c:if test="${fileManager.fileType == 3}">selected="selected"</c:if>>实用文件</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">文件名称</label>
				<div class="col-sm-7">
					<input id="fileTitle" name="fileTitle" type="text" maxlength="32" class="form-control required" placeholder="请输入文件名称" value="${fileManager. fileTitle}">
				</div>
			</div>
			<div class="form-group">
				<label for="headImgFile" class="col-sm-2 control-label">文件:</label>
				<div class="col-sm-7">
					<div id="fileSelect"></div>
	                <span class="help-block m-b-none">
	                	<button type="button" class="btn btn-white btn-xs" onclick="addFileUpload()" id="addFileBtn"><span class="glyphicon glyphicon-plus-sign">添加文件</span></button> 
	           		</span>
				</div>
			</div>
			<%-- <div class="form-group">
				<label for="description" class="col-sm-2 control-label">下载地址</label>
				<div class="col-sm-7">
					<textarea id="downloadUrl" name="downloadUrl" class="form-control"
						rows="3">${fileManager. downloadUrl}</textarea>
				</div>
			</div> --%>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="user/add">
			<button type="submit" class="btn btn-primary">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
$('#defForm').validate();
var i=0;
function addFileUpload(){
	$("#fileSelect").append('<input class="form-control" type="file" name="uploadFile" id="uploadFile'+i+'" required="required" accept=".jpg,.png,.jpeg,.gif,.bmp"/>');
	$("#addFileBtn").hide();
	$("#uploadFile"+i).click();
	i++;
}
</script>