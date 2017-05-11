package com.txey.record.model;

import java.io.Serializable;

//

/**
 * 
 * 完成状态实体类
 * 
 * @author Alex Jones
 * 
 * @Time 2017-04-17 22:44:01
 *
 * 
 * 
 */
public class State  implements Serializable {
	private int ztid;// 状态ID
	private String ztmc;// 状态名称
	private String ztmcpy;// 状态名称拼音

	public State() {
	}

	public State(Integer ztid, String ztmc, String ztmcpy) {
		super();
		this.ztid = ztid;
		this.ztmc = ztmc;
		this.ztmcpy = ztmcpy;
	}

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

	@Override
	public String toString() {
		return "State [ztid=" + ztid + ", ztmc=" + ztmc + ", ztmcpy=" + ztmcpy + "]";
	}

}
