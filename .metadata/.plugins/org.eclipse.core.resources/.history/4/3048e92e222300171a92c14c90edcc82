package com.Alex.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Alex.dao.ex.RunTimeExcUser;

public final class JdbcUtils {

	private static String url = "jdbc:mysql://localhost:3306/test";
	private static String user = "root";
	private static String password = "root";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void free(ResultSet rs, Statement st, Connection conn){
		try {
			if (rs != null) {
				rs.close();
			}
		}catch (SQLException e) {
			// TODO: handle exception
			throw new RunTimeExcUser(e.getMessage(), e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			}catch (SQLException e) {
				// TODO: handle exception
				throw new RunTimeExcUser(e.getMessage(), e);
			} finally {
				try {
					if (conn != null) {
					conn.close();
				}
				} catch (SQLException e) {
					// TODO: handle exception
					throw new RunTimeExcUser(e.getMessage(), e);
				}
				

			}
		}
	}
}
