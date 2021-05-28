package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/insert")
public class InsertServlet extends HttpServlet{
	
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url ="/WEB-INF/views/Insert.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setMail(mail);
		vo.setName(name);
		vo.setPass(pass);
		vo.setTel(tel);
		
		
		
		try {
			int join =	memberService.join(vo);
			if(join > 0) {
				List<MemberVO> memberList = new ArrayList<>();
				
				try {
					memberList = memberService.allMemberList();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				req.setAttribute("memberList", memberList);
				String url ="/WEB-INF/views/list.jsp";
				req.getRequestDispatcher(url).forward(req, resp);
			}else {
				String err= "";
				req.setAttribute("err", err);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	
	}
}
