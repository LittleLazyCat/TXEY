package com.txey.stock.model;

public class CategoryDetail extends Category {
	public int dlid;// 大类id

	public CategoryDetail(Integer clid, String clmc, String cldw, String cljs, String clpy, float clje, int dlid) {
		super.setClid(clid);
		super.setClmc(clmc);
		super.setCldw(cldw);
		super.setCljs(cljs);
		super.setClpy(clpy);
		super.setClpy(clpy);
		this.dlid= dlid;
	}

	public int getDlid() {
		return dlid;
	}

	public void setDlid(int dlid) {
		this.dlid = dlid;
	}

	@Override
	public String toString() {
		return "Category [clid=" + this.getClid() + ", dlid=" + this.getDlid() + ", clmc=" + this.getClmc() + ", cldw=" + this.getCldw() + ", cljs=" + this.getCljs()
				+ ", clpy=" + this.getClpy() + ", clje=" + this.getClje() +"dlid=" + this.getDlid() + "]";
	}

}
