package com.txey.stock.model;

import java.io.Serializable;

/**
 * 
 * 材料大类实体类
 * 
 * @author Alex Jones
 * 
 * @Time 2017-04-26 22:36:00
 *
 * 
 * 
 */
public class Kind implements Serializable{
	private int dlid;// 大类id
	private String dlmc;// 大类名称

	public Kind() {
		super();
	}

	public Kind(Integer dlid, String dlmc) {
		super();
		this.dlid = dlid;
		this.dlmc = dlmc;
	}

	public int getDlid() {
		return dlid;
	}

	public void setDlid(int dlid) {
		this.dlid = dlid;
	}

	public String getDlmc() {
		return dlmc;
	}

	public void setDlmc(String dlmc) {
		this.dlmc = dlmc;
	}

	@Override
	public String toString() {
		return "Kind [dlid=" + dlid + ", dlmc=" + dlmc + "]";
	}

}
