package com.netease.login.utils;

import java.util.HashMap;
import java.util.Map;

import com.netease.login.model.User;

public class TokenUserData {
	private TokenUserData() {
	}

	// �洢���ݵĶ���
	private static Map<String, User> dataMap = new HashMap<String, User>();

	/**
	 * �������ƴ洢
	 * 
	 * @param token
	 * @param user
	 */
	public static void addToken(String token, User user) {
		dataMap.put(token, user);
	}

	/**
	 * ��֤���ƣ����������Ч����User���󣬷��򷵻ؿ�
	 * 
	 * @param token
	 * @return
	 */
	public static User validateToken(String token) {
		return dataMap.get(token);
	}

	/**
	 * �Ƴ�token��
	 * 
	 * @param token
	 */
	public static void removeToken(String token) {
		dataMap.remove(token);
	}
}
