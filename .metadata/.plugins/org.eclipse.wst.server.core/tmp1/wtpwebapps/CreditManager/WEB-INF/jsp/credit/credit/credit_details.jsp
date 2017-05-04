<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<div class="modal-header">
    <div class='bootstrap-dialog-header'>
		<div class='bootstrap-dialog-close-button' style='display: block;'>
			<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
		</div>
		<div class='bootstrap-dialog-title'>债权详情</div>
	</div>
</div>
<div class="modal-body">
    <div class="container-fluid">
    	<input name="id" id="id" type="hidden" value="${credit.id}"/>
    	<input name="crStatus" id="crStatus" type="hidden" value="${credit.crStatus}"/>
    				         <b><font color="blue">基本信息</font></b>
                 		     <hr>
                                <dl class="dl-horizontal">
                                    <dt>债权类型：</dt>
                                    <dd>
                           				<c:if test="${credit.crType==1 }">民间借贷</c:if>
									    <c:if test="${credit.crType==2 }">应收账款</c:if>
									    <c:if test="${credit.crType==3 }">银行借贷</c:if>
									    <c:if test="${credit.crType==4 }">互联网金融</c:if>
									    <c:if test="${credit.crType==5 }">小额信贷</c:if>
									    <c:if test="${credit.crType==6 }">典当担保</c:if>
									    <c:if test="${credit.crType==7 }">司法裁决</c:if>
									    <c:if test="${credit.crType==8 }">资产包债权</c:if>
									    <c:if test="${credit.crType==9 }">单笔债权</c:if>
                                    </dd>
                               </dl>
								<dl class="dl-horizontal">
									<dt>债权金额：</dt>
									<dd> ${credit.crAmount }(万元)</dd>
								</dl>
								<c:if test="${credit.creditType eq '1'}">
	                               <dl class="dl-horizontal">
	                                    <dt>处置方式：</dt>
	                                    <dd>
	                                    <c:forEach items="${credit.disTypes}" var="item">
											<c:if test="${item eq '1'}">诉讼&nbsp;</c:if>
											<c:if test="${item eq '2'}">催收&nbsp;</c:if>
											<c:if test="${item eq '3'}">债权转让</c:if>
										</c:forEach>
	                                    </dd>
	                               </dl>
                               </c:if>
								<dl class="dl-horizontal">
									<dt>支付佣金范围：</dt>
									<dd>${credit.commisionRange }</dd>
								</dl>
                               
                               <dl class="dl-horizontal">
									<dt>发布日期：</dt>
									<dd>
									<fmt:formatDate value="${credit.createDate }" pattern="yyyy-MM-dd"/>
									</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>债权开始日期：</dt>
									<dd>
								     ${credit.openDate }
									</dd>
								</dl>
	                             <dl class="dl-horizontal">
	                                    <dt>债务人名称：</dt>
	                                    <dd> ${credit.contactName }</dd>
	                             </dl>
	                            <dl class="dl-horizontal">
	                                    <dt>债务人电话：</dt>
	                                    <dd> ${credit.contactNumber }</dd>
	                             </dl>
	                             
					      <b><font color="blue">债务方信息</font></b>
					      <hr>
					      		<c:if test="${credit.creditType eq '1'}">
						      		<dl class="dl-horizontal">
										<dt>债务方性质：</dt>
										<dd> <c:if test="${credit.deptType eq '1'}">个人</c:if>
											 <c:if test="${credit.deptType eq '2'}">企业</c:if> </dd>
									</dl>
					      		</c:if>
								<dl class="dl-horizontal">
									<dt>债权方联系人：</dt>
									<dd> ${credit.debtName }</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>所在城市：</dt>
									<dd>${credit.debtProvince } ${credit.debtCity }</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>债权方联系电话：</dt>
									<dd>${credit.debtPhone }</dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>债权凭证：</dt>
									<dd><c:forEach items="${credit.debtProofs}" var="item">
										<c:if test="${not empty item}">
										<a href="credit/imgDetail?imageUrl=${showImgPath}${item}" target="_blank">
											<img alt="" src="${showImgPath}${item}" width="50px" height="50px"/>&nbsp;&nbsp;
										</a>
										</c:if>
									</c:forEach></dd>
								</dl>
								<dl class="dl-horizontal">
									<dt>债权描述：</dt>
									<dd> ${credit.description }</dd>
								</dl>
								<c:if test="${not empty credit.dealTeamName }">
						      		<dl class="dl-horizontal">
									<dt><font color="blue">处置团队：</font></dt>
									<dd> ${user.userEmail } - ${user.userPhone }</dd>
								</dl>
								</c:if>
								
								<c:if test="${not empty agreeList }">
									<b><font color="blue">债权协议信息</font></b>
						      		<hr>
						      		<dl class="dl-horizontal">
									<dt>债权协议凭证：</dt>
									<dd>
									<table>
										<tr>
											<td>居间协议(前期)：</td>
											<td><c:forEach items="${agreeList}" var="item">
												<c:if test="${not empty item}">
													<c:if test="${item.agreeType eq '1'}">
														<a href="${showImgPath}${item.agreeSample}">查看《居间服务协议(前期)》</a><br>
													</c:if>
												</c:if>
											</c:forEach>
											</td>
										</tr>
										<tr style="height:60px">
											<td align="right">处置服务协议：</td>
											<td><c:forEach items="${agreeList}" var="item">
												<c:if test="${not empty item}">
													<c:if test="${item.agreeType eq '2'}">
														<a href="${basePath }credit/imgDetail?imageUrl=${showImgPath}${item.agreeImg}" target="_blank">
															<img alt="" src="${showImgPath}${item.agreeImg}" width="50px" height="50px"/>&nbsp;&nbsp;
														</a>
													</c:if>
												</c:if>
											</c:forEach>
											</td>
										</tr>
										<tr>
											<td>居间协议(后期)：</td>
											<td>
												<c:forEach items="${agreeList}" var="item">
													<c:if test="${not empty item}">
														<c:if test="${item.agreeType eq '3'}">
															<a href="${basePath }credit/imgDetail?imageUrl=${showImgPath}${item.agreeImg}" target="_blank">
																<img alt="" src="${showImgPath}${item.agreeImg}" width="50px" height="50px"/>&nbsp;&nbsp;
															</a>
														</c:if>
													</c:if>
												</c:forEach>
											</td>
										</tr>
									</table>
									</dd>
								</dl>
								</c:if>
                               
    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
</div>

