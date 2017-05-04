package com.credit.manage.feedback.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credit.manage.entity.Credit;
import com.credit.manage.entity.Feedback;
import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.util.Const;
import com.gvtv.manage.base.util.PageData;

@Transactional(readOnly=true)
@Service("feedbackService")
public class FeedbackService {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	public PageData list(PageData pd) throws Exception {
		PageData result = new PageData();
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			pd.put("keyword", "%" + search + "%");
		}
		int totalNum = (int) dao.findForObject("FeedbackMapper.count", pd);

		pd.put("from", pd.getInteger("start"));
		pd.put("size", pd.getInteger("length"));
		List<Feedback> pds = dao.findForList("FeedbackMapper.list", pd);
		

		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.RECORDSTOTAL, totalNum);
		result.put(Const.RECORDSFILTERED, totalNum);
		result.put(Const.NDATA, pds);
		return result;
	}
	
	public Feedback findById(Integer id) throws Exception {
		return (Feedback) dao.findForObject("FeedbackMapper.findById", id);
	}
}
