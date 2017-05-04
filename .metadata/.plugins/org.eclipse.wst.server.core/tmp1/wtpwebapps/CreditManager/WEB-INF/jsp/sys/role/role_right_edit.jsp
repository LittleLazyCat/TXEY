<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<style type="text/css">
ul.ztree {
    background: #ecf0f5 none repeat scroll 0 0;
    border: 1px solid #617775;
    height: 380px;
    overflow-x: auto;
    overflow-y: scroll;
}
</style>
<link
	href="${pageContext.request.contextPath}/static/plugins/zTree/css/zTreeStyle/zTreeStyle.css"
	rel="stylesheet" type="text/css" />
<form class="form-horizontal" action="role/editRight" method="post"
	id="roleResEditForm">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>分配权限</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="col-lg-2" ></div>
			<div class="col-lg-8" >
				<ul id="tree_res" class="ztree"></ul>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="role/editRight">
			<button type="button" class="btn btn-primary" onclick="submitForm()">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script
	src="${pageContext.request.contextPath}/static/plugins/zTree/js/jquery.ztree.all-3.5.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var setting = {
	        view: {
	            dblClickExpand: false,
	            showLine: true,
	            selectedMulti: false
	        },
	        check: {
	                chkboxType: {"Y": "p", "N": "s"},
	                chkStyle: "checkbox",
	                enable: true,
	                autoCheckTrigger: true
	        },
	        data: {
	            simpleData: {
	                enable:true,
	                idKey: "id",
	                pIdKey: "pId",
	                rootPId: ""
	            }
	        }
	    };
		
		$.post("role/resNodes?roleId=${pd.roleId}", function(zNodes){
			console.log(zNodes);
			$.fn.zTree.init($("#tree_res"), setting, zNodes);
		}, "json");
	});
	
	function submitForm(){
		var treeObj = $.fn.zTree.getZTreeObj("tree_res");
		var nodes = treeObj.getCheckedNodes(true);
		var selRes = "";
		for (var i = 0; i < nodes.length; i++) {
			selRes += nodes[i].resFlag + ",";
		}
		if (selRes.length > 1) {
			selRes = selRes.substring(0, selRes.length - 1);
			$.ajax({
				url: "role/editRight",
				type: "post",
				data: {'roleId': ${pd.roleId}, 'selRes': selRes},
				dataType: "json",
				success: function(data){
					if (data.status) {
						$("#roleResEditForm .close").click();
					} else {
						alert(data.msg || "编辑权限失败");
					}
				}
			});
		} else {
			$("#roleResEditForm .close").click();
		}
	}
</script>