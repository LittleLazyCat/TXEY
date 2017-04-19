package com.txey.record.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txey.record.dao.mybatis.DeptMybatisDao;
import com.txey.record.dao.mybatis.DeptMybatisTemplateDao;
import com.txey.record.model.Dept;

@Transactional
@Service
public class DeptService {
	@Autowired
	private DeptMybatisTemplateDao deptMybatisTemplateDao;
	
	public List<Dept> getDept() {
		return deptMybatisTemplateDao.getDept();
	}
}
