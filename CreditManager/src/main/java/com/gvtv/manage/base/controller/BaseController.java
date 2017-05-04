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

package com.gvtv.manage.base.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gvtv.manage.base.system.entity.User;
import com.gvtv.manage.base.util.PageData;

/**
 * @FileName BaseController.java
 * @Description: Controller基类
 *
 * @Date Apr 17, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class BaseController {
	public PageData getPageData() {
		return new PageData(this.getRequest());
	}

	public ModelAndView getModelAndView() {
		return new ModelAndView();
	}

	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**@Title: initBinder 
	 * @Description:日期格式转换
	 * @param binder 
	 * @date Apr 17, 2015 
	 */  
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
	
	
	public User getCurrentUser()
	{
		Subject subject = SecurityUtils.getSubject();
		// User user = (User)
		// subject.getSession().getAttribute(Const.SESSION_USER);
		return (User) subject.getPrincipal();
	}
}
