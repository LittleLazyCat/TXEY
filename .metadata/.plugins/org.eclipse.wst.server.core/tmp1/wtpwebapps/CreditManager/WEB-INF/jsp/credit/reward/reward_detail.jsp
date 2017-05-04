<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
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
				悬赏详情
			</div>
		</div>
	</div>
	
	<div class="modal-body">
		<div class="container-fluid">
			<b><font color="blue">基本信息</font></b>
			<hr>
            <dl class="dl-horizontal">
              <dt>悬赏类型：</dt>
              <dd>
				<c:if test="${reward.rewardType==0}">找人</c:if>
                <c:if test="${reward.rewardType==1}">找车辆</c:if>
                <c:if test="${reward.rewardType==2}">找房产</c:if>
                <c:if test="${reward.rewardType==3}">找应收款</c:if>
                <c:if test="${reward.rewardType==4}">其他</c:if>
               </dd>
             </dl>
                  
             <dl class="dl-horizontal">
                   <dt>金额：</dt>
                   <dd><c:if test="${reward.rewardAmount eq '3000'}">${reward.rewardAmount } (元以上)</c:if>
					   <c:if test="${reward.rewardAmount ne '3000'}">${reward.rewardAmount } (元)</c:if></dd>
              </dl>
 
               <dl class="dl-horizontal">
                   <dt>姓名：</dt>
                   <dd>${reward.rewardName }</dd>
              </dl>
				<dl class="dl-horizontal">
					<dt>身份证：</dt>
					<dd>${reward.cartId }</dd>
				</dl>

           <c:if test="${reward.rewardType==1}">
           	<dl class="dl-horizontal">
				<dt>车牌号：</dt>
				<dd>${reward.carBrand }</dd>
			</dl>
            </c:if>
			<dl class="dl-horizontal">
				<dt>发布日期：</dt>
				<dd><fmt:formatDate value="${reward.createTime }" pattern="yyyy-MM-dd"/> </dd>
			</dl>

			<dl class="dl-horizontal">
				<dt>有效日期：</dt>
				<dd><fmt:formatDate value="${reward.endTime }" pattern="yyyy-MM-dd"/></dd>
			</dl>
			<dl class="dl-horizontal">
				<dt>所在地：</dt>
				<dd>${reward.province} ${reward.city}</dd>
			</dl>
			
            <b><font color="blue">其他信息</font></b>
            <hr>
			<dl class="dl-horizontal">
				<dt>发布者：</dt>
				<dd>${user.nickname}</dd>
			</dl>
			<dl class="dl-horizontal">
				<dt>联系电话：</dt>
				<dd>${user.userPhone}</dd>
			</dl>
			<dl class="dl-horizontal">
				<dt> 图片：</dt>
				<dd><c:forEach items="${reward.imagesArry}" var="item">
					<c:if test="${not empty item}">
					<a href="reward/imgDetail?imageUrl=${showImgPath}${item}" target="_blank">
						<img alt="" src="${showImgPath}${item}" id="rewardImg" width="50px" height="50px"/>&nbsp;&nbsp;
					</a>
					</c:if>
				</c:forEach></dd>
			</dl>
			<dl class="dl-horizontal">
				<dt>悬赏描述：</dt>
				<dd>${reward.description}</dd>
			</dl>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
