<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="credit/matchTeam" method="post" id="defForm" callfn="refreshTable">
<input type="hidden" name="id" value="${id}">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>选择处置团队</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
                          <div class="form-group">
                                <label class="col-sm-3 control-label">处置团队：</label>
                                <div class="col-sm-6">
                                        <select name="dealTeamName" class="form-control" required="required">
											 <option value="">请选择</option>
											 <c:forEach items="${teamList}" var="item">
											 <option value="${item.id}">${item.userEmail} - ${item.userPhone}</option>
											 </c:forEach>
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
