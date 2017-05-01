package com.txey.stock.model;

import java.io.Serializable;

/**
 * 
 * 材料实体类
 * 
 * @author Alex Jones
 * 
 * @Time 2017-04-26 22:29:00
 *
 * 
 * 
 */
public class Category implements Serializable {
	private int clid;// 材料id
	private Kind kind;// 材料大类
	private String clmc;// 材料名称
	private String cldw;// 材料单位
	private String cljs;// 材料介绍
	private String clpy;// 材料拼音
	private float clje;// 材料金额

	public Category() {
		super();
	}

	public Category(Integer clid, Kind kind, String clmc, String cldw, String cljs, String clpy, float clje) {
		super();
		this.clid = clid;
		this.kind = kind;
		this.clmc = clmc;
		this.cldw = cldw;
		this.cljs = cljs;
		this.clpy = clpy;
		this.clje = clje;
	}

	public int getClid() {
		return clid;
	}

	public void setClid(int clid) {
		this.clid = clid;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public String getClmc() {
		return clmc;
	}

	public void setClmc(String clmc) {
		this.clmc = clmc;
	}

	public String getCldw() {
		return cldw;
	}

	public void setCldw(String cldw) {
		this.cldw = cldw;
	}

	public String getCljs() {
		return cljs;
	}

	public void setCljs(String cljs) {
		this.cljs = cljs;
	}

	public String getClpy() {
		return clpy;
	}

	public void setClpy(String clpy) {
		this.clpy = clpy;
	}

	public float getClje() {
		return clje;
	}

	public void setClje(float clje) {
		this.clje = clje;
	}

	@Override
	public String toString() {
		return "Category [clid=" + clid + ", kind=" + kind + ", clmc=" + clmc + ", cldw=" + cldw + ", cljs=" + cljs
				+ ", clpy=" + clpy + ", clje=" + clje + "]";
	}

}
