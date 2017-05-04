<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="blog/addOrUpd" method="post" id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>
				<c:if test="${empty blog.id}">新增</c:if><c:if test="${not empty blog.id}">编辑</c:if>
			</div>
		</div>
	</div>
	<input type="hidden" name="id" value="${blog.id}"/>
	<input type="hidden" name="id" value="${blog.blogStatus}"/>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="password" class="col-sm-1 control-label">类型</label>
				<div class="col-sm-7">
					<label for="blogType1">
					<input name="blogType" type="radio" id="blogType1" value="1" onclick="blogTypeInput(this.value)"/>媒体报道</label>&nbsp;&nbsp;&nbsp;
					<label for="blogType2">
					<input name="blogType" type="radio" id="blogType2" value="2" onclick="blogTypeInput(this.value)"/>业务文章</label>
				</div>
			</div>
			<div class="form-group">
				<label for="loginName" class="col-sm-1 control-label">标题</label>
				<div class="col-sm-7">
					<input id="blogTitle" name="blogTitle" type="text" maxlength="90" value="${blog.blogTitle}" class="form-control required" placeholder="请输入标题"/>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-1 control-label">来源</label>
				<div class="col-sm-7">
					<input class="form-control" type="text" maxlength="128" name="blogSource" id="blogSource" value="${blog.blogSource}" placeholder="请输入链接地址或来源名称"/>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-1 control-label">作者</label>
				<div class="col-sm-7">
					<input class="form-control" type="text" maxlength="128" name="blogAuthor" id="blogAuthor" value="${blog.blogAuthor}" placeholder="请输入作者名称"/>
				</div>
			</div>
			<div class="form-group" id="imgDiv">
				<label for="name" class="col-sm-1 control-label" id="soureName">封面图片</label>
				<div class="col-sm-7" id="fileSelect">
					<input class="form-control" type="text" maxlength="30" name="blogImage" style="display:none" id="blogImage" value="${blog.blogImage}"/>
					<span class="help-block m-b-none" id="fileAddBtn">
	                	<button type="button" class="btn btn-white btn-xs" onclick="addFileUpload()" ><span class="glyphicon glyphicon-plus-sign">添加文件</span></button> 
	           		</span>
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-1 control-label">文章内容</label>
				<div class="col-sm-7">
					<textarea name="blogContext" id="blogContext" style="width:800px;height:400px;visibility:hidden;">${blog.blogContext}</textarea>
				</div>
			</div>
			
		    <div class="form-group">
				<label for="description" class="col-sm-1 control-label">文章摘要</label>
				<div class="col-sm-7">
					<textarea name="blogIntroduction" rows="5" cols="60" id="blogIntroduction">${blog.blogIntroduction}</textarea>
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
	function blogTypeInput(value){
		if(value == '1'){
			$("#imgDiv").show();
		}else{
			$("#imgDiv").hide();
		}
		
	}
	function addFileUpload(){
		$("#fileSelect").append('<input class="form-control" type="file" name="uploadFile" id="uploadFile" required="required" accept=".jpg,.png,.jpeg,.gif,.bmp"/>');
		$("#fileAddBtn").hide();
		$("#uploadFile").click();
	}
	$(function(){
		var editor = KindEditor.create("#blogContext", {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			afterCreate : function() {
				var self = this;
				KindEditor.ctrl(document, 13, function() {
					self.sync();
				//document.forms['example'].submit();
				});
				KindEditor.ctrl(self.edit.doc, 13, function() {
					self.sync();
				//document.forms['example'].submit();
				});
				},
			items : [
				'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'image', 'link']
		});
		if('${blog.blogType}' == ''){
			$("#blogType1").attr('checked','checked');
		}else if('${blog.blogType}' == '1'){
			$("#blogType1").attr('checked','checked');
		}else if('${blog.blogType}' == '2'){
			$("#blogType2").attr('checked','checked');
		}
		blogTypeInput($('input:radio:checked').val());
	});
	$("#defForm").validate();
</script>