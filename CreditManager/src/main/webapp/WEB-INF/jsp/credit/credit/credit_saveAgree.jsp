<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="agreement/saveAgree" method="post" id="defForm" callfn="refreshTable" enctype="multipart/form-data">
<input type="hidden" name="creditId" value="${creditId}">
<input type="hidden" name="userId" value="${userId}">
<input type="hidden" name="agreeType" value=${agreeType }>
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>
			   <c:if test="${agreeType==1 }">   
		                             居间服务协议(前期)：
		       </c:if>
		       <c:if test="${agreeType==3}">   
		                             居间服务协议(后期)：
		       </c:if>
			</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
		                    <div class="form-group">
		                        <label class="col-sm-3 control-label">
		                     <c:if test="${agreeType==1 }">   
		                             居间服务协议(前期)：
		                     </c:if>
		                     <c:if test="${agreeType==3}">   
		                             居间服务协议(后期)：
		                     </c:if>
		                        </label>
		                        <div class="col-sm-6">
		                             <div id="addFileUpload"></div>
		                             <span class="help-block m-b-none">
		                             	<button type="button" class="btn btn-white btn-xs" onclick="addFileUpload()"><span class="glyphicon glyphicon-plus-sign">添加文件</span></button>
		                         	</span>
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
<script type="text/javascript">
var i=0;
function addFileUpload(){
	$("#addFileUpload").append('<input class="form-control" type="file" name="uploadFiles" id="uploadFiles'+i+'" required="required" accept=".doc,.docx"/>');
	$("#uploadFiles"+i).click();
	i++;
}
</script>