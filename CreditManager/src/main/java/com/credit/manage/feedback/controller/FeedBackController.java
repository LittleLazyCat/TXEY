package com.credit.manage.feedback.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.credit.manage.entity.Feedback;
import com.credit.manage.feedback.service.FeedbackService;
import com.gvtv.manage.base.controller.BaseController;
import com.gvtv.manage.base.system.controller.UserController;
import com.gvtv.manage.base.util.PageData;

@Controller
@RequestMapping(value = "/feedback")
public class FeedBackController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(FeedBackController.class);
	@Resource
	private FeedbackService feedbackService;
	
	@RequestMapping
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("credit/feedback/feedback_list");
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
			result = feedbackService.list(pd);
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
		Feedback feedback = null;
		try {
			feedback = feedbackService.findById(id);
		} catch (Exception e) {
			logger.error("get feedback error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("feedback", feedback);
		mv.setViewName("credit/feedback/feedback_details");
		return mv;
	}
	
}
