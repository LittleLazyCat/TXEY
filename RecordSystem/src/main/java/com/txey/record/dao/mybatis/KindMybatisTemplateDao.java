package com.txey.record.dao.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.txey.record.model.Kind;

@Repository
public class KindMybatisTemplateDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<Kind> getKind() {
		KindMybatisDao kindMybatisDao = sqlSessionTemplate.getMapper(KindMybatisDao.class);
		return kindMybatisDao.getKind();
	}
}
