package com.txey.record.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txey.record.dao.mybatis.StateMybatisTemplateDao;
import com.txey.record.model.State;

@Transactional
@Service
public class StateService {
	@Autowired
	private StateMybatisTemplateDao stateMybatisTemplateDao;

	public List<State> getState() {
		return stateMybatisTemplateDao.getState();
	}
}
