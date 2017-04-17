package com.Alex.jdbc;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Alex.util.JdbcUtils;

/**
 * Servlet implementation class DBMD
 */
public class DBMD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBMD() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.sql.Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			DatabaseMetaData dbmd = conn.getMetaData();
			StringBuffer md = new StringBuffer();
			md.append("db name: ");
			md.append(dbmd.getDatabaseProductName()+"<br>");
			md.append("tx: ");
			md.append(dbmd.supportsTransactions());
			response.getWriter().println(md.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			JdbcUtils.free(null, null, conn);
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
