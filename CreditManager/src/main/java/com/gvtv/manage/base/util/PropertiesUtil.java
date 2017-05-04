package com.gvtv.manage.base.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtil {
	
	private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

	private static Properties properties = null;

	public static String getValue(String key) {
		return properties.get(key).toString();
	}

	public static Integer getIntegerValue(String key) {
		return Integer.valueOf(getValue(key));
	}

	public static Long getLongValue(String key) {
		return Long.valueOf(Long.parseLong(getValue(key)));
	}

	static {
		try {
			properties = new Properties();
			properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			logger.error("Load order.properties faild!", e);
		}
	}
}
