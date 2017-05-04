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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gvtv.manage.base.controller.BaseController;
import com.gvtv.manage.base.system.service.RoleService;
import com.gvtv.manage.base.util.PageData;

/**
 * @FileName RoleController.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Resource(name = "roleService")
	private RoleService roleService;
	
	@RequestMapping
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/role/role_list");
		return mv;
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public PageData list(){
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			result = roleService.list(pd);
		} catch (Exception e) {
			logger.error("list role error", e);
			result = new PageData();
		}
		return result;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView toAdd(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/role/role_add");
		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public PageData add(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			pd.put("status", 1);
			roleService.add(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add role error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView toEdit(@RequestParam Integer roleId){
		PageData pd = null;
		try {
			pd = roleService.getById(roleId);
		} catch (Exception e) {
			logger.error("get role error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("sys/role/role_edit");
		return mv;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public PageData edit(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			roleService.edit(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit role error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(@RequestParam Integer roleId){
		PageData result = new PageData();
		try {
			Integer line = roleService.delete(roleId);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败或者为不可删除状态");
			}
		} catch (Exception e) {
			logger.error("delete role error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/batchDelete")
	@ResponseBody
	public PageData batchDelete(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			int length = pd.getString("ids").split(",").length;
			Integer line =roleService.batchDelete(pd);
			if(line<length){
				result.put("status", 0);
				result.put("msg", "成功【"+line+"】条,失败【"+(length-line)+"】条");
			}else{
			result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("batch delete role error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/editRight", method=RequestMethod.GET)
	public ModelAndView toEditRight(@RequestParam Integer roleId){
		PageData pd = null;
		try {
			pd = roleService.getById(roleId);
		} catch (Exception e) {
			logger.error("to edit right error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("sys/role/role_right_edit");
		return mv;
	}
	
	@RequestMapping(value="/resNodes")
	@ResponseBody
	public List<PageData> resNodes(@RequestParam Integer roleId){
		List<PageData> treeData = null;
		try {
			treeData = roleService.listTreeData(roleId);
		} catch (Exception e) {
			logger.error("get res nodes error", e);
			treeData = new ArrayList<PageData>();
		}
		return treeData;
	}
	
	@RequestMapping(value="/editRight", method=RequestMethod.POST)
	@ResponseBody
	public PageData editRight(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			roleService.editRight(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit right error", e);
			result.put("status", 0);
			result.put("msg", "编辑权限失败");
		}
		return result;
	}

}
