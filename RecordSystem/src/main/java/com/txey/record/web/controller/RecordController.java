package com.txey.record.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.txey.record.model.Contact;
import com.txey.record.model.Dept;
import com.txey.record.model.Employee;
import com.txey.record.model.Kind;
import com.txey.record.model.Method;
import com.txey.record.model.State;
import com.txey.record.model.Time;
import com.txey.record.service.mybatis.ContactService;
import com.txey.record.service.mybatis.DeptService;
import com.txey.record.service.mybatis.EmployeeService;
import com.txey.record.service.mybatis.KindService;
import com.txey.record.service.mybatis.MethodService;
import com.txey.record.service.mybatis.StateService;
import com.txey.record.service.mybatis.TimeService;

@Controller
public class RecordController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private KindService kindService;
	@Autowired
	private MethodService methodService;
	@Autowired
	private StateService stateService; 
	@Autowired
	private TimeService timeService;

	@RequestMapping(value = "index.html")
	public ModelAndView loginPage(HttpServletRequest request) {
		List<Contact> contactList = contactService.getContact();
		request.getSession().setAttribute("contactList", contactList);
		List<Dept> deptList = deptService.getDept();
		request.getSession().setAttribute("deptList", deptList);
		List<Employee> employeeList = employeeService.getEmployee();
		request.getSession().setAttribute("employeeList", employeeList);
		List<Kind> kindList = kindService.getKind();
		request.getSession().setAttribute("kindList", kindList);
		List<Method> methodList = methodService.getMethod();
		request.getSession().setAttribute("methodList", methodList);
		List<State> stateList = stateService.getState();
		request.getSession().setAttribute("stateList", stateList);
		List<Time> timeList = timeService.getTime();
		request.getSession().setAttribute("timeList", timeList);
		return new ModelAndView("jstlTest");
	}
	// @RequestMapping(value = "/addRecord", method = RequestMethod.POST)
	// public ModelAndView loginCheck(HttpServletRequest request){
	// boolean isValidUser =
	// userService.hasMatchUser(loginCommand.getUserName(),
	// loginCommand.getPassword());
	// if (!isValidUser) {
	// return new ModelAndView("login","error","username or password is
	// incorrect.");
	// }else{
	// User user = userService.findUserByUserName(loginCommand.getUserName());
	// user.setLastIp(request.getRemoteAddr());
	// user.setLastVisit(new Date());
	// userService.loginSuccess(user);
	// request.getSession().setAttribute("user", user);
	// return new ModelAndView("main");
	//
	// }

}
