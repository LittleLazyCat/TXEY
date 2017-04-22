package com.txey.record.service.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txey.record.dao.mybatis.RecordMybatisTemplateDao;
import com.txey.record.model.Record;
import com.txey.record.model.RecordDetail;

@Transactional
@Service
public class RecordService {
	@Autowired
	private RecordMybatisTemplateDao recordMybatisTemplateDao;
	
	private Record record = new Record();
	
	public Record getRecord(){
		
		return record;
		
	}

	public void addRecord(Record record) {
		recordMybatisTemplateDao.addRecord(record);
	}

	public List<RecordDetail> getRecordDetail(HashMap<String, Integer> hashMap) {

		return recordMybatisTemplateDao.getRecordDetail(hashMap);
	}
}
