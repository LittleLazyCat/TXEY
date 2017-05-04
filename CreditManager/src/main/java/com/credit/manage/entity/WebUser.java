package com.credit.manage.entity;

import org.springframework.web.multipart.MultipartFile;

public class WebUser {

	private Integer id;
	private String userEmail;
	private String userPhone;
	private Short userType;
	private String nickname;
	private String userPwd;
	private Short userLevel;
	private String userRole;
	private String userHeadImages;
	private String description;
	private Short userStatus;
	private MultipartFile uploadFile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Short getUserType() {
		return userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Short getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Short userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserHeadImages() {
		return userHeadImages;
	}

	public void setUserHeadImages(String userHeadImages) {
		this.userHeadImages = userHeadImages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Short userStatus) {
		this.userStatus = userStatus;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

}
