package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException {
		MemberVO memberVO= session.selectOne("Member-Mapper.selectMemberById", id);
		return memberVO;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException {
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList");
		return memberList;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getEndRowNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList",null,rowBounds);
		//여기서 selectList가 rowBounds(slectList 메서드의 기능) 가 데이터를 잘라서 준다. 다 받아주는게 아니라. 
		System.out.println(memberList);
		return memberList;
	}

}




