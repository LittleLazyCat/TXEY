/** 
  * Project Name:credit_web 
  * File Name:RewardService.java 
  * Package Name:com.credit.web.reward.service 
  * Date:2016年7月13日下午6:06:27 
  * Copyright (c) 2016, JuanPi.com All Rights Reserved
  */  
  
package com.credit.manage.reward.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credit.manage.entity.Reward;
import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.util.Const;
import com.gvtv.manage.base.util.PageData;

/** 
  * @department:架构服务部/JAVA工程师
  * @author huixiong 
  * @date: 2016年7月13日 下午6:06:27 
  * @since:1.0.0
  */
@Transactional(readOnly=true)
@Service("rewardWebService")
public class RewardWebService {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	/**
	 * 查询债权分页信息
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
		int totalNum = (int) dao.findForObject("RewardMapper.count", pd);
		List<Reward> pds = dao.findForList("RewardMapper.list", pd);
		
		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.RECORDSTOTAL, totalNum);
		result.put(Const.RECORDSFILTERED, totalNum);
		result.put(Const.NDATA, pds);
		return result;
	}
	
	/**
	 * 查询债权列表信息
	 * @author huixiong 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<Reward> rewardlist(PageData pd) throws Exception {
		List<Reward> rewardList = dao.findForList("RewardMapper.list", pd);
		return rewardList;
	}
	
	/**
	 * 
	 * @author huixiong 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public Boolean rewardSave(Reward reward) throws Exception {
		int num = dao.save("RewardMapper.rewardSave", reward);
		if(num>0){
			return true;
		}
		return false;
	}
	public Boolean updateReward(Reward reward) throws Exception {
		int num = dao.update("RewardMapper.updateReward", reward);
		if(num>0){
			return true;
		}
		return false;
	}
	public Boolean updateStatus(Reward reward) throws Exception {
		int num = dao.update("RewardMapper.updateStatus", reward);
		if(num>0){
			return true;
		}
		return false;
	}
	public Boolean deleteById(Integer id) throws Exception {
		int num = dao.delete("RewardMapper.deleteById", id);
		if(num>0){
			return true;
		}
		return false;
	}
	
	public Reward findById(Integer id)throws Exception {
		Reward reward = dao.findForObject("RewardMapper.findById", id);
		return reward;
	}
}
  