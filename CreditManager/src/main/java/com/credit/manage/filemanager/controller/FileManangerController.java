package com.credit.manage.filemanager.controller;


import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.credit.manage.entity.FileManager;
import com.credit.manage.filemanager.service.FileManagerService;
import com.credit.manage.filemanager.service.UploadFileService;
import com.gvtv.manage.base.controller.BaseController;
import com.gvtv.manage.base.util.DataUtil;
import com.gvtv.manage.base.util.PageData;
import com.gvtv.manage.base.util.PropertiesUtil;

/**
 *  法律文件模版下载管理
 * @author liaoxiongjian
 * @version 1.0
 */
@Controller
@RequestMapping(value="/filemanager")
public class FileManangerController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(FileManangerController.class);
	@Resource
	private FileManagerService fileManagerService;
	@Resource
	private UploadFileService uploadFileService;
	
	@RequestMapping
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		String headUrl = PropertiesUtil.getValue("showImgPath");
		mv.addObject("headUrl", headUrl);
		mv.setViewName("credit/filemanager/filemanager_list");
		return mv;
	}
	
	/**
	 * 意见反馈列表
	 * @return
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	public PageData list(){
		PageData result = null;
		try {
			PageData pd = super.getPageData();
			result = fileManagerService.list(pd);
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
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public ModelAndView toDetails(@RequestParam Integer id){
		FileManager fileManager = null;
		try {
			fileManager = fileManagerService.findById(id);
		} catch (Exception e) {
			logger.error("get fileManager error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("fileManager", fileManager);
		mv.setViewName("credit/filemanager/filemanager_details");
		return mv;
	}
	
	
    /**
     * 跳转到新增页面
     * @return
     */
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView toAdd(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("credit/filemanager/filemanager_add");
		return mv;
	}
	
	/**
	 * 新增下载法律文件信息
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public PageData add(FileManager fileManager){
		PageData result = new PageData();
		try {
			if(null != fileManager.getUploadFile() && 0 != fileManager.getUploadFile().getSize()){
				
				String newFileName = DataUtil.getRandomStr();
				String fileName = fileManager.getUploadFile().getOriginalFilename();
				if(fileManager.getFileType() == 1){
					newFileName = "uploadFile/falvwenshu/" + newFileName;
				}else if(fileManager.getFileType() == 2){
					newFileName = "uploadFile/htwenshu/" + newFileName;
				}else if(fileManager.getFileType() == 3){
					newFileName = "uploadFile/qitawenshu/" + newFileName;
				}
				fileName = newFileName + fileName.substring(fileName.lastIndexOf("."), fileName.length());
				
				uploadFileService.uploadFile(PropertiesUtil.getValue("saveImgPath"), fileManager.getUploadFile(), fileName);
				fileManager.setDownloadUrl(fileName);
			}
			int num= fileManagerService.save(fileManager);
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
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView toEdit(@RequestParam Integer id){
		FileManager fileManager = null;
		try {
			fileManager = fileManagerService.findById(id);
		} catch (Exception e) {
			logger.error("get fileManager error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("fileManager", fileManager);
		mv.setViewName("credit/filemanager/filemanager_edit");
		return mv;
	}
	
	/**
	 * 更新法律文件信息
	 * @return
	 */
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public PageData edit(FileManager fileManager){
		PageData result = new PageData();
		try {
			int num= fileManagerService.update(fileManager);
			if(num>0){
				result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("edit filemanager error", e);
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
			fileManagerService.delete(id);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("delete filemanager error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
}
