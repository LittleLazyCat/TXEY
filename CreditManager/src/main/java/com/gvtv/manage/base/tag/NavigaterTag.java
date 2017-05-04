/*
 * Copyright(c) 2015 gvtv.com.cn All rights reserved.
 * distributed with this file and available online at
 * http://www.gvtv.com.cn/
 */
package com.gvtv.manage.base.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gvtv.manage.base.system.entity.Menu;
import com.gvtv.manage.base.system.service.MenuService;
import com.gvtv.manage.base.util.BeanFactoryUtils;

/**
 * @version 1.0
 * @author tangqian
 */
public class NavigaterTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(NavigaterTag.class);

	private String path;

	@Override
	public int doStartTag() throws JspException {
		MenuService menuService = BeanFactoryUtils.getFactory().getBean(MenuService.class);
		List<Menu> menus = null;
		try {
			menus = menuService.getHierarchyByPath(path);
		} catch (Exception e1) {
			logger.error("navigater tag init exception", e1);
		}
		JspWriter writer = pageContext.getOut();
		try {
			writer.append("<ol class='breadcrumb'>").append("	<li><a href='./'><i class='fa fa-dashboard'></i> 主页</a></li>");
			if (menus != null && !menus.isEmpty()) {
				writer.append("	<li class='active'>").append(menus.get(0).getMenuName()).append("</li>");
				if (menus.size() == 2) {
					writer.append("	<li><a href='").append(menus.get(1).getMenuUrl()).append("' data-target='navTab'>")
							.append(menus.get(1).getMenuName()).append("</a></li>");
				}
			}
			writer.append("</ol>");
			writer.flush();
		} catch (IOException e) {
			throw new JspException(e.getMessage(), e);
		}
		return super.doStartTag();
	}

	public void setPath(String path) {
		this.path = path;
	}

}
