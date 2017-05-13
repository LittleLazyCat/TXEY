package com.txey.record.dao.mybatis;

import java.util.List;

import com.txey.record.model.State;

public interface StateMybatisDao {
	/**
	 * 
	 * 获得完成状态信息
	 * 
	 * @param 
	 *            
	 * 
	 * @return List<State> 返回查询到的完成状态的信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-19 21:52:00
	 * 
	 * 
	 */
	public List<State> getState();
}
