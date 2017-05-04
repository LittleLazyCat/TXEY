/*
 * Copyright 2012-2013 the original author or authors.
 * distributed with this file and available online at
 * http://www.xxxx.com/
 */
package com.gvtv.manage.projectname.spring;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * Logback日志监听器，参数名称为：logbackConfigLocation
 * 
 * @author Fish Exp 2012-12-3 下午1:14:01
 */
public class LogbackConfigListener implements ServletContextListener {
	private static final String CONFIG_LOCATION = "logbackConfigLocation";
	private String CLASSPATH_ALL_URL_PREFIX = "classpath*:";
	private String CLASSPATH_PREFIX = "classpath:";

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String logbackConfigLocation = event.getServletContext().getInitParameter(CONFIG_LOCATION);
		String fn = null;
		// 从web.xml中加载指定文件名的日志配置文件
		if (logbackConfigLocation.startsWith(CLASSPATH_ALL_URL_PREFIX)) {
			fn = findAllClassPathResources(logbackConfigLocation.replace(CLASSPATH_ALL_URL_PREFIX, "")).getFile();
		} else if (logbackConfigLocation.startsWith(CLASSPATH_PREFIX)) {
			fn = findAllClassPathResources(logbackConfigLocation.replace(CLASSPATH_PREFIX, "")).getFile();
		} else {
			fn = event.getServletContext().getRealPath(logbackConfigLocation);
		}
		try {
			LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
			loggerContext.reset();
			JoranConfigurator joranConfigurator = new JoranConfigurator();
			joranConfigurator.setContext(loggerContext);
			joranConfigurator.doConfigure(fn);
		} catch (JoranException e) {
			System.out.println("加载配置文件失败 " + e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	private URL findAllClassPathResources(String location) {
		if (location.startsWith("/")) {
			location = location.substring(1);
		}
		URL path = getClassLoader().getResource(location);
		return path;
	}

	private ClassLoader getClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Throwable ex) {
			// Cannot access thread context ClassLoader - falling back to system
			// class loader...
		}
		if (cl == null) {
			// No thread context class loader -> use class loader of this class.
			cl = LogbackConfigListener.class.getClassLoader();
		}
		return cl;
	}
}
