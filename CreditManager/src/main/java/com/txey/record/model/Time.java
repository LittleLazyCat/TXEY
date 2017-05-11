package com.txey.record.model;

import java.io.Serializable;

/**
 * 
 * 修复时间实体类
 * 
 * @author Alex Jones
 * 
 * @Time 2017-04-17 22:44:01
 *
 * 
 * 
 */
public class Time  implements Serializable {
	private int sjid;// 时间ID
	private String sjmc;// 时间名称
	private String sjmcpy;// 时间名称拼音

	public Time() {
	}

	public Time(Integer sjid, String sjmc, String sjmcpy) {
		super();
		this.sjid = sjid;
		this.sjmc = sjmc;
		this.sjmcpy = sjmcpy;
	}

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

	@Override
	public String toString() {
		return "Time [sjid=" + sjid + ", sjmc=" + sjmc + ", sjmcpy=" + sjmcpy + "]";
	}

}
