package com.txey.record.dao.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.txey.record.model.State;

@Repository
public class StateMybatisTemplateDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<State> getState() {
		StateMybatisDao stateMybatisDao = sqlSessionTemplate.getMapper(StateMybatisDao.class);
		return stateMybatisDao.getState();
	}
}
