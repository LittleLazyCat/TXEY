package com.txey.record.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txey.record.dao.mybatis.ContactMybatisTemplateDao;
import com.txey.record.model.Contact;

@Transactional
@Service
public class ContactService {
	@Autowired
	private ContactMybatisTemplateDao contactMybatisTemplateDao;

	public List<Contact> getContact() {
		 return contactMybatisTemplateDao.getContact();
	}
}
