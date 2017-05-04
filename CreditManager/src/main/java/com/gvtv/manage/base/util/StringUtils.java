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
 * 2015年5月15日    yangzs         Create the class
 */

package com.gvtv.manage.base.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @FileName StringUtils.java
 * @Description:
 *
 * @Date 2015年5月15日
 * @author yangzs
 * @version 1.0
 * 
 */
public class StringUtils {

	private static final Log logger = LogFactory.getLog(StringUtils.class);

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 * @author yangzs
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim());
	}

	/**
	 * 判断字符串是否不为空
	 * 
	 * @param str
	 * @return
	 * @author yangzs
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 获取Object对象字符串
	 * 
	 * @param obj
	 * @return
	 * @author yangzs
	 */
	public static String string(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString();
	}

	/**
	 * 生成32位的UUID字符串
	 * 
	 * @return
	 * @author yangzs
	 */
	public static String getUUID32() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static List<String> splitToStr(String fromString, String separate) {
		List<String> backList = new ArrayList<String>();
		if (isEmpty(fromString)) {
			return null;
		} else {
			String[] ids = fromString.split(separate);
			for (int i = 0; i < ids.length; i++) {
				if (isEmpty(ids[i])) {
					continue;
				}
				if (isEmpty(ids[i].trim()) || ids[i].trim().equals(separate)) {
					continue;
				}
				backList.add(ids[i]);
			}
		}
		return backList;
	}

	public static List<Integer> split(String fromString, String separate) {
		List<Integer> backList = new ArrayList<Integer>();
		if (isEmpty(fromString)) {
			return null;
		} else {
			String[] ids = fromString.split(separate);
			for (int i = 0; i < ids.length; i++) {
				if (isEmpty(ids[i])) {
					continue;
				}
				if (isEmpty(ids[i].trim()) || ids[i].trim().equals(separate)) {
					continue;
				}
				try {
					backList.add(Integer.parseInt(ids[i].trim()));
				} catch (Exception e) {
					logger.error("转换信息有误,无法转换为Integer类型。fromString = " + fromString);
					continue;
				}
			}
		}
		return backList;
	}

	public static String clean(String str, String separate) {
		List<Integer> list = split(str, separate);
		StringBuilder backStr = new StringBuilder();
		if (null != list && list.size() > 0) {
			int len = list.size();
			for (int i = 0; i < len; i++) {
				backStr.append(separate).append(list.get(i));
			}
			backStr.append(separate);
		}
		return backStr.toString();
	}

	public static String clear(String str) {
		if (isEmpty(str)) {
			return "";
		}
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	/**
	 * 只允许字母和数字
	 * 
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	public static String rename(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		String regEx = "[^a-zA-Z0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
}
