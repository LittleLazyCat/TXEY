/** 
  * Project Name:credit_web 
  * File Name:BlogService.java 
  * Package Name:com.credit.web.blog.service 
  * Date:2016年7月13日下午7:56:02 
  * Copyright (c) 2016, JuanPi.com All Rights Reserved
  */  
  
package com.credit.manage.agreement.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credit.manage.entity.Agreement;
import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.util.PageData;

@Transactional(readOnly=true)
@Service("agreementWebService")
public class AgreementWebService {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	public List<Agreement> list(PageData pd) throws Exception {
		List<Agreement> agreeList = dao.findForList("AgreementMapper.list", pd);
		return agreeList;
	}
	
	public Boolean saveAgree(Agreement agree) throws Exception{
		int num = dao.save("AgreementMapper.saveAgreeInfo", agree);
		if (num > 0) {
			return true;
		}
		return false;
	}
		
	public Agreement findById(Integer id)throws Exception {
		Agreement agree = dao.findForObject("AgreementMapper.findById", id);
		return agree;
	}
	
	public Boolean updateAgreeStatus(Agreement agree)throws Exception {
		int num = dao.update("AgreementMapper.updateAgreeStatus", agree);
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	public Integer deleteById(Integer id) throws Exception {
		return (Integer)dao.delete("AgreementMapper.deleteById", id);
	}
	
	public Integer deleteByCreditId(Agreement agree) throws Exception {
		return (Integer)dao.delete("AgreementMapper.deleteByCreditId", agree);
	}
}
  