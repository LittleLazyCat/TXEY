package com.credit.manage.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Reward {
	// 序号
	private Integer id;
	// 悬赏类型
	private Short rewardType;
	// 悬赏金额a
	private String rewardAmount;
	// 悬赏人
	private String rewardName;
	// 身份证
	private String cartId;
	// 车牌
	private String carBrand;
	// 省份
	private String province;
	// 城市
	private String city;
	// 照片
	private String images;
	// 创建日期
	private Date createTime;
	// 悬赏有效日期
	private Date endTime;
	// 悬赏描述
	private String description;
	// 悬赏状态
	private Short rewardStatus;
	// 登录用户编号
	private Integer userId;
	
	//表单上传的文件
	private MultipartFile[] uploadFiles;
	// 照片(单个切分数组)
	private String[] imagesArry;
	
	public Reward() {

	}

	public Reward(Integer id, Short rewardType, String rewardAmount,
			String rewardName, String cartId, String carBrand, String province,
			String city, String images, Date createTime, Date endTime,
			String description, Short rewardStatus, Integer userId,MultipartFile[] uploadFiles) {
		super();
		this.id = id;
		this.rewardType = rewardType;
		this.rewardAmount = rewardAmount;
		this.rewardName = rewardName;
		this.cartId = cartId;
		this.carBrand = carBrand;
		this.province = province;
		this.city = city;
		this.images = images;
		this.createTime = createTime;
		this.endTime = endTime;
		this.description = description;
		this.rewardStatus = rewardStatus;
		this.userId = userId;
		this.uploadFiles = uploadFiles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getRewardType() {
		return rewardType;
	}

	public void setRewardType(Short rewardType) {
		this.rewardType = rewardType;
	}

	public String getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(String rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public String getRewardName() {
		return rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getRewardStatus() {
		return rewardStatus;
	}

	public void setRewardStatus(Short rewardStatus) {
		this.rewardStatus = rewardStatus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

	public String[] getImagesArry() {
		return imagesArry;
	}

	public void setImagesArry(String[] imagesArry) {
		this.imagesArry = imagesArry;
	}

 
}
