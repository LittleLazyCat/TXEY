<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="gvtv" uri="http://www.gvtv.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<gvtv:navigater path="filemanager"></gvtv:navigater>
</section>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
						<button type="button" data-url="filemanager/add" data-model="dialog"
							class="btn btn-sm btn-primary">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>			
						<button type="button" data-url="filemanager/batchDelete"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn btn-sm btn-danger"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
						</button>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						class="table table-primary table-hover table-striped">
						<thead>
							<tr>
								<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
								<th width="20px" style="padding-right: 12px;"></th>
								<th>文件类型</th>
								<th>文件名称</th>
								<th>文件下载地址</th>
							</tr>
						</thead>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>

<script type="text/javascript">
	var defTable;
	$(document).ready(function() {
		defTable = $('#default_table').DataTable({
			"ordering" : false,
			"pagingType" : "simple_numbers",
			"autoWidth": false,
			"processing" : true,
			"serverSide" : true,
			"ajax" : {
				"url" : "filemanager/list",
				"type" : "post",
				"data" : function(data) {
					data.keyword = $("#keyword").val();
				}
			},
			"language" : {
				"url" : "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
			},
			"createdRow" : function(row, data, index) {
				$('td:eq(0)', row).html("<input type='checkbox' name='chx_default' value='" + data.userId + "'/>");
			},
			"lengthMenu": [[10, 20,50], [10, 20,50]],
			"columns" : [ 
			              {"data" : "id"},
			              {"data" : null},
			              {"data" : "fileType"}, 
			              {"data" : "fileTitle"}, 
			              {"data" : "downloadUrl"}, 
			            ],
			"columnDefs" : [ {
				"targets" : 1,
				"render" : function(data, type, row) {
					var html = htmlTpl.dropdown.prefix
		            	  + '  <li><a href="filemanager/edit?id='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
		            	  + '  <li><a href="filemanager/delete?id='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
		            	  + htmlTpl.dropdown.suffix;
					return html;
				}
			},
			{
				"targets" : 2,
				"render" : function(data, type, row) {
					if(data == '1'){
						return "<font color='orange'>法律文书</font>";
					}else if(data == '2'){
						return "<font color='blue'>合同模版</font>";
					}else if(data == '3'){
						return "<font color='red'>实用文件</font>";
					}
				}
			},
			{
				"targets" : 4,
				"render" : function(data, type, row,settings) {
					if(data != ''){
						return "<a href='${headUrl}/"+data+"' target='_blank'>${headUrl}"+data+"</a>";
					}
				}
			}],
			"drawCallback": function (settings) {
				drawICheck('defaultCheck', 'chx_default');
	      	},
			"initComplete": function () {
			var others = '<div class="input-group input-group-sm input-adjust">'
					+ '<span class="input-group-addon">类型</span>'
					+ '<select class="form-control" name="fileType">'
					+ '	<option value="1">法律文书</option>'
					+ '	<option value="2">合同模版</option>'
					+ '	<option value="3">实用文件</option>'
					+ '</select>'
					+ '</div>';
				initSearchForm(others, "文件名称");
			}
		});
	});

	function refreshTable(toFirst) {
		//defaultTable.ajax.reload();
		if(toFirst){//表格重绘，并跳转到第一页
			defTable.draw();
		}else{//表格重绘，保持在当前页
			defTable.draw(false);
		}
	}
</script>