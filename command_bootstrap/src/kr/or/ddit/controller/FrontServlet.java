package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.handler.Handler;


public class FrontServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//사용자 URI 검출
		
		String command = request.getRequestURI(); //contextPath 포함.
		if(command.indexOf(request.getContextPath())==0) {//contextPath 삭제
			command = command.substring(request.getContextPath().length());
		}
		
/*		//로그인 확인 이렇게 만들면 이걸 들어낼 수가 없다. 여기서 하는거 맞냐. >>> 필터로 간다.
		if(!command.contains("login")) {
			HttpSession session = request.getSession();
			MemberVO member= (MemberVO)session.getAttribute("loginUser");
			if(member==null) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 필수')");
				out.println("location.href='/'");
				out.println("</script>");
				return;
			}
		}
*/		
		
		//commandHandler 실행(HandlerMapper 의뢰 handler 할당)
		Handler handler = null;
		String view = null;
		
		if(handlerMapper != null) {
			handler = handlerMapper.getHandler(command);
			if(handler!=null) {//올바른 요청
				try {
					view = handler.process(request, response);
					
					if(view !=null) ViewResolver.view(request, response, view);
				}catch(Exception e){
					e.printStackTrace();
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				}
				
			}else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);//404er
			}
		}else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);//500er
		}
	}

	private HandlerMapper handlerMapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String handlerMapperType = config.getInitParameter("handlerMapper");

		try {
			this.handlerMapper = (HandlerMapper) injectionBean(handlerMapperType);
			System.out.println("[FrontServlet] handlerMapper 가 준비되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[FrontServlet] handlerMapper 가 준비되지 않았습니다.");
		}
	}
	
	private Object injectionBean(String classType) throws Exception {
		Class<?> cls = Class.forName(classType);
		return cls.newInstance();
	}
	
	

}