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

package com.gvtv.manage.base.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @FileName PathUtil.java
 * @Description: 路径工具类
 *
 * @Date Apr 19, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class PathUtil {

	/*
	 * 获取classpath1
	 */
	public static String getClasspath() {
		String path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + "../../").replaceAll("file:/", "")
				.replaceAll("%20", " ").trim();
		if (path.indexOf(":") != 1) {
			path = File.separator + path;
		}
		return path;
	}

	/*
	 * 获取classpath2
	 */
	public static String getClassResources() {
		String path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))).replaceAll("file:/", "")
				.replaceAll("%20", " ").trim();
		if (path.indexOf(":") != 1) {
			path = File.separator + path;
		}
		return path;
	}

	public static String PathAddress() {
		String strResult = "";

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		StringBuffer strBuf = new StringBuffer();

		strBuf.append(request.getScheme() + "://");
		strBuf.append(request.getServerName() + ":");
		strBuf.append(request.getServerPort() + "");

		strBuf.append(request.getContextPath() + "/");

		strResult = strBuf.toString();// +"ss/";//加入项目的名称

		return strResult;
	}

}
