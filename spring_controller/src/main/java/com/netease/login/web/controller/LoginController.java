package com.netease.login.web.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.netease.login.model.User;
import com.netease.login.service.LoginService;
import com.netease.login.utils.CookieUtil;
import com.netease.login.utils.KeyGenerator;
import com.netease.login.utils.StringUtil;
import com.netease.login.utils.TokenUserData;

@RequestMapping("/users")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void UserLogindoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String origUrl = req.getParameter("origUrl");
		req.setAttribute("origUrl", origUrl);

		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		System.out.println("login doGet want to login");

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, IOException, ServletException {
		String username = req.getParameter("name");
		String password = req.getParameter("password");
		String origUrl = req.getParameter("origUrl");
		User user = null;
		try {
			user = loginService.findUser(username, password);

			if (user != null) {

				// ���uid
				String token = KeyGenerator.generate();
				// ����uid
				TokenUserData.addToken(token, user);
				Cookie haslogin = new Cookie("token", token);
				haslogin.setMaxAge(1200);
				haslogin.setPath("/");
				haslogin.setHttpOnly(true);
				resp.addCookie(haslogin);
				System.out.println("check cookie");

				if (StringUtil.isEmpty(origUrl)) {
					origUrl = "login_success";
				} else {
					origUrl = URLDecoder.decode(origUrl, "utf-8");
				}
				req.setAttribute("user", username);
				// resp.sendRedirect(origUrl);
				req.getRequestDispatcher("/WEB-INF/view/loginsuccess.jsp").forward(req, resp);
				System.out.println("��һ�ε�¼����Ҫֱ�ӵ���jsp");

			} else {
				backToLoginPage(req, resp, user, origUrl, "���벻��ȷ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			backToLoginPage(req, resp, user, origUrl, "����ϵͳ����");
		}
	}

	private void backToLoginPage(HttpServletRequest req, HttpServletResponse resp, User user, String origUrl,
			String string) throws SQLException, IOException, ServletException {
		req.setAttribute("account", user);
		req.setAttribute("origUrl", origUrl);
		req.setAttribute("errInfo", string);

		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
	}

	@RequestMapping(value = "/logout")
	public void UserLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String token = CookieUtil.getCookie(req, "token");
		if (token != null) {
			TokenUserData.removeToken(token);
		}

		CookieUtil.removeCookie(resp, "token", "/", null);
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write("<p style='color:\"blue\"'>logout success</p>" + "<a href=\"./login\">��ҳ</a>");
	}

	@RequestMapping(value = "/login_success")
	public void UserLogSuccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean alreadylogin = false;
		String username = null;
		String cookiename = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			cookiename = cookie.getName();
			if ("token".equals(cookiename)) {
				String uid = cookie.getValue();
				User user = TokenUserData.validateToken(uid);
				System.out.println("user in success " + user);
				if (user != null) {
					username = user.getUserName();
					alreadylogin = true;
				}
			}
		}
		if (!alreadylogin) {
			response.sendRedirect(request.getContextPath() + "/login.html");
			System.out.println("please login");
			System.out.println("ֱ�ӷ����û�ҳ�棬����ʧ���ˡ�");
		} else {
			request.setAttribute("user", username);
			request.getRequestDispatcher("/WEB-INF/view/loginsuccess.jsp").forward(request, response);
			System.out.println("�û���֤ͨ����������߼�");
		}
	}

}
