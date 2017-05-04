package com.Alex.jdbc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Alex.dao.ex.RunTimeExcUser;
import com.Alex.util.JdbcUtils;

public class Crud{

	static void create() throws SQLException, FileNotFoundException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtils.getConnection();
			File file = new File("img_03.jpg");
			Reader reader = new BufferedReader(new FileReader(file));
			String sql = "INSERT INTO t_clob (Description) VALUES (?)";
			ps = conn.prepareStatement(sql);
			ps.setCharacterStream(1, reader,file.length());
			ps.executeUpdate();
		}
		finally{
			JdbcUtils.free(null, ps, conn);
		}
		
	}
	static void read() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ��������
			conn = JdbcUtils.getConnection();
			// ��������
			String sql = "select USER_NAME,USER_PASSWORD from t_user where USER_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("USER_NAME") + "\t" + rs.getString("USER_PASSWORD"));
			}
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}
	
	static void update() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "update t_user set USER_EMAIL = ? where USER_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "123@qq.com");
			ps.setInt(2, 10);
			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			throw new RunTimeExcUser(e.getMessage(), e);
		}
		finally {
			JdbcUtils.free(null, ps, conn);
		}
	}
}
