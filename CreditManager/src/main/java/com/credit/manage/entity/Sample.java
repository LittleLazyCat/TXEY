package com.credit.manage.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * 案例及用户心声
 * @author z
 *
 */
public class Sample {
	
	private Integer id;
	private String samName;
	private String trade;//行业
	private Double amount;
	private Short samType;//类型(1案例、2用户心声)
	private String description;
	private String samImg;
	private Short status;//状态(1发布、0未发布)
	private MultipartFile headImgFile;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSamName() {
		return samName;
	}
	public void setSamName(String samName) {
		this.samName = samName;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Short getSamType() {
		return samType;
	}
	public void setSamType(Short samType) {
		this.samType = samType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSamImg() {
		return samImg;
	}
	public void setSamImg(String samImg) {
		this.samImg = samImg;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public MultipartFile getHeadImgFile() {
		return headImgFile;
	}
	public void setHeadImgFile(MultipartFile headImgFile) {
		this.headImgFile = headImgFile;
	}
	
	
}
