package kr.or.ddit.handler.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberListHandler implements Handler {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="member/list";
		//Front에서 처리하기로 했으니까 이렇게.
		
		
		List<MemberVO> memberList = memberService.getMemberList();
		//FrontServlet에서 exception이 나와도 던지는 것을 확인했으니까 이것도 똑같이 던져버린다.
		
		
		
		request.setAttribute("memberList", memberList);
		
		return url;
		
	}

}
