package com.txey.record.model;

//修复时间
public class Time {
	private int sjid;	//时间ID
	private String sjmc;	//时间名称
	private String sjmcpy;	//时间名称拼音

	public int getSjid() {
		return sjid;
	}

	public void setSjid(int sjid) {
		this.sjid = sjid;
	}

	public String getSjmc() {
		return sjmc;
	}

	public void setSjmc(String sjmc) {
		this.sjmc = sjmc;
	}

	public String getSjmcpy() {
		return sjmcpy;
	}

	public void setSjmcpy(String sjmcpy) {
		this.sjmcpy = sjmcpy;
	}

}
