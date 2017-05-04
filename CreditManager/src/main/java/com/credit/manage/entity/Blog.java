package com.credit.manage.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Blog {

	private Integer id;
	private Short blogType;
	private String blogTitle;
	private String blogContext;
	private Date createTime;
	private String blogSource;
	private String blogAuthor;
	private Short blogStatus;
	private String blogImage;
	private String blogIntroduction;
	private MultipartFile uploadFile;
	
	public Blog() {

	}

	public Blog(Integer id, Short blogType, String blogTitle,
			String blogContext, Date createTime,String blogSource,
			String blogAuthor,String blogImage,String blogIntroduction) {
		super();
		this.id = id;
		this.blogType = blogType;
		this.blogTitle = blogTitle;
		this.blogContext = blogContext;
		this.createTime = createTime;
		this.blogSource = blogSource;
		this.blogAuthor = blogAuthor;
		this.blogImage = blogImage;
		this.blogIntroduction = blogIntroduction;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getBlogType() {
		return blogType;
	}

	public void setBlogType(Short blogType) {
		this.blogType = blogType;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContext() {
		return blogContext;
	}

	public void setBlogContext(String blogContext) {
		this.blogContext = blogContext;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBlogSource() {
		return blogSource;
	}

	public void setBlogSource(String blogSource) {
		this.blogSource = blogSource;
	}

	public String getBlogAuthor() {
		return blogAuthor;
	}

	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	public Short getBlogStatus() {
		return blogStatus;
	}

	public void setBlogStatus(Short blogStatus) {
		this.blogStatus = blogStatus;
	}

	public String getBlogImage() {
		return blogImage;
	}

	public void setBlogImage(String blogImage) {
		this.blogImage = blogImage;
	}

	public String getBlogIntroduction() {
		return blogIntroduction;
	}

	public void setBlogIntroduction(String blogIntroduction) {
		this.blogIntroduction = blogIntroduction;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	
}
