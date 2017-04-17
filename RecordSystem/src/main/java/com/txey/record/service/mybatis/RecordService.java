package com.txey.record.service.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txey.record.dao.mybatis.RecordMybatisDao;
import com.txey.record.model.Record;

@Transactional
@Service
public class RecordService {
	@Autowired
	private RecordMybatisDao recordDao;
	public void addRecord(Record record){
		recordDao.addRecord(record);
	}
}
