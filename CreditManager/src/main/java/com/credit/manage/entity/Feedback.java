package com.credit.manage.entity;

public class Feedback {

	private Integer id;
	// 反馈者姓名
	private String userName;
	// 反馈者电话
	private String phone;
	// 反馈者邮件
	private String userEmail;
	// 反馈内容
	private String context;

	public Feedback() {

	}

	public Feedback(Integer id, String userName, String phone,
			String userEmail, String context) {
		super();
		this.id = id;
		this.userName = userName;
		this.phone = phone;
		this.userEmail = userEmail;
		this.context = context;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
