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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.system.entity.User;
import com.gvtv.manage.base.util.AppUtil;
import com.gvtv.manage.base.util.Const;
import com.gvtv.manage.base.util.PageData;

/**
 * @FileName UserService.java
 * @Description:
 *
 * @Date 2015年5月9日
 * @author dzk
 * @version 1.0
 * 
 */
@Transactional(readOnly = true)
@Service("userService")
public class UserService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	/***********************************/
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void setSKIN(PageData pd) throws Exception {
		dao.update("UserXMapper.setSKIN", pd);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveIP(PageData pd) throws Exception {
		dao.update("UserXMapper.saveIP", pd);
	}

	public PageData getUserByNameAndPwd(PageData pd) throws Exception {
		return (PageData) dao.findForObject("UserMapper.getUserInfo", pd);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void updateLastLogin(PageData pd) throws Exception {
		dao.update("UserXMapper.updateLastLogin", pd);
	}

	/***********************************/

	public PageData list(PageData pd) throws Exception {
		PageData result = new PageData();
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			pd.put("keyword", "%" + search + "%");
		}
		int totalNum = (int) dao.findForObject("UserMapper.count", pd);

		pd.put("from", pd.getInteger("start"));
		pd.put("size", pd.getInteger("length"));
		List<PageData> pds = dao.findForList("UserMapper.list", pd);
		AppUtil.nullToEmpty(pds, new String[] { "loginName", "lastLogin", "email", "phone", "name" });

		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.RECORDSTOTAL, totalNum);
		result.put(Const.RECORDSFILTERED, totalNum);
		result.put(Const.NDATA, pds);
		return result;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void add(PageData pd) throws Exception {
		dao.save("UserMapper.add", pd);
	}

	public PageData getById(Integer userId) throws Exception {
		return (PageData) dao.findForObject("UserMapper.getById", userId);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void edit(PageData pd) throws Exception {
		dao.update("UserMapper.edit", pd);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void delete(Integer userId) throws Exception {
		dao.delete("UserMapper.delete", userId);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void batchDelete(String ids) throws Exception {
		if (StringUtils.isNotBlank(ids)) {
			String[] idArr = ids.split(",");
			if (idArr.length > 0) {
				List<Integer> idList = new ArrayList<Integer>();
				for (String idStr : idArr) {
					idList.add(Integer.valueOf(idStr));
				}
				dao.delete("UserMapper.batchDelete", idList);
			}
		}
	}

	public List<PageData> getRoles(Integer userId) throws Exception {
		List<PageData> roles = dao.findForList("RoleMapper.listAllRoles", null);
		List<PageData> userRoles = dao.findForList("UserMapper.listUserRoleByUserId", userId);
		for (PageData role : roles) {
			Integer roleId = role.getInteger("roleId");
			for (PageData userRole : userRoles) {
				if (roleId.equals(userRole.getInteger("roleId"))) {
					role.put("checked", true);
					break;
				}
			}
		}
		return roles;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void editRole(PageData pd) throws Exception {
		String roleIds = pd.getString("roleIds");
		if (StringUtils.isNotBlank(roleIds)) {
			List<PageData> list = new ArrayList<PageData>();
			Integer userId = pd.getInteger("userId");
			String[] roleIdArr = roleIds.split(",");
			for (String roleId : roleIdArr) {
				PageData p = new PageData();
				p.put("userId", userId);
				p.put("roleId", Integer.valueOf(roleId));
				list.add(p);
			}
			dao.delete("UserMapper.deleteUserRoleByUserId", userId);
			dao.batchSave("UserMapper.saveUserRoles", list);
		}
	}

	public boolean isNameExsit(PageData pd) throws Exception {
		String loginName = pd.getString("loginName").toLowerCase();
		pd.put("loginName", loginName);
		List<PageData> pds = dao.findForList("UserMapper.getByName", loginName);
		return pds.size() > 0 ? true : false;
	}

	public PageData editPassword(PageData pd) throws Exception {
		PageData result = new PageData();
		
		Subject subject = SecurityUtils.getSubject();
		User sessionUser = (User) subject.getSession().getAttribute(Const.SESSION_USER);

		PageData user = dao.findForObject("UserMapper.getById", sessionUser.getUserId());
		String loginName = user.getString("loginName");
		String encodePwd = new SimpleHash("SHA-1", loginName, pd.getString("oldpassword")).toString();
		if (user.getString("password").equals(encodePwd)) {
			pd.put("newEncodePwd", new SimpleHash("SHA-1", loginName, pd.getString("password")).toString());
			pd.put("userId", sessionUser.getUserId());
			dao.update("UserMapper.updatePassword", pd);
			result.put("status", 1);
		} else {
			result.put("status", 0);
			result.put("msg", "原密码错误");
		}
		return result;
	}

}
