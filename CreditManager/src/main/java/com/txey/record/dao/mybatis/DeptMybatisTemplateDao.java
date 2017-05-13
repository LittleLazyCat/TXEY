package com.txey.record.dao.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.txey.record.model.Dept;

@Repository
public class DeptMybatisTemplateDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<Dept> getDept() {
		DeptMybatisDao deptMybatisDao = sqlSessionTemplate.getMapper(DeptMybatisDao.class);
		return deptMybatisDao.getDept();
	}

}
