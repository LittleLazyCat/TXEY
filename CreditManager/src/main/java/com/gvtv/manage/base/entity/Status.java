package com.gvtv.manage.base.entity;

public enum Status {
	DELETED(-1, "删除"), STOPPED(0, "停止"), NORMAL(1, "正常");

	private int code;
	private String desc;

	public static Status getStatus(int code) {
		for (Status status : Status.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		return null;
	}

	Status(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return getDesc();
	}
}