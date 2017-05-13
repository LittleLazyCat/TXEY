package com.txey.record.dao.mybatis;

import java.util.List;

import com.txey.record.model.Kind;

public interface KindMybatisDao {
	/**
	 * 
	 * 获得类型信息
	 * 
	 * @param
	 * 
	 * 
	 * @return List<Kind> 返回类型信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-19 20:50:00
	 * 
	 * 
	 */
	public List<Kind> getKind();
}
