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
	<gvtv:navigater path="user"></gvtv:navigater>
</section>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<shiro:hasPermission name="user/add">
						<button type="button" data-url="user/add" data-model="dialog"
							class="btn btn-sm btn-primary">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>
					</shiro:hasPermission>
					<shiro:hasPermission name="user/batchDelete">
						<button type="button" data-url="user/batchDelete"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn btn-sm btn-danger"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
						</button>
					</shiro:hasPermission>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						class="table table-primary table-hover table-striped">
						<thead>
							<tr>
								<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
								<th width="20px" style="padding-right: 12px;"></th>
								<th>用户名</th>
								<th>姓名</th>
								<th>邮箱</th>
								<th>电话</th>
								<th>最近登录</th>
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
				"url" : "user/list",
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
			"lengthMenu": [[10, 20, 50], [10, 20, 50]],
			"columns" : [ 
			              {"data" : "userId"},
			              {"data" : null},
			              {"data" : "loginName"}, 
			              {"data" : "name"}, 
			              {"data" : "email"}, 
			              {"data" : "phone"}, 
			              {"data" : "lastLogin"}, 
			              
			            ],
			"columnDefs" : [ {
				"targets" : 1,
				"render" : function(data, type, row) {
					var html = htmlTpl.dropdown.prefix
		           	<shiro:hasPermission name="user/edit">
		            	  + '  <li><a href="user/edit?userId='+row.userId+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
		            </shiro:hasPermission>
		            <shiro:hasPermission name="user/delete">
		            	  + '  <li><a href="user/delete?userId='+row.userId+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
		            </shiro:hasPermission>
		            <shiro:hasPermission name="user/editRole">
		            	  + '  <li class="divider"></li>'
		            	  + '  <li><a href="user/editRole?userId='+row.userId+'" data-model="dialog">分配角色</a></li>'
		            </shiro:hasPermission>
		            	  + htmlTpl.dropdown.suffix;
					return html;
				}
			} ],
			"drawCallback": function (settings) {
				drawICheck('defaultCheck', 'chx_default');
	      	},
			"initComplete": function () {
				var others = '<div class="input-group input-group-sm input-adjust">'
					+ '<div class="input-group-addon">'
					+ '<label for="startTime"><i class="fa fa-calendar"></i></label>'
					+ '</div>' 
					+ '<input id="startTime" readonly name="startTime" type="text" class="form-control" placeholder="请输入开始时间" />'
					+ '</div>';
				others += '<div class="input-group input-group-sm input-adjust">'
					+ '<span class="input-group-addon">类型</span>'
					+ '<select class="form-control">'
					+ '	<option>option 1</option>'
					+ '	<option>option 2</option>'
					+ '</select>'
					+ '</div>';
				initSearchForm(others, "搜索用户名和姓名");
				$("#startTime").datetimepicker({
					format : 'yyyy-mm-dd hh:ii',
					language : 'zh',
					weekStart : 1,
					todayBtn : 1,
					autoclose : 1,
					todayHighlight : 1,
					startView : 2,
					minView : 0,
					forceParse : 0,
					showMeridian : 0,
					pickerPosition : "bottom-left"
				});
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