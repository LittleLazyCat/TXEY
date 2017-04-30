package com.txey.record.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.txey.record.model.Contact;
import com.txey.record.model.Dept;
import com.txey.record.model.Employee;
import com.txey.record.model.Kind;
import com.txey.record.model.Method;
import com.txey.record.model.Record;
import com.txey.record.model.State;
import com.txey.record.model.Time;
import com.txey.record.service.mybatis.ContactService;
import com.txey.record.service.mybatis.DeptService;
import com.txey.record.service.mybatis.EmployeeService;
import com.txey.record.service.mybatis.KindService;
import com.txey.record.service.mybatis.MethodService;
import com.txey.record.service.mybatis.RecordService;
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
	@Autowired
	private RecordService recordService;

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

		return new ModelAndView("edit");
	}

	@RequestMapping(value = "addRecord.html", method = RequestMethod.POST)
	public ModelAndView addRecord(HttpServletRequest request) throws SQLException, IOException, ServletException {
		Record record = new Record();
		// 临时变量
		String temp; 
		// 获得下拉菜单中的Value的值
		temp = request.getParameter("dept");
		// String转成int
		int ksid = Integer.parseInt(temp);
		Dept dept = new Dept();
		dept.setKsid(ksid);

		temp = request.getParameter("kind");
		int lxid = Integer.parseInt(temp);
		Kind kind = new Kind();
		kind.setLxid(lxid);

		Contact contact = new Contact();
		temp = request.getParameter("contact");
		int lyid = Integer.parseInt(temp);
		contact.setLyid(lyid);

		Method method = new Method();
		temp = request.getParameter("method");
		int fsid = Integer.parseInt(temp);
		method.setFsid(fsid);

		Time time = new Time();
		temp = request.getParameter("time");
		int sjid = Integer.parseInt(temp);
		time.setSjid(sjid);

		Employee employee = new Employee();
		temp = request.getParameter("employee");
		int ygid = Integer.parseInt(temp);
		employee.setYgid(ygid);

		State state = new State();
		state.setZtid(1);

		record = new Record(new Date(), dept, kind, contact, request.getParameter("wtms"), method, time, 100.0f,
				employee, state, 1, request.getParameter("wxbz"));

		recordService.addRecord(record);

		return loginPage(request);

	}

}
