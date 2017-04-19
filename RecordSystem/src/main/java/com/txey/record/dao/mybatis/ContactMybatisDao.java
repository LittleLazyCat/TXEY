package com.txey.record.dao.mybatis;

import java.util.List;

import com.txey.record.model.Contact;

public interface ContactMybatisDao {
	/**
	 * 
	 * 获得联系方式
	 * 
	 * @param 
	 *            
	 * 
	 * @return List<Contact>> 返回查存到的一张表的信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-19 8:22:00
	 * 
	 * 
	 */
	public List<Contact> getContact();
}
