package com.txey.record.dao.mybatis;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.txey.record.model.Record;

@Repository
public class RecordMybatisTemplateDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void addRecord(Record record) {
		RecordMybatisDao recordMybatisDao = sqlSessionTemplate.getMapper(RecordMybatisDao.class);
		recordMybatisDao.addRecord(record);
	}

	
}
