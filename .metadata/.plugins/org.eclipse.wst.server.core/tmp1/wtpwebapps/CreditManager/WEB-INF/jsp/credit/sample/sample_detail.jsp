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
				详情
			</div>
		</div>
	</div>
	
	<div class="modal-body">
		<div class="container-fluid">
			<c:if test="${sample.samType eq 2}">
	            <dl class="dl-horizontal">
	                 <dt>图片:</dt>
	                 <dd><img alt="" src="${sample.samImg}" width="100px" height="130px"></dd>
	            </dl>
            </c:if>
            <dl class="dl-horizontal">
                 <dt>分类:</dt>
                 <dd><c:if test="${sample.samType eq 1}">成功案例</c:if>
					 <c:if test="${sample.samType eq 2}">用户心声</c:if>
				</dd>
            </dl>
			<dl class="dl-horizontal">
                 <dt>名称:</dt>
                 <dd>${sample.samName}</dd>
            </dl>
            <c:if test="${sample.samType eq 2}">
            <dl class="dl-horizontal">
                 <dt>行业:</dt>
                 <dd>${sample.trade}</dd>
            </dl>
            <dl class="dl-horizontal">
                 <dt>金额:</dt>
                 <dd>${sample.amount} (元)</dd>
            </dl>
            </c:if>
            <dl class="dl-horizontal">
                <dt>简介:</dt>
                <dd>${sample.description}</dd>
           </dl>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
