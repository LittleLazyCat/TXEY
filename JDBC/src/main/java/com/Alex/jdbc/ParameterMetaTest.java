package com.Alex.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Alex.util.JdbcUtils;

/**
 * Servlet implementation class ParameterMetaTest
 */
public class ParameterMetaTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParameterMetaTest() {
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
		Object[] params = new Object[] { "123", "1" };
		StringBuffer sb = new StringBuffer();
		List list = new ArrayList();
		try {
			list = read("select * from t_user where USER_PASSWORD=? and USER_ID > ?", params);
			if (list.size() == 0) {
				sb.append("1");
			} else {
				
				Iterator it = list.iterator();
				int i=0;
				while (it.hasNext()&&i<6) {
					Map map = new HashMap();
					map = (Map) list.get(i);
					sb.append(map.get("id") + "<br>");
					sb.append(map.get("name") + "<br>");
					sb.append(map.get("psw") + "<br>");
					sb.append(map.get("email") + "<br>");
					sb.append("------------------------"+"<br>");
					i++;
				}

			}
			response.getWriter().append(sb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static List read(String sql, Object[] params) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map> list = new ArrayList<Map>();
		Map<String, Comparable> map = null;
		try {
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			// ParameterMetaData pmd = ps.getParameterMetaData();
			// int count = pmd.getParameterCount();
			for (int i = 1; i <= params.length; i++) {
				// System.out.print(pmd.getParameterClassName(i) + "\t");
				// System.out.print(pmd.getParameterType(i) + "\t");
				// System.out.println(pmd.getParameterTypeName(i));
				ps.setObject(i, params[i - 1]);
			}

			rs = ps.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Comparable>();
				map.put("id", rs.getInt("USER_ID"));
				map.put("name", rs.getString("USER_NAME"));
				map.put("psw", rs.getString("USER_PASSWORD"));
				map.put("email", rs.getString("USER_EMAIL"));
				list.add(map);
			}
			return list;

		} finally {

			JdbcUtils.free(rs, ps, conn);

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
