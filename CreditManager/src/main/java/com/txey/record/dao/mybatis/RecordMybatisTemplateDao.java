package com.txey.record.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.txey.record.model.Record;
import com.txey.record.model.RecordDetail;

@Repository
public class RecordMybatisTemplateDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void addRecord(Record record) {
		RecordMybatisDao recordMybatisDao = sqlSessionTemplate.getMapper(RecordMybatisDao.class);
		recordMybatisDao.addRecord(record);
	}

	public List<RecordDetail> getRecordDetail(HashMap<String, Integer> hashMap) {
		RecordMybatisDao recordMybatisDao = sqlSessionTemplate.getMapper(RecordMybatisDao.class);
		return recordMybatisDao.getRecordDetail(hashMap);
	}
}
