package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.BoardVO;

public interface BoardService {
	
	//목록조회
	Map<String, Object> getBoardList(SearchCriteria cri)throws SQLException;
	
	//상세보기
	BoardVO getBoard(int bno)throws SQLException;
	
	//수정화면 상세
	BoardVO getBoardForModify(int bno) throws SQLException;
	
	//등록
	void regist(BoardVO board)throws SQLException;

	void modify(BoardVO board)throws SQLException;
	
	void remove(int bno)throws SQLException;
}
