<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="sample/addOrUpdate" method="post"
	id="defForm" callfn="refreshTable" enctype="multipart/form-data">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>
				<c:if test="${empty sample.id}">新增</c:if><c:if test="${not empty sample.id}">编辑</c:if>
			</div>
		</div>
	</div>
	<input type="hidden" name="samImg" value="${sample.samImg}"/>
	<input type="hidden" name="id" value="${sample.id}"/>
	<input type="hidden" name="status" value="${sample.status}"/>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="samType" class="col-sm-2 control-label">分类:</label>
				<div class="col-sm-7">
					<select name="samType" id="samType" class="form-control" onchange="showAndHide(this.value)">
						<option value="1" <c:if test="${sample.samType eq 1}">selected</c:if>>成功案例</option>
						<option value="2" <c:if test="${sample.samType eq 2}">selected</c:if>>用户心声</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="samName" class="col-sm-2 control-label">名称:</label>
				<div class="col-sm-7">
					<input id="samName" name="samName" type="text" maxlength="20" value="${sample.samName}" class="form-control required" placeholder="请输入名称"/>
				</div>
			</div>
			<div id="typeDiv">
			<div class="form-group">
				<label for="trade" class="col-sm-2 control-label">行业:</label>
				<div class="col-sm-7">
					<input class="form-control" type="text" name="trade" value="${sample.trade}" maxlength="20" placeholder="请输入行业"/>
				</div>
			</div>
			<div class="form-group">
				<label for="amount" class="col-sm-2 control-label">金额(元):</label>
				<div class="col-sm-7">
					<input class="form-control" type="text" name="amount" value="${sample.amount}" maxlength="10" placeholder="请输入金额"/>
				</div>
			</div>
			<div class="form-group">
				<label for="headImgFile" class="col-sm-2 control-label">图片:</label>
				<div class="col-sm-7">
					<div id="fileSelect"></div>
	                <span class="help-block m-b-none">
	                	<button type="button" class="btn btn-white btn-xs" onclick="addFileUpload()" id="addFileBtn"><span class="glyphicon glyphicon-plus-sign">添加文件</span></button> 
	           		</span>
				</div>
			</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">描述:</label>
				<div class="col-sm-7">
					<textarea id="description" name="description" class="form-control required" rows="7" maxlength="280">${sample.description}</textarea>
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
	$(function(){
		$("#typeDiv").hide();
		showAndHide($('#samType').val());
	});
	
	function showAndHide(value){
		if(value == '1'){
			$("#typeDiv").hide();
			$("#fileSelect").html("");
		}else{
			$("#typeDiv").show();
			$("#addFileBtn").show();
			//$("#fileSelect").html('<input class="form-control required" type="file" name="headImgFile" id="headImgFile" accept=".jpg,.png,.jpeg,.gif,.bmp"/>');
		}
	}
	var i=0;
	function addFileUpload(){
		$("#fileSelect").append('<input class="form-control" type="file" name="headImgFile" id="headImgFile'+i+'" required="required" accept=".jpg,.png,.jpeg,.gif,.bmp"/>');
		$("#addFileBtn").hide();
		$("#headImgFile"+i).click();
		i++;
	}
</script>