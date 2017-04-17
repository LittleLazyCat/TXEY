package com.netease.course.web.controller;

import java.io.IOException;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/users/{userId}")
	public void spring(@PathVariable("userId") String userId, @RequestParam("msg") String msg,
			@RequestHeader("host") String host, Writer writer) throws IOException {
		writer.write("userId=" + userId + ", msg=" + msg + ", hostHeader=" + host);
	}

	@RequestMapping("/users/login2")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap map)
			throws IOException {
		map.addAttribute("name", name);
		map.addAttribute("password", "******");

		return "user";
	}
}
