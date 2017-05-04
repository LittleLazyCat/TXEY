package com.credit.manage.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Credit {

	private Integer id;
	// 债权发布人id
	private Integer userId;
	// 债权类型
	private Short crType;
	// 债权金额
	private Double crAmount;
	// 债权状态
	private Short crStatus;
	// 处置方式
	private String disposalType;
	// 佣金范围
	private String commisionRange;
	// 联系人
	private String contactName;
	// 联系电话
	private String contactNumber;
	// 债权方名称
	private String debtName;
	// 债权方省份
	private String debtProvince;
	// 债权方城市
	private String debtCity;
	// 债权方电话
	private String debtPhone;
	// 债权方凭证(上传的文件存放路径)
	private String debtProof;
	// 债权方描述
	private String description;
	// 创建日期
	private Date createDate;
	// 结束日期
	private Date endDate;
	// 开启日期(年份)
	private String openDate;
	// 约定日期
	private Date agreedDate;
	//表单上传的文件
	private MultipartFile[] uploadFiles;
	//债权处置方式单个切分
	private String[] disTypes;
	//债权方凭证单个切分
	private String[] debtProofs;
	// 债权类型（1债权处置，2债权转让）
	private Integer creditType;
	private Integer isAudit;
	
	//债权人性质（1个人，2企业）
	private Integer deptType;
	//处置签约协议地址
	private String signedPath;
	//法律服务协议
	private String legalServicePath;
	//处置团队名称
	private String dealTeamName;
	
	public Credit() {

	}

	public Credit(Integer id, Integer userId, Short crType, Double crAmount,
			Short crStatus, String disposalType, String commisionRange,
			String contactName, String contactNumber, String debtName,
			String debtProvince, String debtCity, String debtPhone,
			String debtProof, String description, Date createDate,
			Date endDate, String openDate, Date agreedDate,MultipartFile[] uploadFiles,
			Integer creditType,Integer isAudit,	Integer deptType,String signedPath,String legalServicePath,String dealTeamName) {
		super();
		this.id = id;
		this.userId = userId;
		this.crType = crType;
		this.crAmount = crAmount;
		this.crStatus = crStatus;
		this.disposalType = disposalType;
		this.commisionRange = commisionRange;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.debtName = debtName;
		this.debtProvince = debtProvince;
		this.debtCity = debtCity;
		this.debtPhone = debtPhone;
		this.debtProof = debtProof;
		this.description = description;
		this.createDate = createDate;
		this.endDate = endDate;
		this.openDate = openDate;
		this.agreedDate = agreedDate;
		this.uploadFiles = uploadFiles;
		this.creditType = creditType;
		this.isAudit =isAudit;
		this.deptType = deptType;
		this.signedPath = signedPath;
		this.legalServicePath = legalServicePath;
		this.dealTeamName = dealTeamName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Short getCrType() {
		return crType;
	}

	public void setCrType(Short crType) {
		this.crType = crType;
	}

	public Double getCrAmount() {
		return crAmount;
	}

	public void setCrAmount(Double crAmount) {
		this.crAmount = crAmount;
	}

	public Short getCrStatus() {
		return crStatus;
	}

	public void setCrStatus(Short crStatus) {
		this.crStatus = crStatus;
	}

	public String getDisposalType() {
		return disposalType;
	}

	public void setDisposalType(String disposalType) {
		this.disposalType = disposalType;
	}

	public String getCommisionRange() {
		return commisionRange;
	}

	public void setCommisionRange(String commisionRange) {
		this.commisionRange = commisionRange;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDebtName() {
		return debtName;
	}

	public void setDebtName(String debtName) {
		this.debtName = debtName;
	}

	public String getDebtProvince() {
		return debtProvince;
	}

	public void setDebtProvince(String debtProvince) {
		this.debtProvince = debtProvince;
	}

	public String getDebtCity() {
		return debtCity;
	}

	public void setDebtCity(String debtCity) {
		this.debtCity = debtCity;
	}

	public String getDebtPhone() {
		return debtPhone;
	}

	public void setDebtPhone(String debtPhone) {
		this.debtPhone = debtPhone;
	}

	public String getDebtProof() {
		return debtProof;
	}

	public void setDebtProof(String debtProof) {
		this.debtProof = debtProof;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public Date getAgreedDate() {
		return agreedDate;
	}

	public void setAgreedDate(Date agreedDate) {
		this.agreedDate = agreedDate;
	}

	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

	public String[] getDisTypes() {
		return disTypes;
	}

	public void setDisTypes(String[] disTypes) {
		this.disTypes = disTypes;
	}

	public Integer getCreditType() {
		return creditType;
	}

	public void setCreditType(Integer creditType) {
		this.creditType = creditType;
	}

	public String[] getDebtProofs() {
		return debtProofs;
	}

	public void setDebtProofs(String[] debtProofs) {
		this.debtProofs = debtProofs;
	}

	public Integer getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(Integer isAudit) {
		this.isAudit = isAudit;
	}

	public Integer getDeptType() {
		return deptType;
	}

	public void setDeptType(Integer deptType) {
		this.deptType = deptType;
	}

	public String getSignedPath() {
		return signedPath;
	}

	public void setSignedPath(String signedPath) {
		this.signedPath = signedPath;
	}

	public String getLegalServicePath() {
		return legalServicePath;
	}

	public void setLegalServicePath(String legalServicePath) {
		this.legalServicePath = legalServicePath;
	}

	public String getDealTeamName() {
		return dealTeamName;
	}

	public void setDealTeamName(String dealTeamName) {
		this.dealTeamName = dealTeamName;
	}
	
	
	
}
