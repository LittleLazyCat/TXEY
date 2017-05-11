package com.txey.record.model;

import java.io.Serializable;

/**
 * 
 * 问题类型实体类
 * 
 * @author Alex Jones
 * 
 * @Time 2017-04-17 22:44:01
 *
 * 
 * 
 */
public class Kind  implements Serializable {
	private int lxid;// 类型ID
	private String lxmc;// 类型名称
	private String lxmcpy;// 类型名称拼音

	public Kind() {
	}

	public Kind(Integer lxid, String lxmc, String lxmcpy) {
		super();
		this.lxid = lxid;
		this.lxmc = lxmc;
		this.lxmcpy = lxmcpy;
	}

	public int getLxid() {
		return lxid;
	}

	public void setLxid(int lxid) {
		this.lxid = lxid;
	}

	public String getLxmc() {
		return lxmc;
	}

	public void setLxmc(String lxmc) {
		this.lxmc = lxmc;
	}

	public String getLxmcpy() {
		return lxmcpy;
	}

	public void setLxmcpy(String lxmcpy) {
		this.lxmcpy = lxmcpy;
	}

	@Override
	public String toString() {
		return "Kind [lxid=" + lxid + ", lxmc=" + lxmc + ", lxmcpy=" + lxmcpy + "]";
	}
	
}
