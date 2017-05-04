<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="commonForm" class="form-horizontal" method="post" action="user/editPwd" role="form">
<div class="modal-header">
    <div class='bootstrap-dialog-header'>
		<div class='bootstrap-dialog-close-button'
			style='display: block;'>
			<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
		</div>
		<div class='bootstrap-dialog-title'>修改密码</div>
	</div>
</div>
<div class="modal-body">
    <div class="container-fluid">
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">原密码</label>
            <div class="col-sm-7">
                <input id="oldpassword" name="oldpassword"  type="password" maxlength="32" minlength="2" class="form-control required"  placeholder="请输入原密码">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">新密码</label>
            <div class="col-sm-7">
                <input id="password" name="password"  type="password" maxlength="32" minlength="2" class="form-control required"  placeholder="请输入新密码">
            </div>
        </div>
        <div class="form-group">
            <label for="passwordAgain" class="col-sm-2 control-label">重复新密码</label>
            <div class="col-sm-7">
                <input id="passwordAgain"  equalTo="#password"  type="password" maxlength="32" minlength="2" class="form-control required"  placeholder="请再次输入新密码">
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
$(function(){
	$("#commonForm").validate();
});
</script>