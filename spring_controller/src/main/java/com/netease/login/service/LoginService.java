package com.netease.login.service;

import com.netease.login.model.User;

public interface LoginService {
	public User findUser(String userName,String userPassword);
}
