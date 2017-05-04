package com.credit.manage.webUser.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credit.manage.entity.WebUser;
import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.util.Const;
import com.gvtv.manage.base.util.PageData;

@Transactional(readOnly=true)
@Service("webUserWebService")
public class WebUserWebService {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	/**
	 * 用户登录
	 * @author huixiong 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public WebUser login(PageData pd) throws Exception{
		return (WebUser) dao.findForObject("WebUserMapper.getUserInfo", pd);
	}
	
	/**
	 * 根据用户ID获取用户信息
	 * @author huixiong 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public WebUser getUserById(Integer id) throws Exception{
		return (WebUser) dao.findForObject("WebUserMapper.getUserById", id);
	}
	
	/**
	 * 保存专家顾问
	 * @author huixiong 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public Boolean saveUser(WebUser webUser) throws Exception{
		int num = dao.save("WebUserMapper.saveUserInfo", webUser);
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 修改用户密码
	 * @author huixiong 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public Boolean updatePassword(PageData pd) throws Exception{
		int num = dao.update("WebUserMapper.updatePassword", pd);
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 查找网站用户(不分页)
	 * @author  
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<WebUser> findUserList(PageData pd) throws Exception{
		List<WebUser> userList = dao.findForList("WebUserMapper.list", pd);
		return userList;
	}
	
	public PageData findPartUserList(PageData pd) throws Exception{
		PageData result = new PageData();
		String search = pd.getString("keyword");
		if (StringUtils.isNotBlank(search)) {
			pd.put("keyword", "%" + search + "%");
		}
		pd.put("from", pd.getInteger("start"));
		pd.put("size", pd.getInteger("length"));
		int totalNum = (int) dao.findForObject("WebUserMapper.count", pd);
		List<WebUser> userList = dao.findForList("WebUserMapper.list", pd);
		
		result.put(Const.DRAW, pd.getString(Const.DRAW));
		result.put(Const.RECORDSTOTAL, totalNum);
		result.put(Const.RECORDSFILTERED, totalNum);
		result.put(Const.NDATA, userList);
		return result;
	}
	
	/**
	 * 禁用用户
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public Boolean disableUser(PageData pd) throws Exception{
		int num = dao.update("WebUserMapper.disableUser", pd);
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 修改专家顾问
	 * @param webUser
	 * @return
	 * @throws Exception
	 */
	public Boolean updateUser(WebUser webUser) throws Exception{
		int num = dao.update("WebUserMapper.updateUser", webUser);
		if (num > 0) {
			return true;
		}
		return false;
	}
	/**
	 * 修改用户
	 * @param webUser
	 * @return
	 * @throws Exception
	 */
	public Boolean updateWebUser(WebUser webUser) throws Exception{
		int num = dao.update("WebUserMapper.updateWebUser", webUser);
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	public Integer deleteById(Integer id) throws Exception {
		return (Integer)dao.delete("WebUserMapper.deleteById", id);
	}
}
