
package kr.or.ddit.handler.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberListSearchPageHandler implements Handler {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url="member/list";
		
		String pageParam = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType =  request.getParameter("searchType");
		String keyword =  request.getParameter("keyword");
		
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(pageParam);
		cri.setPerPageNum(perPageNum);
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		
		Map<String, Object> dataMap = memberService.getMemberList(cri);
		
		request.setAttribute("memberList", dataMap.get("memberList"));
		request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		//cri를 다시 넣어줘야 한다. 페이지 상태를 유지하기 위한 인자다.
		return url;
		
	}

}
