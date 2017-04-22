package com.txey.record.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.txey.record.dao.mybatis.ContactMybatisTemplateDao;
import com.txey.record.dao.mybatis.DeptMybatisTemplateDao;
import com.txey.record.dao.mybatis.EmployeeMybatisTemplateDao;
import com.txey.record.dao.mybatis.KindMybatisTemplateDao;
import com.txey.record.dao.mybatis.MethodMybatisTemplateDao;
import com.txey.record.dao.mybatis.RecordMybatisTemplateDao;
import com.txey.record.dao.mybatis.StateMybatisTemplateDao;
import com.txey.record.dao.mybatis.TimeMybatisTemplateDao;
import com.txey.record.model.Contact;
import com.txey.record.model.Dept;
import com.txey.record.model.Employee;
import com.txey.record.model.Kind;
import com.txey.record.model.Method;
import com.txey.record.model.Record;
import com.txey.record.model.RecordDetail;
import com.txey.record.model.State;
import com.txey.record.model.Time;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class TestRecordService {

	@Autowired
	private RecordMybatisTemplateDao recordService;
	@Autowired
	private ContactMybatisTemplateDao contactService;
	@Autowired
	private DeptMybatisTemplateDao deptService;
	@Autowired
	private EmployeeMybatisTemplateDao employeeService;
	@Autowired
	private KindMybatisTemplateDao kindService;
	@Autowired
	private MethodMybatisTemplateDao methodService;
	@Autowired
	private StateMybatisTemplateDao stateService;
	@Autowired
	private TimeMybatisTemplateDao timeService;

	private Contact contact;

	private Dept dept;

	private Employee employee;

	private Kind kind;

	private Method method;

	private State state;

	private Time time;

	@Test
	public void addRecord() {
		Record record = new Record();
		record.setJlsj(new Date());
		dept = new Dept();
		dept.setKsid(2); 
		kind = new Kind();
		kind.setLxid(1);
		contact = new Contact();
		contact.setLyid(1);
		method = new Method();
		method.setFsid(1);
		time = new Time();
		time.setSjid(1);
		employee = new Employee();
		employee.setYgid(5);
		state = new State();
		state.setZtid(1);
		record = new Record(new Date(), dept, kind, contact, "正文测试", method, time, 100.0f, employee, state, 1, "棒棒哒！");
		recordService.addRecord(record);
	}

	@Test
	public void getRecordDetail() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("year", 2017);
		map.put("month", 4);
		List<RecordDetail> list = recordService.getRecordDetail(map);
		for (RecordDetail rd : list) {

			System.out.println(rd);
		}
	}

	@Test
	public void getContact() {
		List<Contact> contactList = contactService.getContact();
		for (Contact cl : contactList) {

			System.out.println(cl);
		}
	}

	@Test
	public void getDept() {
		List<Dept> deptList = deptService.getDept();
		for (Dept dl : deptList) {

			System.out.println(dl);
		}
	}

	@Test
	public void getEmployee() {
		List<Employee> employeeList = employeeService.getEmployee();
		for (Employee el : employeeList) {

			System.out.println(el);
		}
	}

	@Test
	public void findEmpByuserName() {
		employee = employeeService.findEmpByuserName("admin");

		System.out.println(employee);

	}

	@Test
	public void getKind() {
		List<Kind> kindList = kindService.getKind();
		for (Kind kl : kindList) {

			System.out.println(kl);
		}
	}

	@Test
	public void getMethod() {
		List<Method> methodList = methodService.getMethod();
		for (Method ml : methodList) {

			System.out.println(ml);
		}
	}

	@Test
	public void getState() {
		List<State> stateList = stateService.getState();
		for (State sl : stateList) {
			System.out.println(sl);
		}
	}

	@Test
	public void getTime() {
		List<Time> timeList = timeService.getTime();
		for (Time tl : timeList) {
			System.out.println(tl);
		}
	}
}
