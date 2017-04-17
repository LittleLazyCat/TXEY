package com.Alex.dao.imp;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
 private static UserDaoImp userDaoImp= null;
 private static DaoFactory instance = new DaoFactory();
 private DaoFactory(){
	 try{
		 Properties prop = new Properties();
		 InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("jdbcconfig.properties");
		 prop.load(in);
		 String userDaoClass = prop.getProperty("userDaoClass");
		 Class clazz = Class.forName(userDaoClass);
		 userDaoImp = (UserDaoImp)clazz.newInstance();
	 }catch (Exception e) {
		// TODO: handle exception
		 throw new ExceptionInInitializerError(e);
	}
 }
 public static DaoFactory getInstance(){
	 return instance;
 }
 public UserDaoImp getuserDaoImp(){
	 return userDaoImp;
 }
}
