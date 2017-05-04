package com.credit.manage.credit.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.credit.manage.agreement.service.AgreementWebService;
import com.credit.manage.credit.service.CreditService;
import com.credit.manage.entity.Agreement;
import com.credit.manage.entity.Credit;
import com.credit.manage.entity.WebUser;
import com.credit.manage.filemanager.service.UploadFileService;
import com.credit.manage.util.ProvinceEnum;
import com.credit.manage.webUser.service.WebUserWebService;
import com.gvtv.manage.base.controller.BaseController;
import com.gvtv.manage.base.util.DataUtil;
import com.gvtv.manage.base.util.PageData;
import com.gvtv.manage.base.util.PropertiesUtil;

@Controller
@RequestMapping(value = "/credit")
public class CreditController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(CreditController.class);
	@Resource
	private CreditService creditService;
	@Resource
	private WebUserWebService webUserWebService;
	@Resource
	private AgreementWebService agreementWebService;
	@Resource
	private UploadFileService uploadFileService;
	


	@RequestMapping
	public ModelAndView page() {
		PageData pd = super.getPageData();
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("credit/credit/credit_list");
		return mv;
	}

	@RequiresPermissions("credit:view")
	@RequestMapping(value = "/list")
	@ResponseBody
	public PageData list() {
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			result = creditService.list(pd);
		} catch (Exception e) {
			logger.error("list user error", e);
			result = new PageData();
		}
		return result;
	}
	
	
	
	/**
	 * 查询意见反馈详情
	 * @param id
	 * @return
	 */
	@RequiresPermissions("credit:view")
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public ModelAndView toDetails(@RequestParam Integer id){
		Credit credit = null;
		WebUser user = null;
		try {
			credit = creditService.findById(id);
			if(StringUtils.isNotEmpty(credit.getDisposalType())){
				String[] types = credit.getDisposalType().split(",");
				credit.setDisTypes(types);
			}
			if(StringUtils.isNotEmpty(credit.getDebtProof())){
				String[] Proofs = credit.getDebtProof().split(";");
				credit.setDebtProofs(Proofs);
			}
			if(StringUtils.isNotEmpty(credit.getDealTeamName())){
				user = webUserWebService.getUserById(Integer.valueOf(credit.getDealTeamName()));
			}
			String showImgPath = PropertiesUtil.getValue("showImgPath");
			PageData pd = this.getPageData();
			pd.put("creditId", credit.getId());
			List<Agreement> agreeList=agreementWebService.list(pd);
			ModelAndView mv = super.getModelAndView();
			mv.addObject("showImgPath", showImgPath);
			mv.addObject("credit", credit);
			mv.addObject("agreeList", agreeList);
			mv.addObject("user", user);
			mv.setViewName("credit/credit/credit_details");
			return mv;
		} catch (Exception e) {
			logger.error("get fileManager error", e);
		}
		
        return null;
	}
	
	
    /**
     * 跳转到新增页面
     * @return
     * @throws Exception 
     */
	@RequiresPermissions("credit:view")
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView toAdd() throws Exception{
		List<String> provinceList = ProvinceEnum.takeAllValues();//省份list
		String creditType = super.getRequest().getParameter("creditType");
		ModelAndView mv = this.getModelAndView();
		PageData pd = super.getPageData();
		pd.put("userLevel", 0);//注册用户
		pd.put("userStatus", 1);
		List<WebUser> userList = webUserWebService.findUserList(pd);
		
		mv.addObject("pd", pd);
		mv.addObject("userList", userList);
		mv.addObject("provinceList", provinceList);
		if(creditType.equals("1")){
			mv.setViewName("credit/credit/credit_add");
		}else if(creditType.equals("2")){
			mv.setViewName("credit/credit/credit_tran_add");
		}
		return mv;
	}
	
	/**
	 * 新增下载法律文件信息
	 * @return
	 */
	@RequiresPermissions("credit:add")
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public PageData add(Credit credit){
		PageData result = new PageData();
		try {
			String images = "";
			if(null != credit.getUploadFiles()){
				for(int i=0;i< credit.getUploadFiles().length;i++){
					if(0 != credit.getUploadFiles()[i].getSize()){
						String newFileName = DataUtil.getRandomStr();
						String fileName = credit.getUploadFiles()[i].getOriginalFilename();
						fileName = "credit"+newFileName + fileName.substring(fileName.lastIndexOf("."), fileName.length());
						uploadFileService.uploadFile(PropertiesUtil.getValue("saveImgPath")+"uploadFile/credit", credit.getUploadFiles()[i], fileName);
						if(i == 0){
							images += "uploadFile/credit/"+fileName;
						}else{
							images += ";uploadFile/credit/"+fileName;
						}
					}
				}
			}
			credit.setDebtProof(images);
			credit.setCreateDate(new Date());
			credit.setCrStatus((short)1);
			credit.setIsAudit(0);
			int num= creditService.save(credit);
			if(num>0){
				result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("add filemanager error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	/**
	 * 跳转到更新法律文件信息页面
	 * @return
	 */
	@RequiresPermissions("credit:view")
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView toEdit(@RequestParam Integer id){
		Credit credit = null;
		List<WebUser> userList = null;
		String creditType = super.getRequest().getParameter("creditType");
		try {
			credit = creditService.findById(id);
			PageData pd = super.getPageData();
			pd.put("userLevel", 0);//注册用户
			pd.put("userStatus", 1);
			pd.put("from", null);
			userList = webUserWebService.findUserList(pd);
			
		} catch (Exception e) {
			logger.error("get fileManager error", e);
		}
		ModelAndView mv = super.getModelAndView();
		List<String> provinceList = ProvinceEnum.takeAllValues();//省份list
		mv.addObject("provinceList", provinceList);
		mv.addObject("userList", userList);
		mv.addObject("credit", credit);
		if(creditType.equals("1")){
			mv.setViewName("credit/credit/credit_edit");
		}else if(creditType.equals("2")){
			mv.setViewName("credit/credit/credit_tran_edit");
		}
		
		return mv;
	}
	
	/**
	 * 更新法律文件信息
	 * @return
	 */
	@RequiresPermissions("credit:edit")
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public PageData edit(Credit credit){
		PageData result = new PageData();
		try {
			String images = "";
			if(null != credit.getUploadFiles()){
				for(int i=0;i< credit.getUploadFiles().length;i++){
					if(0 != credit.getUploadFiles()[i].getSize()){
						String newFileName = DataUtil.getRandomStr();
						String fileName = credit.getUploadFiles()[i].getOriginalFilename();
						fileName = "credit"+newFileName + fileName.substring(fileName.lastIndexOf("."), fileName.length());
						uploadFileService.uploadFile(PropertiesUtil.getValue("saveImgPath")+"uploadFile/credit", credit.getUploadFiles()[i], fileName);
						if(i == 0){
							images += "uploadFile/credit/"+fileName;
						}else{
							images += ";uploadFile/credit/"+fileName;
						}
					}
				}
				credit.setDebtProof(images);
			}
			int num= creditService.update(credit);
			if(num>0){
				result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("edit credit error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}
		
	/**
	 * 跳转到债权审核
	 * @return
	 */
	@RequiresPermissions("credit:view")
	@RequestMapping(value="/audit", method=RequestMethod.GET)
	public ModelAndView toAudit(@RequestParam Integer id){
		Credit credit = null;
		try {
			credit = creditService.findById(id);
		} catch (Exception e) {
			logger.error("get fileManager error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("credit", credit);
		mv.setViewName("credit/credit/credit_audit");
		return mv;
	}
	
	/**
	 * 债权审核
	 * @return
	 */
	@RequiresPermissions("credit:edit")
	@RequestMapping(value="/audit", method=RequestMethod.POST)
	@ResponseBody
	public PageData audit(Credit credit){
		PageData result = new PageData();
		try {
			int num= creditService.updateAudit(credit);
			if(num>0){
				result.put("status", 1);
				result.put("msg", "审核成功");
			}
		} catch (Exception e) {
			logger.error("edit filemanager error", e);
			result.put("status", 0);
			result.put("msg", "审核失败");
		}
		return result;
	}
	/**
	 * 批量债权审核
	 * @return
	 */
	@RequiresPermissions("credit:edit")
	@RequestMapping(value="/batchAudit")
	@ResponseBody
	public PageData batchAudit(String ids){
		PageData result = new PageData();
		try {
			String[] res = ids.split(",");
			int num= 0;
			if(null != res && res.length > 0){
				for(String id : res){
					Credit credit = new Credit();
					credit.setId(Integer.valueOf(id));
					credit.setIsAudit(1);
					num= creditService.updateAudit(credit);
				}
			}
			if(num>0){
				result.put("status", 1);
				result.put("msg", "审核成功");
			}
		} catch (Exception e) {
			logger.error("edit filemanager error", e);
			result.put("status", 0);
			result.put("msg", "审核失败");
		}
		return result;
	}
	/**
	 * 修改债权状态
	 * @param credit
	 * @return
	 */
	@RequiresPermissions("credit:view")
	@RequestMapping(value="/updateStatus",method=RequestMethod.GET)
	public ModelAndView toUpdateStatus(Integer id){
		Credit credit = null;
		try {
			credit = creditService.findById(id);
		} catch (Exception e) {
			logger.error("get fileManager error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("credit", credit);
		mv.setViewName("credit/credit/credit_updateStatus");
		return mv;
	}
	
	/**
	 * 修改债权状态
	 * @param credit
	 * @return
	 */
	@RequiresPermissions("credit:edit")
	@RequestMapping(value="/updateStatus")
	@ResponseBody
	public PageData updateStatus(Credit credit){
		PageData result = new PageData();
		try {
			int num= creditService.updateStatus(credit);
			if(num>0){
				result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("edit credit error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}
	/**
	 *删除法律文件信息
	 * @return
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(@RequestParam Integer id){
		PageData result = new PageData();
		try {
			creditService.delete(id);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("delete filemanager error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/batchDelete")
	@ResponseBody
	public PageData batchDelete(@RequestParam String ids){
		PageData result = new PageData();
		try {
			creditService.batchDelete(ids);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("batch delete user error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}
	@RequestMapping(value="/imgDetail")
	public ModelAndView imageDetail(String imageUrl){
		ModelAndView mv = super.getModelAndView();
		mv.addObject("rewardImg",imageUrl);
		mv.setViewName("credit/reward/image_detail");
		return mv;
	}
	/**
	 * 跳转到选择处置团队
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/chooseTeam")
	public ModelAndView chooseTeam(Integer id)throws Exception{
		PageData pd = new PageData();
		pd.put("userLevel", 0);
		pd.put("userType", 1);
		pd.put("from", 0);
		pd.put("size", 0);
		List<WebUser> teamList = webUserWebService.findUserList(pd);
		ModelAndView mv = super.getModelAndView();
		
		mv.addObject("id",id);
		mv.addObject("teamList",teamList);
		mv.setViewName("/credit/credit/choose_team");
		return mv;
	}
	
	/**
	 * 匹配处置团队
	 * @return
	 */
	@RequestMapping(value="/matchTeam")
	@ResponseBody
	public PageData matchTeam(Credit credit){
		PageData result = new PageData();
		try {
			credit.setCrStatus((short)2);
			creditService.matchTeam(credit);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("delete filemanager error", e);
			result.put("status", 0);
			result.put("msg", "匹配失败");
		}
		return result;
	}
	
	/**
	 * 取消匹配处置团队
	 * @return
	 */
	@RequestMapping(value="/delmatchTeam")
	@ResponseBody
	public PageData delmatchTeam(Integer id){
		PageData result = new PageData();
		try {
			Credit credit = new Credit();
			credit.setId(id);
			credit.setCrStatus((short)1);
			credit.setDealTeamName("");
			creditService.matchTeam(credit);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("delmatch Team error", e);
			result.put("status", 0);
			result.put("msg", "取消失败");
		}
		return result;
	}
	
}
