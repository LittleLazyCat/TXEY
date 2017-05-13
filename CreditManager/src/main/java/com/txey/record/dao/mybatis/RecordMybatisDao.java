package com.txey.record.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import com.txey.record.model.Record;
import com.txey.record.model.RecordDetail;

public interface RecordMybatisDao {
	/**
	 * 
	 * 添加记录信息
	 * 
	 * @param record
	 *            记录表实体
	 * 
	 * @return
	 * 
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-17 22:44:01
	 * 
	 * 
	 */
	public void addRecord(Record record);

	/**
	 * 
	 * 查询某个月具体的出勤信息
	 * 
	 * @param hashMap
	 *            包含年和月的信息
	 * 
	 * @return List<RecordDetail> 返回查询到的一张表的信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-18 14:20:00
	 * 
	 * 
	 */
	public List<RecordDetail> getRecordDetail(HashMap<String, Integer> hashMap);
}
