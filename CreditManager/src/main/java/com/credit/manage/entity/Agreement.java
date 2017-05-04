package com.credit.manage.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Agreement {

	private Integer id;
	private Integer creditId;
	private Integer userId;
	private Short agreeType;//协议类型(1、居间服务协议(前期),2、服务合同,3、居间服务协议(后期))
	private String agreeImg;//协议内容(图片)
	private String agreeSample;
	private Date signTime;
	private Short signStatus;//签订状态(0、待确认，1、已确认)
	private String[] agreeImgs;//用于单个图片存储
	private MultipartFile[] uploadFiles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCreditId() {
		return creditId;
	}
	public void setCreditId(Integer creditId) {
		this.creditId = creditId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Short getAgreeType() {
		return agreeType;
	}
	public void setAgreeType(Short agreeType) {
		this.agreeType = agreeType;
	}
	public String getAgreeImg() {
		return agreeImg;
	}
	public void setAgreeImg(String agreeImg) {
		this.agreeImg = agreeImg;
	}
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	public Short getSignStatus() {
		return signStatus;
	}
	public void setSignStatus(Short signStatus) {
		this.signStatus = signStatus;
	}
	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public String[] getAgreeImgs() {
		return agreeImgs;
	}
	public void setAgreeImgs(String[] agreeImgs) {
		this.agreeImgs = agreeImgs;
	}
	public String getAgreeSample() {
		return agreeSample;
	}
	public void setAgreeSample(String agreeSample) {
		this.agreeSample = agreeSample;
	}
	

}
