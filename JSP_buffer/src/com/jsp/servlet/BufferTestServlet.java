package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BufferTestServlet
 */
@WebServlet("/out")
public class BufferTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="/WEB-INF/views/out.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
		//이렇게 하면 똑같은 효과가 난다. (jsp에는 alert만 줬다)
		
		/*
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		for(int i=0; i<100; i++) {
			out.println("<h3>안녕하세요</h3>");
		}
		
		//new Scanner(System.in).nextLine();
		//버퍼에는 담겨있는데 안뜬다.
		out.println("<script>alert('네이버로 이동합니다.');"
		+ "location.href='https://www.naver.com';" //jsp가 이렇게 하도록 만들어야한다.
		+"</script>");
		//...1) response.sendRedirect("https://www.naver.com");
		//리다이렉트 때리면 버퍼를 안읽고 버린다. 그래서 알람이 안뜬다.
*/		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
