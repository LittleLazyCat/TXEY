package com.txey.record.dao.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.txey.record.model.Method;

@Repository
public class MethodMybatisTemplateDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<Method> getMethod() {
		MethodMybatisDao methodMybatisDao = sqlSessionTemplate.getMapper(MethodMybatisDao.class);
		return methodMybatisDao.getMethod();
	}

}
