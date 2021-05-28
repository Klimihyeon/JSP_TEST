package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	
	   private static MemberDAO memDao;
	   
	   private MemberDAOImpl() {
		   
	   }
	   
	   public static MemberDAO getInstance() {
		   if(memDao == null) {
			   memDao = new MemberDAOImpl();
		   }
		   
		   return memDao;
	   }
	   
	@Override
	public MemberVO selectMemeberById(SqlMapClient smc, String id) throws SQLException {
		MemberVO memberVO = (MemberVO) smc.queryForObject("member.selectMemeberById",id);
		
		System.out.println(memberVO);
		return memberVO;
	}

	@Override
	public List<MemberVO> selectAllMemberList(SqlMapClient smc) throws SQLException {

		 List<MemberVO> memList = smc.queryForList("member.selectAllMemberList");
		
		return memList;
	}

	@Override
	public int insertMemberById(SqlMapClient smc, MemberVO vo) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("member.insertMemberById", vo);
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int updateMemberById(SqlMapClient smc, MemberVO vo) throws SQLException {
		
		int cnt = smc.update("member.updateMemberById", vo);
		
		return cnt;
	}

	@Override
	public int deleteMemberById(SqlMapClient smc, String id) throws SQLException {
		int cnt = smc.delete("member.deleteMemberById", id);
		
		return cnt;
	}

	@Override
	public int countAllMembers(SqlMapClient smc) throws SQLException {
		int cnt = (int) smc.queryForObject("member.countAllMemebers");
		return cnt;
	}

}
