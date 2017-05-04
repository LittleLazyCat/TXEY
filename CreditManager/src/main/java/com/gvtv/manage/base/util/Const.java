/*
 * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Apr 17, 2015    YangShengJun         Create the class
 */

package com.gvtv.manage.base.util;

import org.springframework.context.ApplicationContext;

/**
 * @FileName Const.java
 * @Description: 
 *
 * @Date Apr 19, 2015 
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class Const {

	public static final String COMMA = ",";

	public static final String SESSION_ROLES_NAME = "SESSION_ROLES_NAME";
	public static final String SESSION_ALL_RIGHTS_URL = "SESSION_ALL_RIGHTS_URL";
	
	
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_USER = "sessionUser";
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	
	public static final String SESSION_menuList = "menuList";			//当前菜单
	public static final String SESSION_ALLMENULIST = "allMenuList";		//全部菜单
	public static final String SESSION_ALLBUTTONLIST = "allButtonList"; //全部按钮
	public static final String SESSION_ALLUSERURL = "allUserUrl"; //全部按钮
	
	public static final String SESSION_userpds = "userpds";			
	
	public static final String SESSION_USERROL = "USERROL";				//用户对象
	public static final String SESSION_USERNAME = "loginName";			//用户名
	
	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String LOGIN = "/login_toLogin.do";				//登录地址
	
	public static final String SYSNAME = "admin/config/SYSNAME.txt";	//系统名称路径
	public static final String PAGE	   = "admin/config/PAGE.txt";		//分页条数配置路径
	public static final String EMAIL   = "admin/config/EMAIL.txt";		//邮箱服务器配置路径 TODO: email配置
	
	public static final String FILEPATHIMG = "uploadFiles/uploadImgs/";	//图片上传路径
	public static final String FILEPATHFILE = "uploadFiles/file/";		//文件上传路径

	/**
	 * datatable插件显示分页表格所需要的数据字段名称（已废弃）
	 */
	public static final String DISPLAYSTART = "iDisplayStart";
	public static final String DISPLAYLENGTH = "iDisplayLength";
	public static final String SECHO = "sEcho";
	public static final String TOTALRECORDS = "iTotalRecords";
	public static final String TOTALDISPLAYRECORDS = "iTotalDisplayRecords";
	public static final String DATA = "aaData";
	
	/**
	 * 原生的datatable插件显示分页表格所需要的数据字段名称（推荐使用）
	 */
	public static final String START = "start";
	public static final String LENGTH = "length";
	public static final String DRAW = "draw";
	public static final String RECORDSTOTAL = "recordsTotal";
	public static final String RECORDSFILTERED = "recordsFiltered";
	public static final String NDATA = "data";

	
	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化
	

	public static final String ADMIN_ROLE = "1";
	
}
