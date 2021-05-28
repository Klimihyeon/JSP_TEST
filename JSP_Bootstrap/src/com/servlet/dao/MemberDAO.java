package com.servlet.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;

public interface MemberDAO {
	
	public MemberVO selectMemeberById(SqlMapClient smc, String id)throws SQLException;
	public List<MemberVO> selectAllMemberList(SqlMapClient smc) throws SQLException;
	public int insertMemberById(SqlMapClient smc, MemberVO vo)throws SQLException;
	public int updateMemberById(SqlMapClient smc, MemberVO vo)throws SQLException;
	public int deleteMemberById(SqlMapClient smc, String id)throws SQLException;
	public int countAllMembers(SqlMapClient smc)throws SQLException;
	
}
