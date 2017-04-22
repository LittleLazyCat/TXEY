package com.txey.record.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**

* 记录表实体类

* @author Alex Jones

* @Time 2017-04-17 22:44:01

*

*/

public class Record  implements Serializable {
	private int jlid;//记录ID
	private Date jlsj;//记录时间
	private Dept dept;//报修科室
	private Kind kind;//问题类型
	private Contact contact;//问题来源
	private String wtms;//问题描述
	private Method method;//维修方式
	private Time time;//修复时间
	private float wxfy;//维修费用
	private Employee employee;//维修人员
	private State state;//解决状态
	private int qrbz;//确认状态（0为未解决，1为解决）
	private String wxbz;//维修备注
	 private List<Record> records;//用于统计查询
	public List<Record> getRecords() {
		return records;
	}
	public void setRecords(List<Record> records) {
		this.records = records;
	}
	public void setQrbz(int qrbz) {
		this.qrbz = qrbz;
	}
	public Record(){}
	public Record( Date jlsj, Dept dept, Kind kind, Contact contact, String wtms, Method method, Time time,
			float wxfy, Employee employee, State state, int qrbz, String wxbz) {
		super();
		
		this.jlsj = jlsj;
		this.dept = dept;
		this.kind = kind;
		this.contact = contact;
		this.wtms = wtms;
		this.method = method;
		this.time = time;
		this.wxfy = wxfy;
		this.employee = employee;
		this.state = state;
		this.qrbz = qrbz;
		this.wxbz = wxbz;
	}
	public int getJlid() {
		return jlid;
	}
	public void setJlid(int jlid) {
		this.jlid = jlid;
	}
	public Date getJlsj() {
		return jlsj;
	}
	public void setJlsj(Date jlsj) {
		this.jlsj = jlsj;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String getWtms() {
		return wtms;
	}
	public void setWtms(String wtms) {
		this.wtms = wtms;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public float getWxfy() {
		return wxfy;
	}
	public void setWxfy(float wxfy) {
		this.wxfy = wxfy;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getQrbz() {
		return qrbz;
	}
	public void setQrzt(int qrbz) {
		this.qrbz = qrbz;
	}
	public String getWxbz() {
		return wxbz;
	}
	public void setWxbz(String wxbz) {
		this.wxbz = wxbz;
	}

}
