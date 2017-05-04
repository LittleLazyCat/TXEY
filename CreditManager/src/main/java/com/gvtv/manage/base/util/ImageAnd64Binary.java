/*
 * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Apr 17, 2015    YangShengJun         Create the class
 */

package com.gvtv.manage.base.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * @FileName ImageAnd64Binary.java
 * @Description:
 *
 * @Date Apr 19, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class ImageAnd64Binary {
	public static void main(String[] args) {

		String imgSrcPath = "E:/www/Hydrangeas.jpg"; // 生成64编码的图片的路径
		// System.out.println(imgCreatePath);
		String strImg = getImageStr(imgSrcPath);
		System.out.println(strImg);

		// 字符串转图片文件
		String imgCreatePath = "E:/www/c.jpg"; // 将64编码生成图片的路径
		imgCreatePath = imgCreatePath.replaceAll("\\\\", "/");
		generateImage(strImg, imgCreatePath);
	}

	/**
	 * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	 * 
	 * @param imgSrcPath
	 *            生成base64编码的图片的路径
	 * @return
	 */
	public static String getImageStr(String imgSrcPath) {
		InputStream in = null;
		byte[] data = null;

		// 读取图片字节数组
		try {
			in = new FileInputStream(imgSrcPath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 对字节数组Base64编码
		Encoder encoder = Base64.getEncoder();

		return encoder.encodeToString(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * 对字节数组字符串进行Base64解码并生成图片
	 * 
	 * @param imgStr
	 *            转换为图片的字符串
	 * @param imgCreatePath
	 *            将64编码生成图片的路径
	 * @return
	 */
	public static boolean generateImage(String imgStr, String imgCreatePath) {
		if (imgStr == null) // 图像数据为空
			return false;
		Decoder decoder = Base64.getDecoder();
		try {
			// Base64解码
			byte[] b = decoder.decode(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}

			OutputStream out = new FileOutputStream(imgCreatePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}