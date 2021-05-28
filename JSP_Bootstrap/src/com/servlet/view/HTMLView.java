package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;

public class HTMLView {

	public static void Html(HttpServletResponse res
			, String title, String body) throws IOException, ServletException {
			Html(res, title, body,null,null);
		
	}
	
	public static void Html(HttpServletResponse res
			, String css) throws IOException, ServletException {
		Html(res, null,null,css,null);
		
	}
	
	
	public static void Html(HttpServletResponse res
			, String title, String body, String css
			, String script) throws IOException, ServletException {
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out= res.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("<style>" + css + "</style>");
		out.println("<script>" + script + "</script>");
		out.println("</head>");
		out.println("<body>" + body +  "</body>");
		out.println("</html>");
	
	}
	public static void LoginView(HttpServletResponse res) throws IOException, ServletException{
		String body = null;
		
		body = "<form action='' method='post'>"
				+ "Id:<input type='text' name ='id' />" + "<br/>"
				+ "pass:<input type='text' name ='pwd' />" + "<br/>"
				+ "로그인:<input type='submit' />"
				+ "<a herf='servlet_default/JoinView>" 
				+ "</a>"
				+ "</form>";
		
		Html(res,"로그인",body,null,null);
	}
	public static void JoinView(HttpServletResponse res) throws IOException, ServletException{
		String body = null;
		
		body = "<form action='' method='post'>"
				+ "Id:<input type='text' name ='id' />" + "<br/>"
				+ "pass:<input type='text' name ='pass' />" + "<br/>"
				+ "name:<input type='text' name ='name' />" + "<br/>"
				+ "tel:<input type='text' name ='tel' />" + "<br/>"
				+ "E-mail:<input type='text' name ='mail' />" + "<br/>"
				+ "회원가입하기:<input type='submit' />"
				+ "</form>";
		
		Html(res,"로그인",body,null,null);
	}
	public static void MainView(HttpServletResponse res, List<MemberVO> memberList) throws IOException, ServletException{
		String body = null;
			
		String str ="<table border='1px solid'>";
			str += "<tr><th>id</th>";
			str += "<th>name</th>";
			str += "<th>tel</th>";
			str += "<th>mail</th>";
			str += "</tr>";
		for(MemberVO memlist : memberList) {
			str += "<tr><td>" +  memlist.getId()   +"</td>";
			str += "<td>" +  memlist.getName() +"</td>";
			str += "<td>" +  memlist.getTel()  +"</td>";
			str += "<td>" +  memlist.getMail() +"</td></tr>";
		}
		str += "</table>";
		
		String button = "<a href='insert'>insert</a>";
		String button2 = "<a href='update'>update</a>";
		String button3 = "<a href='delete'>delete</a>";
		
		body = "<form method='post'>"
				+ "로그인 완료, list 출력"
				+ "<table>"
				+ str
				+ "</table>"
				+ button
				+ button2
				+ button3
				+ "</form>";
		
		Html(res,"로그인",body,null,null);
	}
	public static void updateView(HttpServletResponse res, String id) throws IOException, ServletException{
		String body = null;
		
		body = "<form action='' method='post'>"
				+ id + "<br/>"
				+ "pass:<input type='text' name ='pass' />" + "<br/>"
				+ "name:<input type='text' name ='name' />" + "<br/>"
				+ "tel:<input type='text' name ='tel' />" + "<br/>"
				+ "E-mail:<input type='text' name ='mail' />" + "<br/>"
				+ "회원정보수정하기:<input type='submit' />"
				+ "</form>";
		
		Html(res,"로그인",body,null,null);
	}
	public static void deleteView(HttpServletResponse res) throws IOException, ServletException{
		String body = null;
		
		body = "<form action='' method='post'>"
				+ "삭제할 아이디와 비밀번호를 입력하세요." + "<br/>"
				+ "Id:<input type='text' name ='id' />" + "<br/>"
				+ "pass:<input type='text' name ='pwd' />" + "<br/>"
				+ "로그인:<input type='submit' />"
				+ "<a herf='servlet_default/JoinView>" 
				+ "</a>"
				+ "</form>";
		
		Html(res,"로그인",body,null,null);
	}
}
