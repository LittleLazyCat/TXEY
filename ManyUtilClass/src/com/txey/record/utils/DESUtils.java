package com.txey.record.utils;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class DESUtils {
	// 指定DES加密解密所使用的秘钥
	private static Key key;
	private static String KEY_STR = "myKey";

	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			generator = null;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	// 对字符串进行DES加密，返回BASE64编码的加密字符串
	public static String getEncryptString(String str) {
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byte[] strBytes = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64en.encode(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 对BASE64编码的加密字符串进行解密，返回解密后的 字符串
	public static String getDecryptString(String str) {
		BASE64Decoder base64de = new BASE64Decoder();
		try {
			byte[] strBytes = base64de.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 加密
	public static String encodeStr(String pwd) {
		Base64 base64 = new Base64();
		byte[] enbytes = base64.encodeBase64Chunked(pwd.getBytes());
		return new String(enbytes);
	}

	// 解密
	public static String decodeStr(String pwd) {
		Base64 base64 = new Base64();
		byte[] debytes = base64.decodeBase64(new String(pwd).getBytes());
		return new String(debytes);
	}

	public static void main(String[] args) {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/xxk?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "qwert1234";
		// System.out.println("username = " + getEncryptString(username));
		// System.out.println("password = " + getEncryptString(password));
		// System.out.println(getDecryptString("7nU0iYq5ejbpAwYcAA6x8Q=="));
		System.out.println("username = " + encodeStr(username));
		System.out.println("password = " + encodeStr(password));
		System.out.println("driver = " + encodeStr(driver));
		System.out.println("url = " + encodeStr(url));
		System.out.println(decodeStr("cXdlcnQxMjM0"));

	}

}
