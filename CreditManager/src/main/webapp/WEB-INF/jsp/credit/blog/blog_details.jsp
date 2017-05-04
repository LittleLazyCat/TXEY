<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="${ctx}/static/AdminLTE/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${ctx}/static/AdminLTE/dist/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/static/AdminLTE/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script src="${ctx}/static/AdminLTE/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <title>${blog.blogTitle}</title>

</head>
<body class="gray-bg top-navigation">
    <div id="wrapper">
        <div id="page-wrapper" class="gray-bg">
            
            <div class="wrapper wrapper-content">
                <div class="container">                    
                    <div class="row">
			            <div class="col-sm-12">
			                <div class="ibox">
			                    <div class="ibox-content">
			                        <div class="text-center article-title">
			                            <h1>
			                            	${blog.blogTitle }
			                            </h1>
			                        </div>
			                        <div style="text-align: center;">
			                            <span class="btn btn-white btn-xs">来源：${blog.blogSource}</span>
			                            <span class="btn btn-white btn-xs">作者：${blog.blogAuthor}</span>
			                            <span class="btn btn-white btn-xs"><fmt:formatDate value="${blog.createTime}" type="date" dateStyle="long"/></span>
			                        </div><br/>
			                        <hr>
			                        <p style="font-size: 16px">
			                        	${blog.blogContext}
			                        </p>
			                        <hr>
			
			                    </div>
			                </div>
			            </div>
			        </div>

                     </div>
                </div>

            </div>

        </div>
    </div>
</body>
</html>