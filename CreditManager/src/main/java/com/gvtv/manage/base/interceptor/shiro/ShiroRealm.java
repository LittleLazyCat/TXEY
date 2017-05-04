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

package com.gvtv.manage.base.interceptor.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.gvtv.manage.base.system.entity.User;
import com.gvtv.manage.base.util.Const;

/**
 * @FileName ShiroRealm.java
 * @Description: 认证和鉴权
 *
 * @Date Apr 17, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class ShiroRealm extends AuthorizingRealm {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org
	 * .apache.shiro.authc.AuthenticationToken) 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String username = (String) token.getPrincipal(); // user account
		String password = new String((char[]) token.getCredentials()); // password

		// 已经在login_login验证过用户名和密码
		if (null != username && null != password) {
			Subject subject = SecurityUtils.getSubject();
			User user = (User) subject.getSession().getAttribute(Const.SESSION_USER);
			return new SimpleAuthenticationInfo(user, password, getName());// TODO:
																			// 要用login_name
																			// ,
																			// 待验证。

		} else {
			return null;
		}

	}

	@Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        Permission p = getPermissionResolver().resolvePermission(permission);
        Subject subject = SecurityUtils.getSubject();
        boolean isAdmin= subject.hasRole(Const.ADMIN_ROLE);
        if(isAdmin) return true;
        return true;
        //return isPermitted(principals, p);
    }
    
	/*
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
	 * .shiro.subject.PrincipalCollection) 鉴权
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		User sysUser = (User) principals.fromRealm(getName()).iterator().next();
		if (null != sysUser) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			if (session.getAttribute(Const.SESSION_ROLES_NAME) != null)
				info.addRoles((List<String>) session.getAttribute(Const.SESSION_ROLES_NAME));
			if (session.getAttribute(Const.SESSION_ALL_RIGHTS_URL) != null)
				info.addStringPermissions((List<String>) session.getAttribute(Const.SESSION_ALL_RIGHTS_URL));

			// 添加角色信息

			// TODO:貌似每次鉴权都会操作一次数据库，待验证

			// try {
			//
			// //当前用户下的所有menu
			// List<Menu> menuList=new ArrayList<>();
			// //当前用户下的所有button
			// List<Button> buttonList=new ArrayList<>();
			//
			// List<String> roles = (List<String>)
			// dao.findForList("RoleMapper.findRolesNameByUserId",
			// sysUser.getUserId());
			//
			// info.addRoles(roles);// TODO change to roleCode
			//
			// // 添加菜单权限信息（含分类菜单）
			// List<Menu> menus = (List<Menu>)
			// dao.findForList("MenuMapper.findParentMenusByUserId",
			// sysUser.getUserId());
			// menuList.addAll(menus);
			// for (Menu menu : menus) {
			// info.addStringPermission(menu.getMenuUrl());
			//
			// Map<String, Integer> params=new HashMap<>();
			// params.put("userId", sysUser.getUserId());
			// params.put("menuId", menu.getMenuId());
			// List<Menu> subMenus = (List<Menu>)
			// dao.findForList("MenuMapper.findMenusByUserIdAndParent", params);
			// menu.setSubMenu(subMenus);
			//
			// for (Menu subMenu : subMenus) {
			// info.addStringPermission(subMenu.getMenuUrl());
			// }
			//
			// }
			//
			// // 添加按钮权限信息
			// List<Button> buttons = (List<Button>)
			// dao.findForList("ButtonMapper.findMenusByUserId",
			// sysUser.getUserId());
			// buttonList.addAll(buttons);
			// for (Button button : buttons) {
			// info.addStringPermission(button.getButtonUrl());
			// }
			//
			//
			// Subject subject = SecurityUtils.getSubject();
			// //菜单和按钮数据，用于登陆成功后生成菜单树
			// subject.getSession().setAttribute(Const.SESSION_ALLMENULIST,
			// menus);
			// subject.getSession().setAttribute(Const.SESSION_ALLBUTTONLIST,
			// buttonList);
			//
			// } catch (Exception e) {
			// e.printStackTrace();
			// return null;
			// }

			return info;
		}
		return null;
	}

}
