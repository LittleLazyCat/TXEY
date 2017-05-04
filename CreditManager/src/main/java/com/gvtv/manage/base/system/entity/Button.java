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

/**
 * @FileName Button.java
 * @Description: 
 *
 * @Date 2015年4月29日 
 * @author dzk
 * @version 1.0
 * 
 */
public class Button implements java.io.Serializable {
	
	private static final long serialVersionUID = 8552758267353482774L;
	private Integer buttonId;
	private Integer menuId;
	private String buttonName;
	private String buttonUrl;
	private Integer status;
	
	private boolean hasButton = false;
	
	public Integer getButtonId() {
		return buttonId;
	}
	public void setButtonId(Integer buttonId) {
		this.buttonId = buttonId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getButtonName() {
		return buttonName;
	}
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	public String getButtonUrl() {
		return buttonUrl;
	}
	public void setButtonUrl(String buttonUrl) {
		this.buttonUrl = buttonUrl;
	}
	public boolean isHasButton() {
		return hasButton;
	}
	public void setHasButton(boolean hasButton) {
		this.hasButton = hasButton;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
