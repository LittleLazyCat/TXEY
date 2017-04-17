package com.txey.record.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.txey.record.model.Record;

@Repository
public class RecordDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//添加记录信息
	public void insertRecordInfo(Record record) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into tb_record_contact(jlsj,ksid,lxid,lyid,wtms,fsid,sjid, ");
		sql.append(" wxfy,ygid,ztid,qrbz,wxbz values( ");
		sql.append(" ?,?,?,?,?,?,?,?,?,?,?,?)");
		jdbcTemplate.update(sql.toString(), record.getJlsj(),record.getDept().getKsid(),record.getKind().getLxid(),record.getContact().getLyid(),record.getWtms(),record.getMethod().getFsid(),record.getTime().getSjid(),record.getWxfy(),record.getEmployee().getYgid(),record.getState().getZtid(),record.getQrzt(),record.getWxbz());
	}

}
