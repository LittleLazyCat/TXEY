package com.txey.record.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.txey.record.service.mybatis.RecordService;

@Controller
public class RecordController {
	@Autowired
	private RecordService recordService;

	@RequestMapping(value = "/index.html")
	public String loginPage() {
		return "login";
	}
	// @RequestMapping(value = "/addRecord", method = RequestMethod.POST)
	// public ModelAndView loginCheck(HttpServletRequest request){
	// boolean isValidUser =
	// userService.hasMatchUser(loginCommand.getUserName(),
	// loginCommand.getPassword());
	// if (!isValidUser) {
	// return new ModelAndView("login","error","username or password is
	// incorrect.");
	// }else{
	// User user = userService.findUserByUserName(loginCommand.getUserName());
	// user.setLastIp(request.getRemoteAddr());
	// user.setLastVisit(new Date());
	// userService.loginSuccess(user);
	// request.getSession().setAttribute("user", user);
	// return new ModelAndView("main");
	//
	// }

}
