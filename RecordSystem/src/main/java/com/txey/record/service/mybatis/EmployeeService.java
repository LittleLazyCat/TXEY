package com.txey.record.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txey.record.dao.mybatis.EmployeeMybatisTemplateDao;
import com.txey.record.model.Employee;

@Transactional
@Service
public class EmployeeService {
	@Autowired
	private EmployeeMybatisTemplateDao employeeMybatisTemplateDao;

	public List<Employee> getEmployee() {
		return employeeMybatisTemplateDao.getEmployee();
	}

	public Employee findEmpByuserName(String userName) {
		return employeeMybatisTemplateDao.findEmpByuserName(userName);
	}
}
