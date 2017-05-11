package com.txey.record.model;

import java.io.Serializable;

/**
 * 
 * 问题来源实体类
 * 
 * @author Alex Jones
 * 
 * @Time 2017-04-17 22:44:01
 *
 * 
 * 
 */
public class Contact implements Serializable {
	private int lyid;// 来源ID
	private String lymc;// 来源名称
	private String lymcpy;// 来源名称拼音

	public Contact() {
	}

	public Contact(Integer lyid, String lymc, String lymcpy) {
		super();
		this.lyid = lyid;
		this.lymc = lymc;
		this.lymcpy = lymcpy;
	}


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
	
	@Override
	public String toString() {
		return "Contact [lyid=" + lyid + ", lymc=" + lymc + ", lymcpy=" + lymcpy + "]";
	}
}
