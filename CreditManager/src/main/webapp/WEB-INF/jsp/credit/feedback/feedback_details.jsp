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
		<div class='bootstrap-dialog-title'>意见反馈详情</div>
	</div>
</div>
<div class="modal-body">
    <div class="container-fluid">
                                <dl class="dl-horizontal">
                                    <dt>反馈者姓名：</dt>
                                    <dd>${feedback.userName}</dd>
                               </dl>
                               <dl class="dl-horizontal">
                                    <dt>反馈者电话：</dt>
                                    <dd>${feedback.phone}</dd>
                               </dl>
                               <dl class="dl-horizontal">
                                    <dt>反馈者邮件：</dt>
                                    <dd>${feedback.userEmail}</dd>
                               </dl>
                               <dl class="dl-horizontal">
                                    <dt>反馈内容：</dt>
                                    <dd>${feedback.context}</dd>
                               </dl>
                               
    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
</div>
</form>