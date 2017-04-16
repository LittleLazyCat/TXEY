package com.baobaotao.dao;

import java.net.InetAddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

@Repository		//通过Spring注解定义一个DAO
public class UserDao {
	@Autowired//自动注入JdbcTemplate的Bean
	private JdbcTemplate jdbcTemplete;
	public int getMatchCount(String userName,String password){
		String sql =" SELECT count(*) FROM t_user "
				+" WHERE user_name = ? and password = ?";
		return jdbcTemplete.queryForInt(sql, new Object[]{userName,password});
	}
	public User findUserByUserName(final String userName){
		String sql=" SELECT user_id,user_name,credits,last_visit,last_ip "
				+" FROM t_user WHERE user_name = ?";
		final User user = new User();
		jdbcTemplete.query(sql, new Object[]{userName},
				new RowCallbackHandler() {
					
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						user.setUserId(rs.getInt("user_id"));
						user.setUserName(rs.getString("user_Name"));
						user.setCredits(rs.getInt("credits"));
						user.setLastVisit(rs.getDate("last_visit"));
						user.setLastIp(rs.getString("last_ip"));
					}
				});
		return user;
	}
	public void updateLoginInfo(User user){ 
		String sql =" UPDATE t_user SET last_visit = ?,last_ip = ?,credits=? "
				+" WHERE user_id =?";
		jdbcTemplete.update(sql, new Object[]{new java.util.Date(2017, 2, 17, 1, 3, 0),"127.0.0.1",
				user.getCredits(),user.getUserId()});
	}
}
