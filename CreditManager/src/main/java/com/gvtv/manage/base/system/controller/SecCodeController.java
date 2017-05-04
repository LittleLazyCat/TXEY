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

package com.gvtv.manage.base.system.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @FileName SecCodeController.java
 * @Description:
 *
 * @Date Apr 17, 2015
 * @author YangShengJun
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/code")
public class SecCodeController {

	 @RequestMapping
	  public void generate(HttpServletResponse response)
	  {
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    String code = drawImg(output);

	    Subject currentUser = SecurityUtils.getSubject();
	    Session session = currentUser.getSession();
	    session.setAttribute("sessionSecCode", code);
	    try
	    {
	      ServletOutputStream out = response.getOutputStream();
	      output.writeTo(out);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }

	  public String getRandomString(String base, int length) {
	    if (base == null) base = "0123456789";
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < length; ++i) {
	      int number = random.nextInt(base.length());

	      sb.append(base.charAt(number));
	    }
	    return sb.toString();
	  }

	  private String drawImg(ByteArrayOutputStream output) {
	    String code = getRandomString(null, 4);

	    int width = 70;
	    int height = 25;
	    BufferedImage bi = new BufferedImage(width, height, 5);
	    Font font = new Font("Times New Roman", 0, 20);
	    Graphics2D g = bi.createGraphics();
	    g.setFont(font);
	    Color color = new Color(66, 2, 82);
	    g.setColor(color);
	    g.setBackground(new Color(226, 226, 240));
	    g.clearRect(0, 0, width, height);
	    FontRenderContext context = g.getFontRenderContext();
	    Rectangle2D bounds = font.getStringBounds(code, context);
	    double x = (width - bounds.getWidth()) / 2.0D;
	    double y = (height - bounds.getHeight()) / 2.0D;
	    double ascent = bounds.getY();
	    double baseY = y - ascent;
	    g.drawString(code, (int)x, (int)baseY);
	    g.dispose();
	    try {
	      ImageIO.write(bi, "jpg", output);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return code;
	  }
	}