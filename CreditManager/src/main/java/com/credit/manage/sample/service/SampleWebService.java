/** 
  * Project Name:credit_web 
  * File Name:BlogService.java 
  * Package Name:com.credit.web.blog.service 
  * Date:2016年7月13日下午7:56:02 
  * Copyright (c) 2016, JuanPi.com All Rights Reserved
  */  
  
package com.credit.manage.sample.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credit.manage.entity.Sample;
import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.util.Const;
import com.gvtv.manage.base.util.PageData;

/** 
  * @author z 
  * @date: 
  * @since:1.0.0
  */
@Transactional(readOnly=true)
@Service("sampleWebService")
public class SampleWebService {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	/**
	 * 分页信息
	 * @author huixiong 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData pageList(PageData pd) throws Exception{
		PageData result = new PageData();

		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			pd.put("keyword", "%" + search + "%");
		}
		pd.put("from", pd.getInteger("start"));
		pd.put("size", pd.getInteger("length"));
		int totalNum = (int) dao.findForObject("SampleMapper.count", pd);
		List<Sample> pds = dao.findForList("SampleMapper.list", pd);
		
		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.RECORDSTOTAL, totalNum);
		result.put(Const.RECORDSFILTERED, totalNum);
		result.put(Const.NDATA, pds);
		return result;
	}
	
	/**
	 * 保存
	 * @author z 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public Boolean saveUser(Sample sample) throws Exception{
		int num = dao.save("SampleMapper.saveSampleInfo", sample);
		if (num > 0) {
			return true;
		}
		return false;
	}
		
	public Sample findById(Integer id)throws Exception {
		Sample sample = dao.findForObject("SampleMapper.findById", id);
		return sample;
	}
	
	public Boolean updateSample(Sample sample)throws Exception {
		int num = dao.update("SampleMapper.updateSample", sample);
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	public Boolean updateBlogStatus(Sample sample)throws Exception {
		int num = dao.update("SampleMapper.updateSampleStatus", sample);
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	public Integer deleteById(Integer id) throws Exception {
		return (Integer)dao.delete("SampleMapper.deleteById", id);
	}
	
}
  