package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;
import com.servlet.view.HTMLView;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HTMLView.LoginView(resp);
		String view = "/WEB-INF/views/login.jsp";
		
		req.getRequestDispatcher(view).forward(req, resp);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//화면 url
		String view = "WEB-INF/views/login_success.jsp";
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		String script="";
		try {
			MemberVO memberVO =	memberService.login(id, pwd);
			script ="alert('로그인 성공');"
						+ "location.href='" + req.getContextPath() + "/main';";
			
		} catch (NotFoundIDException e) {
			script ="alert('" + e.getMessage() + "');" + "history.go(-1);";
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			script ="alert('" + e.getMessage() + "');" + "history.go(-1);";
			e.printStackTrace();
		} catch (SQLException e) {
			script = "alert('서버장애 불가');" + "history.go(-1);";
			e.printStackTrace();
		}
//		ListServlet list = new ListServlet();
//		list.doPost(req, resp);

		req.setAttribute("script", script);
		req.getRequestDispatcher(view).forward(req, resp);
	
	}
}
