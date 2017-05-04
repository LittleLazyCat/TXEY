package com.credit.manage.webUser.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.credit.manage.entity.WebUser;
import com.credit.manage.filemanager.service.UploadFileService;
import com.credit.manage.webUser.service.WebUserWebService;
import com.gvtv.manage.base.controller.BaseController;
import com.gvtv.manage.base.util.DataUtil;
import com.gvtv.manage.base.util.MD5;
import com.gvtv.manage.base.util.PageData;
import com.gvtv.manage.base.util.PropertiesUtil;

@Controller
@RequestMapping(value="/webUser")
public class WebUserController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(WebUserController.class);
	
	@Resource
	private WebUserWebService webUserWebService;
	
	@Resource
	private UploadFileService uploadFileService;
	
	/**
	 * 图片上传保存路径
	 */
	private final String IMG_UPLOAD_URL = PropertiesUtil.getValue("saveImgPath"); 
	
	/**
	 * 跳转到注册用户列表
	 * @return
	 */
	@RequestMapping(value="/cr_page")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("credit/webUser/webUser_list");
		return mv;
	}
	
	/**
	 * 跳转到注册用户列表
	 * @return
	 */
	@RequestMapping(value="/ex_page")
	public ModelAndView expertPage(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("credit/webUser/expert_list");
		return mv;
	}
	
	/**
	 * 查询注册用户列表
	 * @return
	 */
	@RequestMapping(value="/cr_list")
	@ResponseBody
	public PageData crList(){
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			pd.put("userLevel", 0);//注册用户
			result = webUserWebService.findPartUserList(pd);
		} catch (Exception e) {
			logger.error("list webUser error", e);
			result = new PageData();
		}
		return result;
		
	}
	
	/**
	 * 查询专家顾问列表
	 * @return
	 */
	@RequestMapping(value="/ex_list")
	@ResponseBody
	public PageData expertList(){
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			pd.put("userLevel", 99);//专家 媒体人 等
			result = webUserWebService.findPartUserList(pd);
		} catch (Exception e) {
			logger.error("list webUser error", e);
			result = new PageData();
		}
		return result;
	}
	
	/**
	 * 查看用户明细
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userdetails")
	public ModelAndView userDetails(HttpServletRequest request) throws Exception{
		String id =request.getParameter("id");
		ModelAndView mv = this.getModelAndView();
		if(id!=null){
			WebUser user = webUserWebService.getUserById(Integer.valueOf(id));
			mv.addObject("user",user);
			mv.setViewName("/mobile/user_info");
		}
		return mv;
	}
	
	/**
	 * 专家顾问详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/expertDetail")
	public ModelAndView expertDetail(String id) throws Exception{
		ModelAndView mv = this.getModelAndView();
		if(null != id && !"".equals(id)){
			WebUser user = webUserWebService.getUserById(Integer.valueOf(id));
			user.setUserHeadImages(PropertiesUtil.getValue("showImgPath")+user.getUserHeadImages());
			mv.addObject("user",user);
		}
		mv.setViewName("credit/webUser/webUser_detail");
		return mv;
	}
	
	/**
	 * 重置用户密码
	 * @return
	 */
	@RequestMapping(value="/resetPass")
	@ResponseBody
	public PageData resetPassword(Integer id){
		PageData pd = new PageData();
		try {
			String newEncodePwd = MD5.md5("123456");
			pd.put("id", id);
			pd.put("newEncodePwd", newEncodePwd);
			Boolean isFlag = webUserWebService.updatePassword(pd);
			if(isFlag){
				pd.put("result", "密码已重置");
			}else{
				pd.put("result", "重置失败");
			}
		} catch (Exception e) {
			logger.error("reset webUser error", e);
			pd.put("result", "重置失败");
		}
		
		return pd;
	}
	
	/**
	 * 禁用用户
	 * @return
	 */
	@RequestMapping(value="/disable")
	@ResponseBody
	public PageData disableWebUser(Integer id){
		PageData result = new PageData();
		try {
			result.put("id", id);
			Boolean isFlag = webUserWebService.disableUser(result);
			if(isFlag){
				result.put("result", "用户已禁用");
				result.put("status", 1);
			}else{
				result.put("result", "禁用失败");
				result.put("status", 0);
			}
		} catch (Exception e) {
			logger.error("disable webUser error", e);
			result.put("result", "禁用失败");
			result.put("status", 0);
		}
		return result;
	}
	
	/**
	 * 跳转到用户修改页面
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView toUserUpdate(Integer id){
		ModelAndView mv = super.getModelAndView();
		if(null != id){
			try{
				WebUser user = webUserWebService.getUserById(Integer.valueOf(id));
				mv.addObject("user",user);
			}catch(Exception e){
				logger.error("toupdate webUser error", e);
			}
		}else{
			
		}
		mv.setViewName("credit/webUser/webUser_update");
		return mv;
	}
	
	/**
	 * 修改用户
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public PageData userUpdate(WebUser user){
		PageData result = new PageData();
		try{
			webUserWebService.updateWebUser(user);
			result.put("status", 1);
		}catch(Exception e){
			logger.error("updaet webUser error", e);
			result.put("status", 0);
			result.put("msg", "操作失败");
		}
			
		return result;
	}
	
	/**
	 * 跳转到专家顾问新增修改页面
	 * @return
	 */
	@RequestMapping(value="/toAddOrUpd")
	public ModelAndView toAdd(Integer id){
		ModelAndView mv = super.getModelAndView();
		if(null != id){
			try{
				WebUser user = webUserWebService.getUserById(Integer.valueOf(id));
				mv.addObject("user",user);
			}catch(Exception e){
				logger.error("add webUser error", e);
			}
		}else{
			
		}
		mv.setViewName("credit/webUser/webUser_addOrUpd");
		return mv;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(Integer id){
		PageData result = new PageData();
		try{
			int line = webUserWebService.deleteById(id);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败或者为不可删除状态");
			}
		}catch(Exception e){
			logger.error("delete webUser error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	/**
	 * 保存专家顾问信息
	 * @return
	 */
	@RequestMapping(value="/addOrUpd", method=RequestMethod.POST)
	@ResponseBody
	public PageData saveOrUpd(WebUser webUser){
		PageData result = new PageData();
		try{
			if(null != webUser.getUploadFile() && 0 != webUser.getUploadFile().getSize()){
				
				String newFileName = DataUtil.getRandomStr();
				String fileName = webUser.getUploadFile().getOriginalFilename();
				if(webUser.getUserStatus() == 7){
					newFileName = "hplus/img/expert/" + newFileName;
				}else if (webUser.getUserStatus() == 8){
					newFileName = "hplus/img/lawyer/" + newFileName;
				}else{
					newFileName = "hplus/img/media/" + newFileName;
				}
				fileName = newFileName + fileName.substring(fileName.lastIndexOf("."), fileName.length());
				
				uploadFileService.uploadFile(IMG_UPLOAD_URL, webUser.getUploadFile(), fileName);
				webUser.setUserHeadImages(fileName);
			}
			webUser.setUserLevel((short)99);
			if(null == webUser.getId() || 0 == webUser.getId()){
				webUserWebService.saveUser(webUser);
			}else{
				webUserWebService.updateUser(webUser);
			}
			result.put("status", 1);
			
		}catch(Exception e){
			logger.error("addOrUpd webUser error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		
		return result;
	}
}
