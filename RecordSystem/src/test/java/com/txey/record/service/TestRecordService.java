package com.txey.record.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.txey.record.dao.mybatis.RecordMybatisTemplateDao;
import com.txey.record.model.Contact;
import com.txey.record.model.Dept;
import com.txey.record.model.Employee;
import com.txey.record.model.Kind;
import com.txey.record.model.Method;
import com.txey.record.model.Record;
import com.txey.record.model.State;
import com.txey.record.model.Time;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class TestRecordService {
 
	@Autowired
	private RecordMybatisTemplateDao recordService;
	
	private Contact contact;
	
	private Dept dept;
	
	private Employee employee;
	
	private Kind kind;
	
	private Method method;
	
	private State state;
	
	private Time time;
	@Test
	public void addRecord(){
		Record record = new Record();
		record.setJlsj(new Date());
		dept =new Dept();
		dept.setKsid(2);
//		record.setDept(dept);
		kind = new Kind();
		kind.setLxid(1);
//		record.setKind(kind);
		contact = new Contact();
		contact.setLyid(1);
//		record.setContact(contact);
//		record.setWtms("测试");
		method = new Method();
		method.setFsid(1);
//		record.setMethod(method);
		time = new Time();
		time.setSjid(1);
//		record.setTime(time);
//		record.setWxfy(100.0f);
		employee = new Employee();
		employee.setYgid(5);
//		record.setEmployee(employee);
		state = new State();
		state.setZtid(1);
//		record.setState(state);
//		record.setQrzt(1);
//		record.setWxbz("棒棒哒");
		record = new Record(new Date(),dept,kind,contact,"正文测试",method,time,100.0f,employee,state,1,"棒棒哒！");
		recordService.addRecord(record);
	}
}
