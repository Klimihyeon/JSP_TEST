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
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;
import com.servlet.view.HTMLView;

@WebServlet("/list")
public class ListServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url ="/WEB-INF/views/list.jsp";
		List<MemberVO> memberList = new ArrayList<>();
		int cnt =0;
		try {
			memberList = memberService.allMemberList();
			cnt = (int)memberService.countAllMembers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("memberList", memberList);
		req.setAttribute("memberCounts", cnt);
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
