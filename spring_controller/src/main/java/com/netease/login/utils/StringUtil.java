package com.netease.login.utils;

public class StringUtil {
	private StringUtil() {
	}

	/**
	 * �Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return null��մ���ȫΪ�հ��ַ��Ĵ�
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}

		if (str.trim().length() == 0) {
			return true;
		}

		return false;
	}
}
