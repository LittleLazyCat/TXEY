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
 * 2015年4月29日    dzk         Create the class
*/

package com.gvtv.manage.base.system.entity;

import java.util.List;

/**
 * @FileName Menu.java
 * @Description: 
 *
 * @Date 2015年4月29日 
 * @author dzk
 * @version 1.0
 * 
 */
public class Menu implements java.io.Serializable {
	
	
	private static final long serialVersionUID = 3545424220181410195L;
	private Integer menuId;
	private String menuName;
	private String menuUrl;
	private Integer parentId;
	private Integer menuOrder;
	private String menuIcon;
	private Integer menuType;
	private Integer removable;
	private String description;
	private Integer status;
	
	private Menu parentMenu;
	private List<Menu> subMenu;
	private List<Button> buttons;
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	public Menu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public List<Menu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}
	public Integer getRemovable() {
		return removable;
	}
	public void setRemovable(Integer removable) {
		this.removable = removable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<Button> getButtons() {
		return buttons;
	}
	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}
}
