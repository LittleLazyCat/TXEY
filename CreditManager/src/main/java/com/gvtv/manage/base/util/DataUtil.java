package com.gvtv.manage.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public final class DataUtil {
	
//	public static String getNowDate(){
//		
//	}
	
	public static Date getCurrentTime(){
		return new Date();
	}
	
	//String类型转换为Date类型
	public static Date getConvertDateTime(String formatDate){
	    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	    Date date=null;
	    try {
	        date = format.parse(formatDate);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return date;
	}
	
	//当前时间格式：2015年11月12日   星期四
	public static String getCurrrentDateTime(){
	    Date date = new Date();  
	    SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
//	    DateFormat format = DateFormat.getDateInstance(DateFormat.FULL);   
	    String str = format.format(date); 
	     return str;
	}
	
	
	//将11/02/2015日期格式转换为2015年11月02日
	public static String getConvertStringTime(String str){	
		if(str!=null){
			String str1[]=str.split("/");
			str=str1[2]+"年"+str1[0]+"月"+str1[1]+"日";
		}else{
			System.out.println("请输入正确的日期格式！");
		}
		return str;
	}
	
	public static int nextInt() {
		Random random = new Random();
		int x = random.nextInt(899999);
		x = x+ 100000;
		
		return x;
	}
	
	public static String getRandomStr(){
		Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month=cal.get(Calendar.MONTH);//获取月份 
        int day=cal.get(Calendar.DATE);//获取日 
        int hour=cal.get(Calendar.HOUR);//小时 
        int minute=cal.get(Calendar.MINUTE);//分            
        int second=cal.get(Calendar.SECOND);//秒
        
        Random random = new Random();
		int x = random.nextInt(900)+100;
		
        StringBuffer sb = new StringBuffer();
        sb.append(year).append(month).append(day).append(hour).append(minute).append(second).append(x);
        return sb.toString();
	}
	
	public static void main(String[] args) {
		Date date = new Date(); 
		System.out.println(getRandomStr());
		String fileName = "aadasdasda.xls";
		fileName = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		System.out.println(fileName);
	}

}
