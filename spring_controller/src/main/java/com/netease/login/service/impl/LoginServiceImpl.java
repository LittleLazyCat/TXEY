package com.netease.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.login.dao.LoginDao;
import com.netease.login.model.User;
import com.netease.login.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	public User findUser(String name, String psw) {
		return loginDao.findUser(name, psw);
	}

}
