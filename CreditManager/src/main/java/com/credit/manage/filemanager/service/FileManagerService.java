/** 
  * Project Name:credit_web 
  * File Name:FileManager.java 
  * Package Name:com.credit.web.filemanager.service 
  * Date:2016年7月13日下午8:15:32 
  * Copyright (c) 2016, JuanPi.com All Rights Reserved
  */  
  
package com.credit.manage.filemanager.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credit.manage.entity.Feedback;
import com.credit.manage.entity.FileManager;
import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.util.Const;
import com.gvtv.manage.base.util.PageData;

/** 
  * @author huixiong 
  * @date: 2016年7月13日 下午8:15:32 
  * @since:1.0.0
  */
@Transactional(readOnly=true)
@Service("fileManagerService")
public class FileManagerService {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	/**
	 * 查询债权列表信息
	 * @author huixiong 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<FileManager> fileList(PageData pd) throws Exception {
		List<FileManager> fileList = dao.findForList("FileManagerMapper.list", pd);
		return fileList;
	}
	
	public PageData list(PageData pd) throws Exception {
		PageData result = new PageData();
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			pd.put("keyword", "%" + search + "%");
		}
		int totalNum = (int) dao.findForObject("FileManagerMapper.count", pd);

		pd.put("from", pd.getInteger("start"));
		pd.put("size", pd.getInteger("length"));
		List<FileManager> pds = dao.findForList("FileManagerMapper.list", pd);
		

		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.RECORDSTOTAL, totalNum);
		result.put(Const.RECORDSFILTERED, totalNum);
		result.put(Const.NDATA, pds);
		return result;
	}
	
	public FileManager findById(Integer id) throws Exception {
		return (FileManager) dao.findForObject("FileManagerMapper.findById", id);
	}
	
	public int save(FileManager fileManager) throws Exception{
		return dao.save("FileManagerMapper.save", fileManager);
	}
	
	public int update(FileManager fileManager) throws Exception{
		return dao.update("FileManagerMapper.update", fileManager);
	}
	
	public int delete(Integer id) throws Exception{
		return dao.delete("FileManagerMapper.delete", id);
	}
	
	
}
  