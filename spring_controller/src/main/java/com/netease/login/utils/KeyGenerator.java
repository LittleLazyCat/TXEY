package com.netease.login.utils;

import java.util.UUID;

public class KeyGenerator {
	private KeyGenerator() {
	}

	/**
	 * ���ɱ�ʶ,��32λ16�����ַ���ɣ���ĸСд
	 */
	public static String generate() {
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
}
