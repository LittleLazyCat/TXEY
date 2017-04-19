package com.txey.record.dao.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.txey.record.model.Time;

@Repository
public class TimeMybatisTemplateDao {
@Autowired
private SqlSessionTemplate sqlSessionTemplate;
public List<Time> getTime(){
	TimeMybatisDao timeMybatisDao = sqlSessionTemplate.getMapper(TimeMybatisDao.class);
	return timeMybatisDao.getTime();
}
}
