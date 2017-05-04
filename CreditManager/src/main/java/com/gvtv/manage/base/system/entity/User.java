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
 * 2015年4月30日    dzk         Create the class
*/

package com.gvtv.manage.base.system.entity;

import java.util.List;

import com.gvtv.manage.base.entity.Page;

/**
 * @FileName User.java
 * @Description: 
 *
 * @Date 2015年4月30日 
 * @author dzk
 * @version 1.0
 * 
 */
public class User implements java.io.Serializable {
	private static final long serialVersionUID = -346978623857415499L;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSkin() {
		return skin;
	}
	public void setSkin(Integer skin) {
		this.skin = skin;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	private Integer userId; // 用户id
	private String loginName; // 用户名
	private String password; // 密码
	private String name; // 姓名
	private String lastLogin; // 最后登录时间
	private String ip; // 用户登录ip地址
	private Integer status; // 状态
	private String description; // 用户登录ip地址
	private String email; // 用户登录ip地址
	private String phone; // 用户登录ip地址
	private Integer skin; // 皮肤
	private List<Role> roles;
	private Page page; // 分页对象
	

}
