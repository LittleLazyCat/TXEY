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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gvtv.manage.base.controller.BaseController;
import com.gvtv.manage.base.system.service.UserService;
import com.gvtv.manage.base.util.PageData;

/**
 * @FileName UserController.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping(value="/editPwd", method=RequestMethod.GET)
	public ModelAndView editPwd(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/admin/editPassword");
		return mv;
	}
	
	@RequestMapping(value="/editPwd", method=RequestMethod.POST)
	@ResponseBody
	public PageData doEditPwd(){
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			result = userService.editPassword(pd);
		} catch (Exception e) {
			logger.error("edit password error", e);
			result = new PageData();
			result.put("status", 0);
			result.put("msg", "系统发生异常");
		}
		return result;
	}
	
	@RequestMapping(value="/unauthorized")
	public ModelAndView unauthorized(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/admin/unauthorized");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/user/user_list");
		return mv;
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public PageData list(){
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			result = userService.list(pd);
		} catch (Exception e) {
			logger.error("list user error", e);
			result = new PageData();
		}
		return result;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView toAdd(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/user/user_add");
		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public PageData add(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			String loginName = pd.getString("loginName").toLowerCase();
			pd.put("loginName", loginName);// 登录名统一转换成小写
			if(userService.isNameExsit(pd)){
				result.put("status", 0);
				result.put("msg", "用户名重复，请修改");
			}else{
				String password = pd.getString("password");
				password = new SimpleHash("SHA-1", loginName, password).toString();
				pd.put("password", password);
				pd.put("status", 1);
				
				userService.add(pd);
				result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("add user error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	@RequestMapping(value="/checkName", method=RequestMethod.POST)
	@ResponseBody
	public int checkName(){
		int result = 0;
		try {
			PageData pd = super.getPageData();
			if(userService.isNameExsit(pd)){
				result = 1;
			}
		} catch (Exception e) {
			logger.error("check group name error", e);
		}
		return result;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView toEdit(@RequestParam Integer userId){
		PageData pd = null;
		try {
			pd = userService.getById(userId);
		} catch (Exception e) {
			logger.error("get user error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("sys/user/user_edit");
		return mv;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public PageData edit(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			String password = pd.getString("password");
			if (StringUtils.isNotBlank(password)) {
				Integer userId = pd.getInteger("userId");
				PageData user = userService.getById(userId);
				String loginName = user.getString("loginName");
				password = new SimpleHash("SHA-1", loginName, password).toString();
				pd.put("password", password);
			}else{
				pd.remove("password");
			}
			
			userService.edit(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit user error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(@RequestParam Integer userId){
		PageData result = new PageData();
		try {
			//userService.delete(userId);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("delete user error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/batchDelete")
	@ResponseBody
	public PageData batchDelete(@RequestParam String ids){
		PageData result = new PageData();
		try {
			userService.batchDelete(ids);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("batch delete user error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/editRole", method=RequestMethod.GET)
	public ModelAndView toEditRole(@RequestParam Integer userId){
		List<PageData> roles = null;
		try {
			roles = userService.getRoles(userId);
		} catch (Exception e) {
			logger.error("to edit role error", e);
			roles = new ArrayList<PageData>();
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("userId", userId);
		mv.addObject("roles", roles);
		mv.setViewName("sys/user/user_role_edit");
		return mv;
	}
	
	@RequestMapping(value="/editRole", method=RequestMethod.POST)
	@ResponseBody
	public PageData editRole(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			userService.editRole(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit role error", e);
			result.put("status", 0);
			result.put("msg", "授权失败");
		}
		return result;
	}

}
