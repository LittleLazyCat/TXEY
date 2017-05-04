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
	<gvtv:navigater path="credit?creditType=${pd.creditType }"></gvtv:navigater>
</section>
<style>
	.modal-dialog{
		width: 720px;
	}
</style>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
						<button type="button" data-url="credit/add?creditType=${pd.creditType }" data-model="dialog" class="btn btn-sm btn-primary">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>
						<!-- <button type="button" data-url="credit/batchDelete"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn btn-sm btn-danger"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
						</button> -->
						<button type="button" data-url="credit/batchAudit"
							data-msg="确定通过审核选中的数据吗？" data-model="ajaxToDo" class="btn btn-sm btn-primary"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-edit"></i>批量审核
					</button>
					<button type="button" data-url="credit/batchDelete"
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
								<th>债权类型</th>
								<th>债权所在地</th>
								<th>债务人</th>
								<th>债权金额(万元)</th>
								<th>债权佣金</th>
								<th>债权审核状态</th>
								<th>债权状态</th>
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
				"url" : "credit/list?creditType=${pd.creditType}",
				"type" : "post",
				"data" : function(data) {
					data.keyword = $("#keyword").val();
					data.createTime = $("#createTime").val();
					data.crType = $("#crType").val();
				}
			},
			"language" : {
				"url" : "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
			},
			"createdRow" : function(row, data, index) {
				$('td:eq(0)', row).html("<input type='checkbox' name='chx_default' value='" + data.id + "'/>");
			},
			"lengthMenu": [[10, 20, 50], [10, 20, 50]],
			"columns" : [ 
			              {"data" : "id"},
			              {"data" : null},
			              {"data" : "crType"}, 
			              {"data" : "debtCity"}, 
			              {"data" : "debtName"}, 
			              {"data" : "crAmount"}, 
			              {"data" : "commisionRange"},
			              {"data" : "isAudit"}, 
			              {"data" : "crStatus"}, 
			            ],
			"columnDefs" : [ {
				"targets" : 1,
				"render" : function(data, type, row) {
					var html = htmlTpl.dropdown.prefix
		            	  + '  <li><a href="credit/edit?id='+row.id+'&creditType=${pd.creditType }" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
		            	  + '  <li><a href="credit/delete?id='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
		            	  +'  <li class="divider"></li>'
		            	  if(row.isAudit == 0){
		            			  html += '  <li><a href="credit/audit?id='+row.id+'" data-model="dialog">债权审核</a></li>'
		            	  }
		            	  if(row.crStatus == 1 && row.isAudit == 1 && row.creditType==1){
		            		  html += '  <li><a href="credit/chooseTeam?id='+row.id+'"  data-model="dialog">匹配处置团队</a></li>'
		            	  }else if (row.crStatus == 2 && row.creditType==1){
		            		  html += '  <li><a href="agreement/saveAgree?creditId='+row.id+'&userId='+row.dealTeamName+'&agreeType=1" data-model="dialog" data-callback="refreshTable">上传<居间服务协议(前期)></a></li>'
		            		  html += '  <li><a href="credit/delmatchTeam?id='+row.id+'" data-msg="确定取消匹配吗？" data-model="ajaxToDo" data-callback="refreshTable">取消匹配</a></li>'
		            	  }else if(row.crStatus == 4 && row.creditType==1){
		            		  html += '  <li><a href="agreement/saveAgree?creditId='+row.id+'&userId='+row.dealTeamName+'&agreeType=3" data-model="dialog" data-callback="refreshTable">上传<居间服务协议(后期)></a></li>'
		            	  }
		            	     html += '  <li><a href="credit/updateStatus?id='+row.id+'"  data-model="dialog">更新处置进度</a></li>'
		            	  + htmlTpl.dropdown.suffix;
					return html;
				}
			} ,
			{
				"targets" : 2,
				"render" : function(data, type, row) {
					if(data == 1){
						return "民间借贷";
					}else if(data == 2){
						return "应收账款";
					}else if(data == 3){
						return "银行借贷";
					}else if(data == 4){
						return "互联网金融";
					}else if(data == 5){
						return "小额信贷";
					}else if(data == 6){
						return "典当担保";
					}else if(data == 7){
						return "司法裁决";
					}else if(data == 8){
						return "资产包债权";
					}else if(data == 9){
						return "单笔债权";
					}
				}
			},
			{
				"targets" : 4,
				"render" : function(data,type,row){
					return '<a href="credit/details?id='+row.id+'" data-model="dialog">'+data+'</a>';
				}
			},
			{
				"targets" : 7,
				"render" : function(data, type, row) {
					if(data == '1'){
						return "审核通过";
					}else if(data == '0'){
						return "待审核";
					}else if(data == '-1'){
						return "审核不通过";
					}
				}
			},{
				"targets" : 8,
				"render" : function(data, type, row) {
					if(data == '1'){
						return "招标中";
					}else if(data == '2'){
						return "已匹配";
					}else if(data == '3'){
						return "已签前期协议";
					}else if(data == '4'){
						return "已签处置协议";
					}else if(data == '5'){
						return "已签后期协议";
					}else if(data == '6'){
						return "处置中";
					}else if(data == '7'){
						return "还款中";
					}else if(data == '9'){
						return "已终结";
					}
				}
			}],
			"drawCallback": function (settings) {
				drawICheck('defaultCheck', 'chx_default');
	      	},
			"initComplete": function () {
				var others = '<div class="input-group input-group-sm input-adjust">'
					+ '<div class="input-group-addon">'
					+ '<label for="startTime"><i class="fa fa-calendar"></i></label>'
					+ '</div>' 
					+ '<input id="createTime" readonly name="createTime" type="text" class="form-control" placeholder="请输入开始时间" />'
					+ '</div>';
				others += '<div class="input-group input-group-sm input-adjust">'
					+ '<span class="input-group-addon">类型</span>'
					+ '<select class="form-control" name="crType" id="crType">'
					+ '	<option value=""></option>'
					+ '	<option value="1">民间借贷</option>'
					+ '	<option value="2">应收账款</option>'
					+ '	<option value="3">银行借贷</option>'
					+ '	<option value="4">互联网金融</option>'
					+ '	<option value="5">小额信贷</option>'
					+ '	<option value="6">典当担保</option>'
					+ '	<option value="7">司法裁决</option>'
					+ '	<option value="8">资产包债权</option>'
					+ '	<option value="9">单笔债权</option>'
					+ '</select>'
					+ '</div>';
				initSearchForm(others, "搜索债权人名称");
				$("#createTime").datetimepicker({
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