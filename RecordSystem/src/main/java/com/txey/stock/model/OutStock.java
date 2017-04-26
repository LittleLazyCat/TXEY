package com.txey.stock.model;

import java.io.Serializable;
import java.util.Date;

import com.txey.record.model.Dept;
import com.txey.record.model.Employee;

/**
 * 
 * 出库实体类
 * 
 * @author Alex Jones
 * 
 * @Time 2017-04-26 22:53:00
 *
 * 
 * 
 */
public class OutStock implements Serializable {
	private int ckid;// 出库id
	private Date cksj;// 出库时间
	private Category category;// 出库材料
	private int sfsl;// 实发数量
	private Dept dept;// 部门
	private Employee emp;// 员工
	private int zfbz;// 作废标志（1未作废，0为未作废)

	public OutStock() {
		super();
	}

	public OutStock(Integer ckid, Date cksj, Category category, Integer sfsl, Dept dept, Employee emp, Integer zfbz) {
		super();
		this.ckid = ckid;
		this.cksj = cksj;
		this.category = category;
		this.sfsl = sfsl;
		this.dept = dept;
		this.emp = emp;
		this.zfbz = zfbz;
	}

	public int getCkid() {
		return ckid;
	}

	public void setCkid(int ckid) {
		this.ckid = ckid;
	}

	public Date getCksj() {
		return cksj;
	}

	public void setCksj(Date cksj) {
		this.cksj = cksj;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getSfsl() {
		return sfsl;
	}

	public void setSfsl(int sfsl) {
		this.sfsl = sfsl;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public int getZfbz() {
		return zfbz;
	}

	public void setZfbz(int zfbz) {
		this.zfbz = zfbz;
	}

}
