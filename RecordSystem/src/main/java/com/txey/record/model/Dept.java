package com.txey.record.model;

import java.io.Serializable;

/**
 * 
 * 报修科室实体类
 * 
 * @author Alex Jones
 * 
 * @Time 2017-04-17 22:44:01
 *
 * 
 * 
 */
public class Dept  implements Serializable  {
	private int ksid;// 科室ID
	private String ksmc;// 科室名称
	private String ksmcpy;// 科室名称拼音
	private int kslxid;// 科室类型ID
	private String hcbz;// 耗材备注

	public Dept() {
	}

	public Dept(Integer ksid, String ksmc, String ksmcpy, Integer kslxid, String hcbz) {
		super();
		this.ksid = ksid;
		this.ksmc = ksmc;
		this.ksmcpy = ksmcpy;
		this.kslxid = kslxid;
		this.hcbz = hcbz;
	}

	public int getKsid() {
		return ksid;
	}

	public void setKsid(int ksid) {
		this.ksid = ksid;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public String getKsmcpy() {
		return ksmcpy;
	}

	public void setKsmcpy(String ksmcpy) {
		this.ksmcpy = ksmcpy;
	}

	public int getKslxid() {
		return kslxid;
	}

	public void setKslxid(int kslxid) {
		this.kslxid = kslxid;
	}

	public String getHcbz() {
		return hcbz;
	}

	public void setHcbz(String hcbz) {
		this.hcbz = hcbz;
	}

	@Override
	public String toString() {
		return "Dept [ksid=" + ksid + ", ksmc=" + ksmc + ", ksmcpy=" + ksmcpy + ", kslxid=" + kslxid + ", hcbz=" + hcbz
				+ "]";
	}
	
}
