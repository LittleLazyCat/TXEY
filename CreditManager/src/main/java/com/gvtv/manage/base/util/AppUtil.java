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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @FileName AppUtil.java
 * @Description:
 *
 * @Date Apr 19, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class AppUtil {

	private static Logger logger = LoggerFactory.getLogger(AppUtil.class);

//	// 检查参数是否完整
//	public static boolean checkParam(String method, PageData pd) {
//		boolean result = false;
//
//		int falseCount = 0;
//		String[] paramArray = new String[20];
//		String[] valueArray = new String[20];
//		String[] tempArray = new String[20]; // 临时数组
//
//
//		int size = paramArray.length;
//		for (int i = 0; i < size; i++) {
//			String param = paramArray[i];
//			if (!pd.containsKey(param)) {
//				tempArray[falseCount] = valueArray[i] + "--" + param;
//				falseCount += 1;
//			}
//		}
//
//		if (falseCount > 0) {
//			logger.error(method + "接口，请求协议中缺少 " + falseCount + "个 参数");
//			for (int j = 1; j <= falseCount; j++) {
//				logger.error("   第" + j + "个：" + tempArray[j - 1]);
//			}
//		} else {
//			result = true;
//		}
//
//		return result;
//	}

	/**
	 * 设置分页的参数
	 * 
	 * @param pd
	 * @return
	 */
	public static PageData setPageParam(PageData pd) {
		String page_now_str = pd.get("page_now").toString();
		int pageNowInt = Integer.parseInt(page_now_str) - 1;
		String page_size_str = pd.get("page_size").toString(); // 每页显示记录数
		int pageSizeInt = Integer.parseInt(page_size_str);

		String page_now = pageNowInt + "";
		String page_start = (pageNowInt * pageSizeInt) + "";

		pd.put("page_now", page_now);
		pd.put("page_start", page_start);

		return pd;
	}

	public static Object returnObject(PageData pd, @SuppressWarnings("rawtypes") Map map) {
		if (pd.containsKey("callback")) {
			String callback = pd.get("callback").toString();
			//return new JSONPObject(callback, map);
			return new HashMap<String, Object>().put(callback, map);
		} else {
			return map;
		}
	}
	
	public static void nullToEmpty(PageData pd, String... keys) {
		for (String key : keys) {
			if (pd.get(key) == null) {
				pd.put(key, "");
			}
		}
	}
	
	public static void nullToEmpty(Collection<PageData> pds, String... keys) {
		for (PageData pd : pds) {
			nullToEmpty(pd, keys);
		}
	}

	public static void emptyToNull(PageData pd, String... keys) {
		for (String key : keys) {
			if (pd.get(key) != null && pd.get(key).equals("")) {
				pd.put(key, null);
			}
		}
	}
	
	public static void emptyToNull(Collection<PageData> pds, String... keys) {
		for (PageData pd : pds) {
			emptyToNull(pd, keys);
		}
	}
}