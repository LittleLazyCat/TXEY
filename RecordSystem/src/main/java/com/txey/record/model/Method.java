package com.txey.record.model;


/**

* 维修方式实体类

* @author Alex Jones

* @Time 2017-04-17 22:44:01

*

*/
public class Method {
	private int fsid;//方式ID
	private String fsmc;//方式名称
	private String fsmcpy;//方式名称拼音

	public int getFsid() {
		return fsid;
	}

	public void setFsid(int fsid) {
		this.fsid = fsid;
	}

	public String getFsmc() {
		return fsmc;
	}

	public void setFsmc(String fsmc) {
		this.fsmc = fsmc;
	}

	public String getFsmcpy() {
		return fsmcpy;
	}

	public void setFsmcpy(String fsmcpy) {
		this.fsmcpy = fsmcpy;
	}

}
