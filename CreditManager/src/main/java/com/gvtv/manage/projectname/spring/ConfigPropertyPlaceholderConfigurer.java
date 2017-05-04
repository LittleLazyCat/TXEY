/*
 * Copyright(c) 2015 gvtv.com.cn All rights reserved.
 * distributed with this file and available online at
 * http://www.gvtv.com.cn/
 */
package com.gvtv.manage.projectname.spring;

import java.util.Enumeration;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @version 1.0
 * @author fish
 */
public class ConfigPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		Enumeration<Object> keys = props.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String value = props.getProperty(key);
			System.setProperty(key, value);
		}
		super.processProperties(beanFactory, props);
		
	}
}
