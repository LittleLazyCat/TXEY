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

package com.gvtv.manage.base.system.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.util.AppUtil;
import com.gvtv.manage.base.util.Const;
import com.gvtv.manage.base.util.PageData;

/**
 * @FileName RoleService.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Transactional(readOnly=true)
@Service("roleService")
public class RoleService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	public PageData list(PageData pd) throws Exception {
		PageData result = new PageData();
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			pd.put("keyword", "%" + search + "%");
		}
		int totalNum = (int) dao.findForObject("RoleMapper.count", pd);
		
		pd.put("from", pd.getInteger("start"));
		pd.put("size", pd.getInteger("length"));
		List<PageData> pds = dao.findForList("RoleMapper.list", pd);
		AppUtil.nullToEmpty(pds, new String[]{"roleName", "description"});
		
		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.RECORDSTOTAL, totalNum);
		result.put(Const.RECORDSFILTERED, totalNum);
		result.put(Const.NDATA, pds);
		return result;
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void add(PageData pd) throws Exception {
		dao.save("RoleMapper.add", pd);
	}
	
	public PageData getById(Integer roleId) throws Exception {
		return (PageData) dao.findForObject("RoleMapper.getById", roleId);
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void edit(PageData pd) throws Exception {
		dao.update("RoleMapper.edit", pd);
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer delete(Integer roleId) throws Exception {
		return (Integer)dao.delete("RoleMapper.delete", roleId);
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public Integer batchDelete(PageData pd) throws Exception {
		List<Integer> idList = com.gvtv.manage.base.util.StringUtils.split(pd.getString("ids"), Const.COMMA);
		if (null != idList && idList.size() > 0) {
			pd.put("idList", idList);
			return (Integer)dao.delete("RoleMapper.batchDelete", pd);
		}
		return 0;
	}

	public List<PageData> listTreeData(Integer roleId) throws Exception {
		List<PageData> result = new ArrayList<PageData>();
		
		PageData pd = new PageData();
		pd.put("menuType", 1);
		List<PageData> menuList = dao.findForList("MenuMapper.listBy", pd);
		pd.put("menuType", 2);
		for (PageData menu : menuList) {
			PageData p1 = new PageData();
			p1.put("id", menu.getString("menuId"));
			p1.put("pId", menu.getString("parentId"));
			p1.put("name", menu.getString("menuName"));
			p1.put("open", "true");
			p1.put("resFlag", menu.getString("menuId") + "_" + menu.getString("menuType"));
			result.add(p1);
			
			pd.put("parentId", menu.getInteger("menuId"));
			List<PageData> subMenuList = dao.findForList("MenuMapper.listBy", pd);
			for (PageData subMenu : subMenuList) {
				PageData p2 = new PageData();
				p2.put("id", subMenu.getString("menuId"));
				p2.put("pId", subMenu.getString("parentId"));
				p2.put("name", subMenu.getString("menuName"));
				p2.put("open", "true");
				p2.put("resFlag", subMenu.getString("menuId") + "_" + subMenu.getString("menuType"));
				result.add(p2);
				
				List<PageData> buttonList = dao.findForList("ButtonMapper.listByMenuId", subMenu.getInteger("menuId"));
				for (PageData button : buttonList) {
					PageData p3 = new PageData();
					p3.put("id", button.getString("menuId") + "_" + button.getString("buttonId"));
					p3.put("pId", button.getString("menuId"));
					p3.put("name", button.getString("buttonName"));
					p3.put("open", "true");
					p3.put("resFlag", button.getString("buttonId") + "_" + 3);
					result.add(p3);
				}
			}
		}
		
		List<PageData> roleResList =  dao.findForList("RoleMapper.listResByRoleId", roleId);
		for (PageData roleRes : roleResList) {
			String resFlag = roleRes.getInteger("resourceId") + "_" + roleRes.getInteger("resourceType");
			for (PageData p : result) {
				if (resFlag.equals(p.getString("resFlag"))) {
					p.put("checked", true);
					break;
				}
			}
		}
		
		return result;
	}

	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public void editRight(PageData pd) throws Exception {
		String selRes = pd.getString("selRes");
		if (StringUtils.isNotBlank(selRes)) {
			List<PageData> list = new ArrayList<PageData>();
			Integer roleId = pd.getInteger("roleId");
			String[] resFlags = selRes.split(",");
			for (String resFlag : resFlags) {
				String[] resArr = resFlag.split("_");
				PageData p = new PageData();
				p.put("roleId", roleId);
				p.put("resourceId", Integer.valueOf(resArr[0]));
				p.put("resourceType", Integer.valueOf(resArr[1]));
				list.add(p);
			}
			dao.delete("RoleMapper.deleteResByRoleId", roleId);
			dao.batchSave("RoleMapper.saveRes", list);
		}
	}

}
