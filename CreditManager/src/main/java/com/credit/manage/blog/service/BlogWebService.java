/** 
  * Project Name:credit_web 
  * File Name:BlogService.java 
  * Package Name:com.credit.web.blog.service 
  * Date:2016年7月13日下午7:56:02 
  * Copyright (c) 2016, JuanPi.com All Rights Reserved
  */  
  
package com.credit.manage.blog.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credit.manage.entity.Blog;
import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.util.Const;
import com.gvtv.manage.base.util.PageData;

/** 
  * @author huixiong 
  * @date: 2016年7月13日 下午7:56:02 
  * @since:1.0.0
  */
@Transactional(readOnly=true)
@Service("blogWebService")
public class BlogWebService {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	/**
	 * 业务资讯分页信息
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
		int totalNum = (int) dao.findForObject("BlogMapper.count", pd);
		List<Blog> pds = dao.findForList("BlogMapper.list", pd);
		
		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.RECORDSTOTAL, totalNum);
		result.put(Const.RECORDSFILTERED, totalNum);
		result.put(Const.NDATA, pds);
		return result;
	}
	
	/**
	 * 业务资讯列表信息
	 * @author huixiong 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<Blog> bloglist(PageData pd) throws Exception {
		List<Blog> blogList = dao.findForList("BlogMapper.list", pd);
		return blogList;
	}
	
	/**
	 * 保存业务文章
	 * @author huixiong 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public Boolean saveUser(Blog blog) throws Exception{
		int num = dao.save("BlogMapper.saveBlogInfo", blog);
		if (num > 0) {
			return true;
		}
		return false;
	}
		
	public Blog findById(Integer id)throws Exception {
		Blog blog = dao.findForObject("BlogMapper.findById", id);
		return blog;
	}
	
	public Boolean updateBlog(Blog blog)throws Exception {
		int num = dao.update("BlogMapper.updateBlog", blog);
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	public Boolean updateBlogStatus(Blog blog)throws Exception {
		int num = dao.update("BlogMapper.updateBlogStatus", blog);
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	public Integer deleteById(Integer id) throws Exception {
		return (Integer)dao.delete("BlogMapper.deleteById", id);
	}
	
}
  