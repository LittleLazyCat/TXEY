package com.txey.record.dao.mybatis;

import java.util.List;

import com.txey.record.model.Dept;

public interface DeptMybatisDao {
	/**
	 * 
	 * 获得部门信息
	 * 
	 * @param 
	 *            
	 * 
	 * @return List<Dept> 返回查存到的部门信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-19 10:48:00
	 * 
	 * 
	 */
	public List<Dept> getDept();
}
