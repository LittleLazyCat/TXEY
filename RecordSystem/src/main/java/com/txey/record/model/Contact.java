package com.txey.record.model;

//问题来源
public class Contact {
	private int lyid;	//来源ID
	private String lymc;	//来源名称
	private String lymcpy;	//来源名称拼音

	public int getLyid() {
		return lyid;
	}

	public void setLyid(int lyid) {
		this.lyid = lyid;
	}

	public String getLymc() {
		return lymc;
	}

	public void setLymc(String lymc) {
		this.lymc = lymc;
	}

	public String getLymcpy() {
		return lymcpy;
	}

	public void setLymcpy(String lymcpy) {
		this.lymcpy = lymcpy;
	}
}
