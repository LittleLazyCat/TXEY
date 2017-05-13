package com.txey.record.dao.mybatis;

import java.util.List;

import com.txey.record.model.Method;

public interface MethodMybatisDao {
	/**
	 * 
	 * 获得维修方式信息
	 * 
	 * @param 
	 *           
	 * 
	 * @return List<Method> 返回查询到的维修方式的信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-19 21:12:00
	 * 
	 * 
	 */
	public List<Method> getMethod();
}
