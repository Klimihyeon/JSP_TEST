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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
	
	private MemberService memberService = new MemberServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url ="/WEB-INF/views/Update.jsp";
		req.getRequestDispatcher(url).forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPass(pass);
		memberVO.setName(name);
		memberVO.setTel(tel);
		memberVO.setMail(mail);
		try {
			int update = memberService.updateMember(memberVO);
			if(update > 0) {
				String url ="/WEB-INF/views/list.jsp";
				req.setAttribute("memberVO", memberVO);
				List<MemberVO> memberList = new ArrayList<>();
				
				try {
					memberList = memberService.allMemberList();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				req.setAttribute("memberList", memberList);
				req.getRequestDispatcher(url).forward(req, resp);
			}else {
				System.out.println("업뎃 에러");
				String url ="/WEB-INF/views/list.jsp";
				req.getRequestDispatcher(url).forward(req, resp);
			}
		} catch (NotFoundIDException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
