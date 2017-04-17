package com.txey.record.model;
//员工
public class Employee {
	private int ygid;	//员工ID
	private String ygxm;	//员工姓名
	private String xmpy;	//姓名拼音
	private int ksid;	//科室ID
	private String userName;	//用户名
	private String password;	//密码
	public int getYgid() {
		return ygid;
	}
	public void setYgid(int ygid) {
		this.ygid = ygid;
	}
	public String getYgxm() {
		return ygxm;
	}
	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}
	public String getXmpy() {
		return xmpy;
	}
	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}
	public int getKsid() {
		return ksid;
	}
	public void setKsid(int ksid) {
		this.ksid = ksid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
