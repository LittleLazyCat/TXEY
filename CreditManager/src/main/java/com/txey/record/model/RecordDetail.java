package com.txey.record.model;

import java.util.Date;

public class RecordDetail extends Record {
	private String ksmc;
	private String lxmc;
	private String lymc;
	private String fsmc;
	private String sjmc;
	private String ygxm;
	private String ztmc;

	public RecordDetail() {
	}

	public RecordDetail(Integer jlid, Date jlsj, String ksmc, String lxmc, String lymc, String wtms, String fsmc,
			String sjmc, Float wxfy, String ygxm, String ztmc, String wxbz) {

		super.setJlid(jlid);
		super.setJlsj(jlsj);
		this.ksmc = ksmc;
		this.lxmc = lxmc;
		this.lymc = lymc;
		super.setWtms(wtms);
		this.fsmc = fsmc;
		this.sjmc = sjmc;
		super.setWxfy(wxfy);
		this.ygxm = ygxm;
		this.ztmc = ztmc;
		super.setWxbz(wxbz);
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public String getLxmc() {
		return lxmc;
	}

	public void setLxmc(String lxmc) {
		this.lxmc = lxmc;
	}

	public String getLymc() {
		return lymc;
	}

	public void setLymc(String lymc) {
		this.lymc = lymc;
	}

	public String getFsmc() {
		return fsmc;
	}

	public void setFsmc(String fsmc) {
		this.fsmc = fsmc;
	}

	public String getSjmc() {
		return sjmc;
	}

	public void setSjmc(String sjmc) {
		this.sjmc = sjmc;
	}

	public String getYgxm() {
		return ygxm;
	}

	public void setYgmc(String ygxm) {
		this.ygxm = ygxm;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	@Override
	public String toString() {
		return "RecordDetail [ksmc=" + ksmc + ", lxmc=" + lxmc + ", lymc=" + lymc + ", fsmc=" + fsmc + ", sjmc=" + sjmc
				+ ", ygxm=" + ygxm + ", ztmc=" + ztmc + "]";
	}
}
