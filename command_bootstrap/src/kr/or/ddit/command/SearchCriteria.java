package kr.or.ddit.command;

public class SearchCriteria extends Criteria {
	private String searchType=""; //검색구분
	private String keyword=""; //검색어
	//빈스트링을 안주면 리스트가 딱 열때 아무것도 없다. 이거 받아서 처음에 안 심어주면 nullpoint로 xml까지 다 간다. 빈스트링을 준다.
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
