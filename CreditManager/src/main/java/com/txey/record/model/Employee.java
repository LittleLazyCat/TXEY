package com.txey.record.model;
//员工

import java.io.Serializable;

/**
 * 
 * 员工信息实体类
 * 
 * @author Alex Jones
 * 
 * @Time 2017-04-17 22:44:01
 *
 * 
 * 
 */
public class Employee  implements Serializable {
	private int ygid;// 员工ID
	private String ygxm;// 员工姓名
	private String xmpy;// 姓名拼音
	private int ksid;// 科室ID
	private String userName;// 用户名
	private String password;// 密码

	public Employee() {
	}

	public Employee(Integer ygid, String ygxm, String xmpy, Integer ksid, String userName, String password) {
		super();
		this.ygid = ygid;
		this.ygxm = ygxm;
		this.xmpy = xmpy;
		this.ksid = ksid;
		this.userName = userName;
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "Employee [ygid=" + ygid + ", ygxm=" + ygxm + ", xmpy=" + xmpy + ", ksid=" + ksid + ", userName="
				+ userName + ", password=" + password + "]";
	}
	
}
