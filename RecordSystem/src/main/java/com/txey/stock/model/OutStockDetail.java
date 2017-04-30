package com.txey.stock.model;

import java.util.Date;

import com.txey.record.model.Dept;
import com.txey.record.model.Employee;

public class OutStockDetail extends OutStock {
	private int clid;// 材料id
	private int ksid;// 科室id
	private int ygid;// 员工id

	public OutStockDetail() {
		super();
	}

	public OutStockDetail(Integer ckid, Date cksj, Integer clid, Integer sfsl, Dept dept, Integer ksid, Integer zfbz,
			Integer ygid) {
		super.setCkid(ckid);
		super.setCksj(cksj);
		super.setSfsl(sfsl);
		super.setZfbz(zfbz);
		this.clid = clid;
		this.ksid = ksid;
		this.ygid = ygid;
	}

	public int getClid() {
		return clid;
	}

	public void setClid(int clid) {
		this.clid = clid;
	}

	public int getKsid() {
		return ksid;
	}

	public void setKsid(int ksid) {
		this.ksid = ksid;
	}

	public int getYgid() {
		return ygid;
	}

	public void setYgid(int ygid) {
		this.ygid = ygid;
	}

	@Override
	public String toString() {
		return "OutStockDetail [clid=" + clid + ", ksid=" + ksid + ", ygid=" + ygid + "]";
	}

}
