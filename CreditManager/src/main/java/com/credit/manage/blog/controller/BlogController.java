package com.credit.manage.blog.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.credit.manage.blog.service.BlogWebService;
import com.credit.manage.entity.Blog;
import com.credit.manage.filemanager.service.UploadFileService;
import com.gvtv.manage.base.controller.BaseController;
import com.gvtv.manage.base.util.DataUtil;
import com.gvtv.manage.base.util.PageData;
import com.gvtv.manage.base.util.PropertiesUtil;

@Controller
@RequestMapping(value="/blog")
public class BlogController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(BlogController.class);
	@Resource
	private BlogWebService blogWebService;
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
				Blog blog = blogWebService.findById(Integer.valueOf(id));
				mv.addObject("blog",blog);
			}catch(Exception e){
				logger.error("toadd blog error", e);
			}
		}else{
			
		}
		mv.setViewName("credit/blog/blog_addOrUpd");
		return mv;
	}
	
	/**
	 * 跳转到文章添加列表
	 * @return
	 */
	@RequestMapping(value="/page")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		String headUrl = PropertiesUtil.getValue("showImgPath");
		mv.addObject("headUrl", headUrl);
		mv.setViewName("credit/blog/blog_list");
		return mv;
	}
	
	/**
	 * 业务资讯分页信息
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
			result = blogWebService.pageList(pd);
		} catch (Exception e) {
			logger.error("list blog error", e);
			result = new PageData();
		}
		return result;
	}
	
	/**
	 * 保存或修改业务资讯
	 * @return
	 */
	@RequestMapping(value="/addOrUpd", method=RequestMethod.POST)
	@ResponseBody
	public PageData saveOrUpd(Blog blog){
		PageData result = new PageData();
		try{
			if(null != blog.getUploadFile() && 0 != blog.getUploadFile().getSize()){
				
				String newFileName = DataUtil.getRandomStr();
				String fileName = blog.getUploadFile().getOriginalFilename();
				newFileName = "hplus/img/sample/" + newFileName;
				fileName = newFileName + fileName.substring(fileName.lastIndexOf("."), fileName.length());
				
				uploadFileService.uploadFile(PropertiesUtil.getValue("saveImgPath"), blog.getUploadFile(), fileName);
				blog.setBlogImage(fileName);
			}
			if(null != blog.getId() && 0 != blog.getId()){
				blogWebService.updateBlog(blog);
			}else{
				blog.setCreateTime(new Date());
				blog.setBlogStatus((short)0);
				blogWebService.saveUser(blog);
			}
			result.put("status", 1);
		}catch(Exception e){
			logger.error("addOrUpd blog error", e);
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
			int line = blogWebService.deleteById(id);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败或者为不可删除状态");
			}
		}catch(Exception e){
			logger.error("delete blog error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/updStatus")
	@ResponseBody
	public PageData updStatus(Integer id,Short blogStatus){
		PageData result = new PageData();
		try{
			Blog blog = new Blog();
			blog.setId(id);
			blog.setBlogStatus(blogStatus);
			blogWebService.updateBlogStatus(blog);
			result.put("status", 1);
		}catch(Exception e){
			logger.error("delete blog error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/batchStatus")
	@ResponseBody
	public PageData batchStatus(String ids){
		PageData result = new PageData();
		try{
			String[] res = ids.split(",");
			if(null != res && res.length > 0){
				for(String id : res){
					Blog blog = new Blog();
					blog.setId(Integer.valueOf(id));
					blog.setBlogStatus((short)1);
					blogWebService.updateBlogStatus(blog);
					blog = null;
				}
			}
			result.put("status", 1);
		}catch(Exception e){
			logger.error("delete blog error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/batchDelete")
	@ResponseBody
	public PageData batchDelete(String ids){
		PageData result = new PageData();
		try{
			int line = 0;
			String[] res = ids.split(",");
			if(null != res && res.length > 0){
				for(String id : res){
					line = blogWebService.deleteById(Integer.valueOf(id));
				}
			}
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败或者为不可删除状态");
			}
		}catch(Exception e){
			logger.error("delete blog error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	/**
	 * 业务资讯详细信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/details")
	public ModelAndView blogDetails(Integer id) throws Exception{
		
		Blog blog = blogWebService.findById(id);
		ModelAndView mv = this.getModelAndView();
		mv.addObject(blog);
		mv.setViewName("credit/blog/blog_details");
		return mv;
	}
	
	
}
