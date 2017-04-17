package com.Alex.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Alex.dao.UserDao;
import com.Alex.dao.imp.DaoFactory;
import com.Alex.dao.imp.UserDaoImp;
import com.Alex.domain.User;

/**
 * Servlet implementation class DaoTest
 */
public class DaoTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DaoTest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user = null;
		UserDao userdao = DaoFactory.getInstance().getuserDaoImp();
		user = userdao.getUser(1);
		//userdao.addUser(null);
		userdao.download();
		response.setCharacterEncoding("GBK");
		response.getWriter().append("Served at: ").append(user.getUserpassword());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
