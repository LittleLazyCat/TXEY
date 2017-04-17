package com.netease.login.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.netease.login.model.User;
@Repository
public interface LoginDao {
	@Results({
		@Result(property ="userId",column="userId"),
		@Result(property="userName",column="userName"),
		@Result(property="userPassword",column="userPassword")
	})
	@Select("select * from user where userName=#{userName} and userPassword=#{userPassword}")
public User findUser(@Param("userName")String name,@Param("userPassword")String psw);
}
