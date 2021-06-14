package kr.or.ddit.handler.reply;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.controller.JSONResolver;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ReplyService;

public class ReplyListRestHandler implements Handler {

	private ReplyService reflyService;
	public void setReplyService(ReplyService reflyService) {
		this.reflyService = reflyService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		
		Map<String, Object> dataMap = reflyService.getReplyList(pno, cri);
		
		JSONResolver.view(response, dataMap);
		
		return url;
	}

}
