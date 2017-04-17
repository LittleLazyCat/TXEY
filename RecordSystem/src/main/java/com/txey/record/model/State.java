package com.txey.record.model;

//完成状态
public class State {
	private int ztid;	//状态ID
	private String ztmc;	//状态名称
	private String ztmcpy;	//状态名称拼音

	public int getZtid() {
		return ztid;
	}

	public void setZtid(int ztid) {
		this.ztid = ztid;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public String getZtmcpy() {
		return ztmcpy;
	}

	public void setZtmcpy(String ztmcpy) {
		this.ztmcpy = ztmcpy;
	}

}
