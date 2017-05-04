<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>
				专家顾问详情
			</div>
		</div>
	</div>
	
	<div class="modal-body">
		<div class="container-fluid">
            <dl class="dl-horizontal">
                 <dt>图片:</dt>
                 <dd><img alt="" src="${user.userHeadImages}" width="100px" height="130px"></dd>
            </dl>
			<dl class="dl-horizontal">
                 <dt>名称:</dt>
                 <dd><b>${user.nickname}</b></dd>
            </dl>
            <dl class="dl-horizontal">
                 <dt>专家分类:</dt>
                 <dd><c:if test="${user.userStatus eq 7}">资产处置专家</c:if>
					<c:if test="${user.userStatus eq 8}">资深诉讼律师</c:if>
					<c:if test="${user.userStatus eq 9}">资深财经法治媒体人</c:if>
				</dd>
            </dl>
             <dl class="dl-horizontal">
                 <dt>简介:</dt>
                 <dd>${user.description}</dd>
            </dl>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
