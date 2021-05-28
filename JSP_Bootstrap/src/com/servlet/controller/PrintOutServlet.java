package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintOutServlet
 */
@WebServlet("/print.html")
public class PrintOutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//System.out.print("hello");
	
//		Scanner scan = new Scanner(System.in);
		
		String bg = request.getParameter("bg");
		String color = request.getParameter("color");
		String message = request.getParameter("message");
		
		//헤더를 세팅하고 아웃을 가져와야지 아웃 먼저 가져오고 세팅해봤자 소용없다.
		response.setContentType("text/html;charset=utf-8");
		//text/plain하고 주지 말고 /html으로 준다. 마크업을 찍어주겠다는 이야기다.
//		response.setContentType("application/octttt;charset=utf-8");
		//뭔지 모르겠으면 다운로드해버린다.
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>연습</title>");
		out.printf("<style>");
		out.println("body{background:"+bg+"}");
		out.println("body{color:"+color+"}");
		out.println("</style>");
		out.printf("<h1>%s</h1>", message);
		out.println("</body>");
		out.println("</html>");
		//출력처가 바뀐다. 콘솔 >>> 요청한 브라우저.
		//이때 서버는 기다린다. response 를 기다린다.
		//아무것도 못하고 기다려야되는 상황.
		//그래서 대용량 파일은 절대로 서브밋 방식으로 보내면 안된다. 무조건 비동기방식
		
		//uri는 print.html로 보일것이다. 그러나, 아니다. html을 보고 있지 않다.
	}

}

