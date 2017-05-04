<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-default" style="background-color: #438eb9;margin-bottom: 0px;">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#admin">
                <span class="sr-only">全球网络监控系统</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <span class="navbar-brand" ><i class="glyphicon glyphicon-leaf"></i>全球网络监控系统</span>
        </div>
        <div class="collapse navbar-collapse" id="admin">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown" style="width: 160px;">
                    <a href="javascript:;" class="dropdown-toggle" id="user_ul_menu" data-toggle="dropdown" role="button" aria-expanded="false"><i class="glyphicon glyphicon-user"></i>用户 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="user_ul_menu">
                        <li><a href="javascript:;" data-url="user/editPassword/form?userId=${user.userId }" data-targetid="editpassword"  data-model='dialog'  ><i class="glyphicon glyphicon-user"></i>修改密码</a></li>
<!--                         <li><a href="javascript:;"><i class="glyphicon glyphicon-cog"></i>系统设置</a></li> -->
                        <li class="divider"></li>
                        <li><a href="logout" ><i class="glyphicon glyphicon-off"></i>退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
