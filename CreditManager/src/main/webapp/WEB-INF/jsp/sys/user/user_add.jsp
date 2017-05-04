<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" action="user/add" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>新增用户</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="loginName" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-7">
					<input id="loginName" name="loginName" type="text" maxlength="32"
						minlength="2" class="form-control required" placeholder="请输入用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-7">
					<input id="password" name="password" type="password" maxlength="32"
						minlength="2" class="form-control required" placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-7">
					<input id="name" name="name" type="text" maxlength="32"
						class="form-control required" placeholder="请输入姓名">
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">邮箱</label>
				<div class="col-sm-7">
					<input id="email" name="email" type="text" maxlength="32"
						class="form-control required" placeholder="请输入邮箱">
				</div>
			</div>
			<div class="form-group">
				<label for="phone" class="col-sm-2 control-label">电话</label>
				<div class="col-sm-7">
					<input id="phone" name="phone" type="text" maxlength="32"
						class="form-control required" placeholder="请输入电话">
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
		<shiro:hasPermission name="user/add">
			<button type="submit" class="btn btn-primary">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
$('#defForm').validate({
	rules: {
		loginName: {
            required: true,
            remote: {
                type: "post",
                url: "user/checkName",
                dataType: "json",
                dataFilter: function(data, type) {
                    if (data == 1){
                    	return false;
                    }else{
                    	return true;
                    }  
                }
            }
    	}
    },
    messages: {
    	loginName: {
            required: "请输入用户名",
            remote: "用户名重复"
        }
    }
});
</script>