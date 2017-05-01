package com.txey.record.placeholder;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.txey.record.utils.DESUtils;

//继承PropertyPlaceholderConfigurer定义支持密文版属性的属性配置器
public class EncryptPropertyPlaceholderConfigure extends PropertyPlaceholderConfigurer {
	private String[] encryptPropNames = { "jdbc.username", "jdbc.password" };

	// 对特定属性的属性值进行转换
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (isEncryptProp(propertyName)) {
			String decryptValue = DESUtils.decodeStr(propertyValue);
			//System.out.println(decryptValue);
			return decryptValue;
		} else {
			return propertyValue;
		}
	}

	// 判断是否是需要进行解密的属性
	private boolean isEncryptProp(String propertyName) {
		for (String encryptPropName : encryptPropNames) {
			if (encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}
