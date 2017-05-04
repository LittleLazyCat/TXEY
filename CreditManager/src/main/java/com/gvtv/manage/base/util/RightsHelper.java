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

import java.math.BigInteger;

/**
 * @author Administrator
 * 权限计算帮助类
 */
public class RightsHelper {
	/**
	 * 利用BigInteger对权限进行2的权的和计算
	 * @param rights int型权限编码数组
	 * @return 2的权的和
	 */
	public static BigInteger sumRights(int[] rights){
		BigInteger num = new BigInteger("0");
		for(int i=0; i<rights.length; i++){
			num = num.setBit(rights[i]);
		}
		return num;
	}
	/**
	 * 利用BigInteger对权限进行2的权的和计算
	 * @param rights String型权限编码数组
	 * @return 2的权的和
	 */
	public static BigInteger sumRights(String[] rights){
		BigInteger num = new BigInteger("0");
		for(int i=0; i<rights.length; i++){
			num = num.setBit(Integer.parseInt(rights[i]));
		}
		return num;
	}
	
	/**
	 * 测试是否具有指定编码的权限
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(BigInteger sum,int targetRights){
		return sum.testBit(targetRights);
	}
	
	/**
	 * 测试是否具有指定编码的权限
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(String sum,int targetRights){
		if(Tools.isEmpty(sum))
			return false;
		return testRights(new BigInteger(sum),targetRights);
	}
	
	/**
	 * 测试是否具有指定编码的权限
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(String sum,String targetRights){
		if(Tools.isEmpty(sum))
			return false;
		return testRights(new BigInteger(sum),targetRights);
	}
	
	/**
	 * 测试是否具有指定编码的权限
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(BigInteger sum,String targetRights){
		return testRights(sum,Integer.parseInt(targetRights));
	}
}
