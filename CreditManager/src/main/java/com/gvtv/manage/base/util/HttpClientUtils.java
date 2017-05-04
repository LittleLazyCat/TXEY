/*
 * Copyright(c) 2015 gvtv.com.cn All rights reserved.
 * distributed with this file and available online at
 * http://www.gvtv.com.cn/
 */
/**
 * @Description: 
 * @Date 2015年5月26日 下午7:34:45
 * @author wangyl
 * @version V1.0
 */
package com.gvtv.manage.base.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gvtv.manage.base.exception.HttpRequestException;

/**
 * @Description:
 * @Date 2015年5月26日 下午7:34:45
 * @author wangyl
 * @version V1.0
 */
public class HttpClientUtils {
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

	/**
	 * 发送 post请求
	 * 
	 * @Description:
	 * @param url
	 * @param paraMap
	 * @author wangyl
	 * @date 2015年5月26日
	 */
	public static String post(String url, Map<String, String> paraMap)throws HttpRequestException {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httpPost
		HttpPost httpPost = new HttpPost(url);
		// 创建参数队列
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		if (null != paraMap && paraMap.size() > 0) {
			for (Map.Entry<String, String> entry : paraMap.entrySet()) {
				formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
			httpPost.setEntity(uefEntity);
			logger.debug("executing request {}", httpPost.getURI());
			CloseableHttpResponse response = httpClient.execute(httpPost);
			return handleResponse(response);

		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException:{}",e.toString());
			throw new HttpRequestException("http request exception");
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException:{}",e.toString());
			throw new HttpRequestException("http request exception");
		} catch (IOException e) {
			logger.error("IOException:{}",e.toString());
			throw new HttpRequestException("http request exception");
		} finally {
			// 关闭连接,释放资源
			try {
				if (null != httpClient) {
					httpClient.close();
				}
			} catch (IOException e) {
				logger.error("IOException:{}",e.toString());
			}
		}
	}

	/**
	 * 发送 get请求
	 * 
	 * @Description:
	 * @param url
	 * @param paraMap
	 * @return
	 * @author wangyl
	 * @date 2015年5月26日
	 */
	public static String get(String url, Map<String, String> paraMap)throws HttpRequestException {
		String queryString = "";
		// 遍历拼接参数
		if (null != paraMap && paraMap.size() > 0) {
			for (Map.Entry<String, String> entry : paraMap.entrySet()) {
				logger.debug("key= {} and value={}", entry.getKey(), entry.getValue());
				queryString = queryString + "&" + entry.getKey() + "=" + entry.getValue();
			}
			queryString = queryString.substring(1);
		}
		if (null != queryString) {
			if (url.indexOf("?") < 0) {
				url = url + "?" + queryString;
			} else {
				url = url + "&" + queryString;
			}
		}
		return get(url);
	}

	/**
	 * 发送 get请求
	 */
	public static String get(String url)throws HttpRequestException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			// 创建httpGet.
			HttpGet httpGet = new HttpGet(url);
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(20000) .setConnectTimeout(20000).build();
			httpGet.setConfig(requestConfig);
			
			logger.debug("executing request {}", httpGet.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpClient.execute(httpGet);
			return handleResponse(response);

		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException:{}",e.toString());
			throw new HttpRequestException("http request exception");
		} catch (ParseException e) {
			logger.error("ParseException:{}",e.toString());
			throw new HttpRequestException("http request exception");
		} catch (IOException e) {
			logger.error("IOException:{}",e.toString());
			throw new HttpRequestException("http request exception");
		} finally {
			// 关闭连接,释放资源
			try {
				if (null != httpClient) {
					httpClient.close();
				}
			} catch (IOException e) {
				logger.error("IOException:{}",e.toString());
			}
		}
	}

	private static String handleResponse(CloseableHttpResponse response) throws HttpRequestException {
		try {
			// 打印响应状态
			logger.debug(response.getStatusLine().toString());
			if(response.getStatusLine().getStatusCode()!=200)
			{
				throw new HttpRequestException("http request exception");
			}
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				logger.debug("--------------------------------------");
				// 打印响应内容长度
				logger.debug("Response content length: {}", entity.getContentLength());
				// 打印响应内容
				String returnValue = EntityUtils.toString(entity, "UTF-8");
				logger.debug("Response content: {}" , returnValue);
				logger.debug("--------------------------------------");
				return returnValue;
			}
		}catch (IOException e)
		{
			logger.error("IOException:{}",e.toString());
			throw new HttpRequestException("http request exception");
		}
		finally {
			try {
				response.close();
			} catch (IOException e) {
				logger.error("IOException:{}",e.toString());
			}
		}
		return null;
	}
}
