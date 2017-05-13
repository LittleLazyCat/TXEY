package com.txey.record.dao.mybatis;

import java.util.List;

import com.txey.record.model.Employee;

public interface EmployeeMybatisDao {
	/**
	 * 
	 * 获得员工信息
	 * 
	 * @param 
	 *           
	 * 
	 * @return List<Employee> 返回维修人员信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-19 13:30:00
	 * 
	 * 
	 */
	public List<Employee> getEmployee();
	/**
	 * 
	 * 根据用户名查询是否存在该用户
	 * 
	 * @param userName
	 *           用户名
	 * 
	 * @return Employee 返回员工信息
	 * @exception
	 * 
	 * 				@author
	 *                Alex Jones
	 * 
	 * @Time 2017-04-20 12:27:00
	 * 
	 * 
	 */
	public Employee findEmpByuserName(String userName);
}
