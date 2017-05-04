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

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * @FileName FileDownload.java
 * @Description:
 *
 * @Date Apr 19, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class FileDownload {

	/**
	 * @param response
	 * @param filePath
	 *            //文件完整路径(包括文件名和扩展名)
	 * @param fileName
	 *            //下载后看到的文件名
	 * @return 文件名
	 */
	public static void fileDownload(final HttpServletResponse response, String filePath, String fileName) throws Exception {

		byte[] data = FileUtil.toByteArray2(filePath);
		fileName = URLEncoder.encode(fileName, "UTF-8");
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		response.addHeader("Content-Length", "" + data.length);
		response.setContentType("application/octet-stream;charset=UTF-8");
		OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
		outputStream.write(data);
		outputStream.flush();
		outputStream.close();
		response.flushBuffer();

	}

}
