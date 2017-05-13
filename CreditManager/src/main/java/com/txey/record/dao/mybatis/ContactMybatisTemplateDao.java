package com.txey.record.dao.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.txey.record.model.Contact;

@Repository
public class ContactMybatisTemplateDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public List<Contact> getContact() {
		ContactMybatisDao contactMybatisDao = sqlSessionTemplate.getMapper(ContactMybatisDao.class);
		return contactMybatisDao.getContact();
	}
}
