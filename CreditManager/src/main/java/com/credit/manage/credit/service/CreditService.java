package com.credit.manage.credit.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credit.manage.entity.Credit;
import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.util.Const;
import com.gvtv.manage.base.util.PageData;


@Transactional(readOnly=true)
@Service("creditService")
public class CreditService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	public PageData list(PageData pd) throws Exception {
		PageData result = new PageData();
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			pd.put("keyword", "%" + search + "%");
		}
		int totalNum = (int) dao.findForObject("CreditMapper.count", pd);

		pd.put("from", pd.getInteger("start"));
		pd.put("size", pd.getInteger("length"));
		List<Credit> pds = dao.findForList("CreditMapper.list", pd);
		

		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.RECORDSTOTAL, totalNum);
		result.put(Const.RECORDSFILTERED, totalNum);
		result.put(Const.NDATA, pds);
		return result;
	}
	
	public Credit findById(Integer id) throws Exception {
		return (Credit) dao.findForObject("CreditMapper.findById", id);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public int save(Credit credit) throws Exception{
		return dao.save("CreditMapper.save", credit);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public int update(Credit credit) throws Exception{
		return dao.update("CreditMapper.update", credit);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public int updateStatus(Credit credit)throws Exception{
		return dao.update("CreditMapper.updateStatus", credit);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public int updateAudit(Credit credit)throws Exception{
		return dao.update("CreditMapper.updateAudit", credit);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public int delete(Integer id) throws Exception{
		return dao.delete("CreditMapper.delete", id);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void batchDelete(String ids) throws Exception {
		if (StringUtils.isNotBlank(ids)) {
			String[] idArr = ids.split(",");
			if (idArr.length > 0) {
				List<Integer> idList = new ArrayList<Integer>();
				for (String idStr : idArr) {
					idList.add(Integer.valueOf(idStr));
				}
				dao.delete("CreditMapper.batchDelete", idList);
			}
		}
	}
	public Boolean matchTeam(Credit credit) throws Exception{
		int num = dao.update("CreditMapper.matchTeam", credit);
		if (num > 0) {
			return true;
		}
		return false;
	}
}
