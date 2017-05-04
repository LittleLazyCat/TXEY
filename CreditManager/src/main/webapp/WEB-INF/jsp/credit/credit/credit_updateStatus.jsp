<%@ page language="java" 
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<form class="form-horizontal" action="credit/updateStatus" method="post" id="defForm" callfn="refreshTable">
<input type="hidden" name="id" value="${credit.id }">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>更新债权状态</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
                           <b><font color="blue">更新债权状态</font></b>
                 		     <hr>
									<div class="form-group">
										<label class="col-sm-4 control-label">债权状态：</label>
										<div class="col-sm-6">
											<select name="crStatus" class="form-control" required="required">
											    <%--
												<option value="1" <c:if test="${credit.crStatus==1 }"> selected="selected"</c:if>>招标中</option>
												<option value="2" <c:if test="${credit.crStatus==2 }"> selected="selected"</c:if>>已匹配</option>
												<option value="3" <c:if test="${credit.crStatus==3 }"> selected="selected"</c:if>>已签前期协议</option>
												<option value="4" <c:if test="${credit.crStatus==4 }"> selected="selected"</c:if>>已签服务合同</option>
												<option value="5" <c:if test="${credit.crStatus==5 }"> selected="selected"</c:if>>已签处置协议</option>
												 --%>
												<option value="6" <c:if test="${credit.crStatus==6 }"> selected="selected"</c:if>>处置中</option>
												<option value="7" <c:if test="${credit.crStatus==7 }"> selected="selected"</c:if>>还款中</option>
												<option value="9" <c:if test="${credit.crStatus==9 }"> selected="selected"</c:if>>已完成</option>
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
$("#defForm").validate();
</script>