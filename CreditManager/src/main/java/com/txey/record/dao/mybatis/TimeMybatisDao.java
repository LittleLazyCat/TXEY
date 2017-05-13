package com.txey.record.dao.mybatis;

import java.util.List;

import com.txey.record.model.Time;

public interface TimeMybatisDao {
	/**
	 * 
	 * 获得修复时间信息
	 * 
	 * @param 
	 *            
	 * 
	 * @return List<Time> 返回查询到的修复时间的信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-19 22:12:00
	 * 
	 * 
	 */
	public List<Time> getTime();
}
