<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="credit/add" method="post" id="defForm" callfn="refreshTable" enctype="multipart/form-data">
<input type="hidden" name="creditType" value="${pd.creditType }">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>新增债权</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
				         <b><font color="blue">基本信息</font></b>
                 		 <hr>
                          <div class="form-group">
                                <label class="col-sm-3 control-label">债权类型：</label>
                                <div class="col-sm-6">
                                        <select  name="crType" class="form-control required">
													<option value="1">民间借贷</option>
													<option value="2">应收账款</option>
													<option value="3">银行借贷</option>
													<option value="4">互联网金融</option>
													<option value="5">小额信贷</option>
													<option value="6">典当担保</option>
													<option value="7">司法裁决</option>
										</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">债权发布者：</label>
                                <div class="col-sm-6">
                                        <select  name="userId" class="form-control required">
                                        <c:forEach items="${userList }" var="user">
													<option value="${user.id }">${user.userPhone} - ${user.userEmail}</option>
                                        </c:forEach>
										</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">债权金额(万元)：</label>
                                <div class="col-sm-6">
                                    <input id="crAmount" name="crAmount" class="form-control required" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">你期望的处置方式：</label>
                                <div class="col-sm-6">
	                              <input name="disposalType" id="su1" class="exts1" type="checkbox" value="1"> 
								  <span>诉讼</span>
						          <input name="disposalType" id="fsu1" class="exts1" type="checkbox" checked="checked" value="2">
								  <span>催收</span>
						          <input name="disposalType" class="exts1" id="rang1" type="checkbox" value="3">
						          <span>债权转让</span> 
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">支付佣金范围：</label>
                                <div class="col-sm-6">
                                     <select name="commisionRange" class="form-control" required="required" aria-required="true">
									 <option value="10%">10%</option>
									 <option value="10%-20%">10%-20%</option>
									 <option value="20%-30%" selected="selected">20%-30%</option>
									 <option value="30%-40%">30%-40%</option>
									 <option value="40%-50%">40%-50%</option>
									 <option value="50%-60%">50%-60%</option>
									 <option value="60%以上">60%以上</option>
									 </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">联系人姓名：</label>
                                <div class="col-sm-6">
                                    <input id="contactName" name="contactName" class="form-control" type="text" placeholder="可以是本人也可以委托他人" required="required" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">联系人电话：</label>
                                <div class="col-sm-6">
                                    <input id="contactNumber" name="contactNumber" class="form-control" type="text" placeholder="请填写有效的手机号码" required="required" aria-required="true">
                                </div>
                            </div>
					      <b><font color="blue">债务方信息</font></b>
					      <hr>
					      <div class="form-group">
                                <label class="col-sm-3 control-label">债务方性质：</label>
                                <div class="col-sm-6">
                                    <select id="deptType" name="deptType" class="form-control input-sm"  required="required">
							              <option value="">请选择</option>
							              <option value="1">个人</option>
							              <option value="2">企业</option>
							          </select>
                                </div>
                            </div>
                         <div class="form-group">
                                <label class="col-sm-3 control-label">债务方名称：</label>
                                <div class="col-sm-6">
                                    <input id="debtName" name="debtName" class="form-control" type="text" required="required" aria-required="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">债务方地址：</label>
                                <div class="col-sm-3">
												   <select onchange="loadCity(this)" id="debtProvince" name="debtProvince" class="form-control input-sm"  required="required" aria-required="true">
													 <option value="1">请选择</option>
													 <c:forEach items="${provinceList}" var="item">
													 <option value="${item}">${item}</option>
													 </c:forEach>
							                       </select>
								</div>
								<div class="col-sm-3">
									 <select id="debtCity" name="debtCity" class="form-control input-sm">
							              <option value="">请选择</option>
							          </select>
								</div>
                            </div>
                                
                            <div class="form-group">
                                <label class="col-sm-3 control-label">债务方联系电话：</label>
                                <div class="col-sm-6">
                                    <input id="debtPhone" name="debtPhone" class="form-control" type="text" required="required" aria-required="true">
                                </div>
                            </div>
		                    <div class="form-group">
		                        <label class="col-sm-3 control-label">照片：</label>
		                        <div class="col-sm-6">
		                             <!-- <input class="form-control" type="file" name="uploadFiles" accept=".jpg,.png,.jpeg,.gif,.bmp"/> -->
		                             <div id="addFileUpload"></div>
		                             <span class="help-block m-b-none">
		                             	<button type="button" class="btn btn-white btn-xs" onclick="addFileUpload()"><span class="glyphicon glyphicon-plus-sign">添加图片</span></button>
		                         	</span>
		                    	</div>
		                    </div>
                           <div class="form-group">
                                <label class="col-sm-3 control-label">债权开始日期：</label>
                                <div class="col-sm-4">
                                     <select id="openDate" name="openDate" class="form-control input-sm"  required="required">
							              <option value="">请选择</option>
							              <option value="2009">2009</option>
							              <option value="2010">2010</option>
							              <option value="2011">2011</option>
							              <option value="2012">2012</option>
							              <option value="2013">2013</option>
							              <option value="2014">2014</option>
							              <option value="2015">2015</option>
							              <option value="2016" selected="selected">2016</option>
							              <option value="2017">2017</option>
							              <option value="2018">2018</option>
							              <option value="2019">2019</option>
							              <option value="2020">2020</option>
							          </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">债权描述：</label>
                                <div class="col-sm-6">
                                    <textarea id="description" name="description" class="form-control" rows="3"></textarea>
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
	$("#addFileUpload").append('<input class="form-control" type="file" name="uploadFiles" id="uploadFiles'+i+'" required="required" accept=".jpg,.png,.jpeg,.gif,.bmp"/>');
	$("#uploadFiles"+i).click();
	i++;
}
/* function addFileUpload(){
	$("#addFileUpload").append('<input class="form-control" type="file" name="uploadFiles" accept=".jpg,.png,.jpeg,.gif,.bmp"/>');
} */
function loadCity(obj) {
	var proName = $(obj).val();
	$.ajax({
		url : 'reward/loadCity',
		async : false,
		data : {
			"proName" : proName
		},
		type : "POST",
		success : function(data) {
			
			$("#debtCity").empty();
			$('#debtCity').append('<option>请选择</option>');
			$.each(data, function (i,item) {
				$('#debtCity').append('<option value='+item+'>'+item+'</option>');
		    });
		},
		error : function() {
			alert("获取城市数据失败");
		}
	});
}
</script>