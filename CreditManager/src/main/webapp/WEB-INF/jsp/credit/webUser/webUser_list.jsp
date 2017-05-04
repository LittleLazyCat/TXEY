<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="gvtv" uri="http://www.gvtv.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<gvtv:navigater path="webUser/cr_page"></gvtv:navigater>
</section>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<%-- <shiro:hasPermission name="user/add">
						<button type="button" data-url="user/add" data-model="dialog" class="btn btn-sm btn-primary">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>
					</shiro:hasPermission>
					<shiro:hasPermission name="user/batchDelete">
						<button type="button" data-url="user/batchDelete"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn btn-sm btn-danger"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
						</button>
					</shiro:hasPermission> --%>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						class="table table-primary table-hover table-striped">
						<thead>
							<tr>
								<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
								<th width="20px" style="padding-right: 12px;"></th>
								<th>用户昵称(邮箱)</th>
								<th>用户手机</th>
								<th>用户类型</th>
								<th>用户状态</th>
								<th>用户说明</th>
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
				"url" : "webUser/cr_list",
				"type" : "post",
				"data" : function(data) {
					data.keyword = $("#keyword").val();
					data.userType = $("#userType").val();
					data.userStatus = $("#userStatus").val();
				}
			},
			"language" : {
				"url" : "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
			},
			"createdRow" : function(row, data, index) {
				$('td:eq(0)', row).html("<input type='checkbox' name='chx_default' value='" + data.id + "'/>");
			},
			"lengthMenu": [[10, 15, 20], [10, 15, 20]],
			"columns" : [ 
			              {"data" : "id"},
			              {"data" : null},
			              {"data" : "userEmail"}, 
			              {"data" : "userPhone"}, 
			              {"data" : "userType"}, 
			              {"data" : "userStatus"},
			              {"data" : "description"}
			            ],
			"columnDefs" : [ {
				"targets" : 1,
				"render" : function(data, type, row) {
					var html = htmlTpl.dropdown.prefix
					      + '  <li><a href="webUser/update?id='+row.id+'"  data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
		            	  + '  <li><a href="webUser/resetPass?id='+row.id+'" data-msg="重置后新密码为123456!" data-model="ajaxToDo" data-callback=""><i class="fa fa-pencil"></i>重置密码</a></li>';
                          if(row.userStatus==1){
                        	  html+= '  <li><a href="webUser/disable?id='+row.id+'" data-msg="删除该用户后将不能再登录网站!" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'; 
                          }		            			  
		            	  
		            	  + htmlTpl.dropdown.suffix;
					return html;
				}
			},
			{
				"targets" : 4,
				"render" : function(data, type, row) {
					if(data == '0'){
						return "债权用户";
					}else{
						return "处置用户";
					}
				}
			},
			{
				"targets" : 5,
				"render" : function(data, type, row) {
					if(data == -1){
						return "<font color='red'>无效</font>";
					}else{
						return "<font color='blue'>有效</font>";
					}
				}
			}],
			"drawCallback": function (settings) {
				drawICheck('defaultCheck', 'chx_default');
	      	},
			"initComplete": function () {
				var others = '<div class="input-group input-group-sm input-adjust">'
					+ '<span class="input-group-addon">用户类型</span>'
					+ '<select class="form-control" name="userType" id="userType">'
					+ '<option value="">全部</option>'
					+ '<option value="0">债权用户</option>'
					+ '<option value="1">处置用户</option>'
					+ '</select>'
					+ '</div>';
					others += '<div class="input-group input-group-sm input-adjust">'
					+ '<span class="input-group-addon">用户状态</span>'
					+ '<select class="form-control" name="userStatus" id="userStatus">'
					+ '<option value="">全部</option>'
					+ '<option value="1">有效</option>'
					+ '<option value="-1">无效</option>'
					+ '</select>'
					+ '</div>';
				initSearchForm(others, "搜索昵称和手机");
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