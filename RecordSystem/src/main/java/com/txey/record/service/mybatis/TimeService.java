package com.txey.record.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txey.record.dao.mybatis.TimeMybatisTemplateDao;
import com.txey.record.model.Time;

@Transactional
@Service
public class TimeService {
	@Autowired
	private TimeMybatisTemplateDao timeMybatisTemplateDao;

	public List<Time> getTime() {
		return timeMybatisTemplateDao.getTime();
	}

}
