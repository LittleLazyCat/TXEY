package com.txey.record.dao.mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.txey.record.model.Employee;

@Repository
public class EmployeeMybatisTemplateDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<Employee> getEmployee() {
		EmployeeMybatisDao employeeMybatisDao = sqlSessionTemplate.getMapper(EmployeeMybatisDao.class);

		return employeeMybatisDao.getEmployee();
	}

	public Employee findEmpByuserName(String userName) {
		EmployeeMybatisDao employeeMybatisDao = sqlSessionTemplate.getMapper(EmployeeMybatisDao.class);

		return employeeMybatisDao.findEmpByuserName(userName);
	}
}
