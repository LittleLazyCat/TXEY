package com.credit.manage.sample.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.credit.manage.entity.Sample;
import com.credit.manage.filemanager.service.UploadFileService;
import com.credit.manage.sample.service.SampleWebService;
import com.gvtv.manage.base.controller.BaseController;
import com.gvtv.manage.base.util.DataUtil;
import com.gvtv.manage.base.util.PageData;
import com.gvtv.manage.base.util.PropertiesUtil;

@Controller
@RequestMapping(value="/sample")
public class SampleController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(SampleController.class);
	@Resource
	private SampleWebService sampleWebService;
	
	@Resource
	private UploadFileService uploadFileService;
	
	/**
	 * 跳转到添加或修改页面
	 * @return
	 */
	@RequestMapping(value="/toAddOrUpd")
	public ModelAndView addOrUpd(Integer id){
		ModelAndView mv = super.getModelAndView();
		if(null != id){
			try{
				Sample sample = sampleWebService.findById(Integer.valueOf(id));
				mv.addObject("sample",sample);
			}catch(Exception e){
				logger.error("toadd sample error", e);
			}
		}else{
			
		}
		mv.setViewName("credit/sample/sample_addOrUpd");
		return mv;
	}
	
	/**
	 * 跳转到列表
	 * @return
	 */
	@RequestMapping(value="/page")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("credit/sample/sample_list");
		return mv;
	}
	
	/**
	 * 分页信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	public PageData list(){
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			result = sampleWebService.pageList(pd);
		} catch (Exception e) {
			logger.error("list sample error", e);
			result = new PageData();
		}
		return result;
	}
	
	/**
	 * 保存或修改
	 * @return
	 */
	@RequestMapping(value="/addOrUpdate", method=RequestMethod.POST)
	@ResponseBody
	public PageData saveOrUpd(Sample sample){
		PageData result = new PageData();
		try{
			if(null != sample.getHeadImgFile() && 0 != sample.getHeadImgFile().getSize()){
				
				String newFileName = DataUtil.getRandomStr();
				String fileName = sample.getHeadImgFile().getOriginalFilename();
				newFileName = "hplus/img/sample/" + newFileName;
				fileName = newFileName + fileName.substring(fileName.lastIndexOf("."), fileName.length());
				
				uploadFileService.uploadFile(PropertiesUtil.getValue("saveImgPath"), sample.getHeadImgFile(), fileName);
				sample.setSamImg(fileName);
			}
			if(null != sample.getId() && 0 != sample.getId()){
				sampleWebService.updateSample(sample);
			}else{
				sample.setStatus((short)0);
				sampleWebService.saveUser(sample);
			}
			result.put("status", 1);
		}catch(Exception e){
			logger.error("addOrUpd sample error", e);
			result.put("status", 0);
			result.put("msg", "操作失败");
		}
		return result;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(Integer id){
		PageData result = new PageData();
		try{
			int line = sampleWebService.deleteById(id);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败或者为不可删除状态");
			}
		}catch(Exception e){
			logger.error("delete sample error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/updStatus")
	@ResponseBody
	public PageData updStatus(Integer id,Short status){
		PageData result = new PageData();
		try{
			Sample sample = new Sample();
			sample.setId(id);
			sample.setStatus(status);
			sampleWebService.updateBlogStatus(sample);
			result.put("status", 1);
		}catch(Exception e){
			logger.error("delete sample error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	/**
	 * 详细信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/detail")
	public ModelAndView blogDetails(Integer id) throws Exception{
		
		Sample sample = sampleWebService.findById(id);
		ModelAndView mv = this.getModelAndView();
		if(null != sample.getSamImg()){
			sample.setSamImg(PropertiesUtil.getValue("showImgPath")+sample.getSamImg());
		}
		mv.addObject(sample);
		mv.setViewName("credit/sample/sample_detail");
		return mv;
	}
	
	
}
