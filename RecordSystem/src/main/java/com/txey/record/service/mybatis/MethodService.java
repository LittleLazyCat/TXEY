package com.txey.record.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txey.record.dao.mybatis.MethodMybatisTemplateDao;
import com.txey.record.model.Method;

@Transactional
@Service
public class MethodService {
	@Autowired
	private MethodMybatisTemplateDao methodMybatisTemplateDao;

	public List<Method> getMethod() {
		return methodMybatisTemplateDao.getMethod();
	}
}
