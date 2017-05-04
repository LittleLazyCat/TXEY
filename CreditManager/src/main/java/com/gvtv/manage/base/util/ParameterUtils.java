/*
 * Copyright(c) 2015 gvtv.com.cn All rights reserved.
 * distributed with this file and available online at
 * http://www.gvtv.com.cn/
 */
package com.gvtv.manage.base.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @Description:请求参数处理类
 * @version 1.0
 * @author wangyl
 */
public class ParameterUtils {

	public static String valueOf(String val) {
		return valueOf(val, null);
	}

	/**
	 * @Description:字符处理，把null替换为默认值
	 * @param val
	 * @param defualt
	 * @return
	 * @author wangyl
	 * @date 2015年5月7日
	 */
	public static String valueOf(String val, String defualt) {
		if (StringUtils.isBlank(val)) {
			val = defualt != null ? defualt : "";
		}
		return val;
	}

	/**
	 * @Description:请示参数解析
	 * @param paramStr
	 * @return
	 * @author wangyl
	 * @date 2015年5月7日
	 */
	public static Map<String, String> analyParam(String paramStr) {
		Map<String, String> paramMap = new HashMap<String, String>();
		String[] paramArray = paramStr.split("&");
		for (String pa : paramArray) {
			String[] param = pa.split("=");
			if (param.length == 2) {
				paramMap.put(param[0], param[1]);
			}
		}
		return paramMap;
	}
}
