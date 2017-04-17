package com.Alex.dao.imp;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Alex.dao.UserDao;
import com.Alex.dao.ex.RunTimeExcUser;
import com.Alex.domain.User;
import com.Alex.util.JdbcUtils;

public class UserDaoImp implements UserDao {

	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// 建立连接
			conn = JdbcUtils.getConnection();
			// 创建连接
			File file = new File("D:\\JavaWorkSpace\\JDBC\\src\\main\\resources\\AppLog_2017-01-09.txt");
			Reader reader = new BufferedReader(new FileReader(file));
			String sql = "INSERT INTO t_clob (Description) VALUES (?)";
			ps = conn.prepareStatement(sql);
			ps.setCharacterStream(1, reader, file.length());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RunTimeExcUser(e.getMessage(), e);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RunTimeExcUser(e.getMessage(), e);
		} finally {
			 
				JdbcUtils.free(null, ps, conn);
			 

		}

	}

	public User getUser(int userId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			// 建立连接
			conn = JdbcUtils.getConnection();
			// 创建连接
			String sql = "select USER_NAME,USER_PASSWORD,USER_EMAIL from t_user where USER_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = findUser(rs);

			}
		} catch (SQLException e) {
			throw new RunTimeExcUser(e.getMessage(), e);
		} finally {
			 
				JdbcUtils.free(rs, ps, conn);
			 

		}
		return user;
	}

	private User findUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("USER_NAME"));
		user.setUserpassword(rs.getString("USER_PASSWORD"));
		user.setUseremail(rs.getString("USER_EMAIL"));
		return user;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	public void download() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select Description from t_clob where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				InputStream in = rs.getBinaryStream(1);
				File file = new File("D:\\log_bak.txt");
				OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
				byte[] buff = new byte[1024];
				for(int i=0;(i=in.read(buff))>0;)
				{
					out.write(buff,0,i);
				}
				out.close();
			}
		} catch (SQLException e) { 
			throw new RunTimeExcUser(e.getMessage(), e);
		} catch (FileNotFoundException e) { 
			throw new RunTimeExcUser(e.getMessage(), e);
		} catch (IOException e) { 
			throw new RunTimeExcUser(e.getMessage(), e);
		}finally {
			 
				JdbcUtils.free(rs, ps, conn);
			 
		}

	}

}
