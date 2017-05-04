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

package com.gvtv.manage.base.system.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gvtv.manage.base.controller.BaseController;
import com.gvtv.manage.base.system.entity.User;
import com.gvtv.manage.base.system.service.UserService;
import com.gvtv.manage.base.util.AppUtil;
import com.gvtv.manage.base.util.Const;
import com.gvtv.manage.base.util.PageData;
import com.gvtv.manage.base.util.Tools;

/**
 * @FileName HeadController.java
 * @Description:
 *
 * @Date Apr 17, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/head")
public class HeadController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(HeadController.class);
	@Resource(name = "userService")
	private UserService userService;

	/**
	 * 获取头部信息
	 */
	@RequestMapping(value = "/getUname")
	@ResponseBody
	public Object getList() {
		PageData pd = new PageData();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();

			// shiro管理的session
			Subject currentUser = SecurityUtils.getSubject();
//			Session session = currentUser.getSession();
//
//			PageData pds = new PageData();
//			pds = (PageData) session.getAttribute("userpds");
//
//			if (null == pds) {
//				String loginName = session.getAttribute(Const.SESSION_USERNAME).toString(); // 获取当前登录者loginname
//				pd.put("loginName", loginName);
//				pds = userService.findByUId(pd);
//				session.setAttribute("userpds", pds);
//			}
//
//			pdList.add(pds);
//			map.put("list", pdList);
			map.put("userName", ((User)currentUser.getPrincipal()).getName());
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} 
		return AppUtil.returnObject(pd, map);
	}

	/**
	 * 保存皮肤
	 */
	@RequestMapping(value = "/setSKIN")
	public void setSKIN(PrintWriter out) {
		PageData pd = new PageData();
		try {
			pd = this.getPageData();

			// shiro管理的session
			Subject currentUser = SecurityUtils.getSubject();
			Session session = currentUser.getSession();

			String USERNAME = session.getAttribute(Const.SESSION_USERNAME).toString();// 获取当前登录者loginname
			pd.put("USERNAME", USERNAME);
			userService.setSKIN(pd);
			session.removeAttribute(Const.SESSION_userpds);
			session.removeAttribute(Const.SESSION_USERROL);
			out.write("success");
			out.close();
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}

	}

	/**
	 * 去系统设置页面
	 */
	@RequestMapping(value = "/system/form")
	public ModelAndView goEditEmail() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); // 读取系统名称
		pd.put("COUNTPAGE", Tools.readTxtFile(Const.PAGE)); // 读取每页条数

		mv.setViewName("system/head/sys_edit");
		mv.addObject("pd", pd);

		return mv;
	}

	/**
	 * 保存系统设置
	 */
	@RequestMapping(value = "/saveSys")
	public ModelAndView saveU(PrintWriter out) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Tools.writeFile(Const.SYSNAME, pd.getString("YSYNAME")); // 写入系统名称
		Tools.writeFile(Const.PAGE, pd.getString("COUNTPAGE")); // 写入每页条数
		mv.addObject("msg", "OK");
		mv.setViewName("save_result");
		return mv;
	}

}
