package com.txey.record.utils;

import org.apache.commons.codec.binary.Base64; 

public class DESUtils {
	/** 
	 * 解密 
	 *  
	 * @param pwd 
	 * @return 
	 * @see [类、类#方法、类#成员] 
	 */  
	public static String decodeStr(String pwd)  
	{  
	    Base64 base64 = new Base64();  
	    byte[] debytes = base64.decodeBase64(new String(pwd).getBytes());  
	    return new String(debytes);  
	}  
	  
	/** 
	 * 加密 
	 *  
	 * @param pwd 
	 * @return 
	 * @see [类、类#方法、类#成员] 
	 */  
	public static String encodeStr(String pwd)  
	{  
	    Base64 base64 = new Base64();  
	    byte[] enbytes = base64.encodeBase64Chunked(pwd.getBytes());  
	    return new String(enbytes);  
	}  


}
