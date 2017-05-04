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
	<gvtv:navigater path="blog/page"></gvtv:navigater>
</section>
<style>
.modal-dialog{
	width: 1024px;
}
.us{display:none;width:80px;height:90px;
padding:10px;position:relative;top:0px;left:50px;
background-color:#0099FF;
}
</style>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<button type="button" data-url="blog/toAddOrUpd" data-model="dialog" class="btn btn-sm btn-primary">
						<i class="fa fa-fw fa-plus"></i>新增
					</button>
					<button type="button" data-url="blog/batchStatus"
							data-msg="确定发布选中的数据吗？" data-model="ajaxToDo" class="btn btn-sm btn-primary"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-edit"></i>批量发布
					</button>
					<button type="button" data-url="blog/batchDelete"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn btn-sm btn-danger"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
					</button>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table" class="table table-primary table-hover table-striped">
						<thead>
							<tr>
								<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
								<th width="20px" style="padding-right: 12px;"></th>
								<th>标题</th>
								<th>类型</th>
								<th>作者</th>
								<th>图片简介</th>
								<th>来源</th>
								<th>发布状态</th>
								<th>内容</th>
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
<div id="mydiv1" style="position:absolute;display:none;border:1px solid silver;background:silver;"> 
<img src="" id="mouseTips" width="200px" height="160px"/>
</div>
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
				"url" : "blog/list",
				"type" : "post",
				"data" : function(data) {
					data.keyword = $("#keyword").val();
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
			              {"data" : "blogTitle"},
			              {"data" : "blogType"}, 
			              {"data" : "blogAuthor"},
			              {"data" : "blogImage"},
			              {"data" : "blogSource"},
			              {"data" : "blogStatus"},
			              {"data" : "blogContext"}
			            ],
			"columnDefs" : [ {
				"targets" : 1,
				"render" : function(data, type, row) {
					var html = htmlTpl.dropdown.prefix
		            	  + '  <li><a href="blog/toAddOrUpd?id='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
		            	  + '  <li><a href="blog/delete?id='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
		            	  + '  <li class="divider"></li>'
		            	  if(row.blogStatus == '0'){
		            		  html += '<li><a href="blog/updStatus?blogStatus=1&id='+row.id+'" data-msg="确定发布吗？" data-model="ajaxToDo" data-callback="refreshTable">审核(发布)</a></li>'
		            	  }else if(row.blogStatus == '1'){
		            		  html += '<li><a href="blog/updStatus?blogStatus=0&id='+row.id+'" data-msg="确定取消发布吗？" data-model="ajaxToDo" data-callback="refreshTable">取消发布</a></li>'
		            	  }
		            	  + htmlTpl.dropdown.suffix;
					return html;
				}
			},
			{
				"targets" : 2,
				"render" : function(data, type, row) {
					if(row.blogType == '1'){
						return "<a href='"+row.blogSource+"' target='_blank'>"+data+"</a>";
					}else if(row.blogType == '2'){
						return "<a href='blog/details?id="+row.id+"' target='_blank'>"+data+"</a>";
					}
				}
			},
			{
				"targets" : 3,
				"render" : function(data, type, row) {
					if(data == '1'){
						return "<font color='orange'>媒体报道</font>";
					}else if(data == '2'){
						return "<font color='#6495ED'>业务文章</font>";
					}
				}
			},
			{
				"targets" : 5,
				"render" : function(data, type, row) {
					if(row.blogType == '1'){
						var content = "<img src='${headUrl}"+data+"' width='30px' height='25px' onmouseover='showImg(this);' onmouseout='hideImg()' />";
						return content;
					}else if(row.blogType == '2'){
						return data;
					}
				}
			},
			{
				"targets" : 6,
				"render" : function(data, type, row) {
					if(data && data != '' && data.length > 11){
						return data.substring(0,10)+"..";
					}else {
						return data;
					}
				}
			},
			{
				"targets" : 7,
				"render" : function(data, type, row) {
					if(data == '0'){
						return "<font color='red'>未发布</font>";
					}else if(data == '1'){
						return "<font color='blue'>发布中</font>";
					}
				}
			},
			{
				"targets" : 8,
				"render" : function(data, type, row) {
					if(data && data != null && data != '' && data.length > 50){
							return data.substring(0,50)+"...";
					}else{
						return data;
					}
				}
			}],
			"drawCallback": function (settings) {
				drawICheck('defaultCheck', 'chx_default');
	      	},
			"initComplete": function () {
				initSearchForm("", "搜索标题、来源、作者");
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
	
	function showImg(obj) {
		$("#mouseTips").attr('src',$(obj).attr('src'));
		$("#mydiv1").css("display","block"); 
		$("#mydiv1").css("left", event.clientX-50); 
		$("#mydiv1").css("top", event.clientY - 200); 
	} 
	function hideImg() { 
		$("#mydiv1").css("display", "none"); 
	}
		
	function refreshTable(toFirst) {
		//defaultTable.ajax.reload();
		if(toFirst){//表格重绘，并跳转到第一页
			defTable.draw();
		}else{//表格重绘，保持在当前页
			defTable.draw(false);
		}
	}
</script>