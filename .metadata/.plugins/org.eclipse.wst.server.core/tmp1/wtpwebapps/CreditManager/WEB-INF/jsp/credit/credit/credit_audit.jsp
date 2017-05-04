<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<form class="form-horizontal" action="credit/audit" method="post" id="defForm" callfn="refreshTable">
<input type="hidden" name="id" value="${credit.id }">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>债权审核</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
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
								<c:if test="${credit.creditType eq 1}">
	                               <dl class="dl-horizontal">
	                                    <dt>处置方式：</dt>
	                                    <dd>
	                                    <c:forEach items="${credit.disTypes}" var="item">
											<c:if test="${item eq '1'}">诉讼</c:if>
											<c:if test="${item eq '2'}">催收</c:if>
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
	                             
	                              <hr>
									<div class="form-group">
										<label class="col-sm-4 control-label">审核状态：</label>
										<div class="col-sm-6">
											<select name="isAudit" class="form-control">
												<option value="1">审核通过</option>
												<option value="-1">审核不通过</option>
											</select>
										</div>
									</div>

		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			<button type="submit" class="btn btn-primary">保存</button>
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