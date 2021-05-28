package com.servlet.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dao.MemberDAO;
import com.servlet.dao.MemberDAOImpl;
import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;
import com.servlet.util.SqlMapClientUtil;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO = MemberDAOImpl.getInstance();
	// getInstance 역할이 정확히 뭔지 모르겠다.?
	private SqlMapClient smc = SqlMapClientUtil.getInstance();
	
	@Override
	public MemberVO login(String id, String pwd) throws NotFoundIDException, InvalidPasswordException, SQLException {
		MemberVO member = null;
		try {
			member = memberDAO.selectMemeberById(smc, id);			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if(member!=null) {
			if(pwd.equals(member.getPass())) {
				
				return member;
			}else {
				throw new InvalidPasswordException();
			}
		}else {
			throw new NotFoundIDException();
		}
		
		
	}
	
	@Override
	public List<MemberVO> allMemberList() throws SQLException {
		List<MemberVO> memberList = null;
		try {
			memberList = memberDAO.selectAllMemberList(smc);
			return memberList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public int join(MemberVO vo) throws SQLException {
		int success = 0;
		try {
			success = memberDAO.insertMemberById(smc, vo);
			return success;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	@Override
	public int updateMember(MemberVO vo) throws NotFoundIDException, SQLException {
		int success = 0;
		try {
			success = memberDAO.updateMemberById(smc, vo);
			return success;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public int deleteMember(String id, String pass) throws NotFoundIDException, SQLException, InvalidPasswordException {
		MemberVO member = null;
		int success = 0;
		try {
			member = memberDAO.selectMemeberById(smc, id);			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if(member!=null) {
			if(pass.equals(member.getPass())) {
				try {
					success = memberDAO.deleteMemberById(smc, id);
					return success;
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
			}else {
				throw new InvalidPasswordException();
			}
		}else {
			throw new NotFoundIDException();
		}
		

	}

	@Override
	public MemberVO MemberDetail(String id) throws NotFoundIDException, InvalidPasswordException, SQLException {
		MemberVO member = null;
		try {
			member = memberDAO.selectMemeberById(smc, id);			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		if(member!=null) {
			return member;
		}else {
			throw new NotFoundIDException();
		}
		
	}

	@Override
	public int countAllMembers() throws SQLException {
		int cnt = 0;
		try {
			cnt = memberDAO.countAllMembers(smc);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if(cnt!=0) {
			return cnt;
		}else {
			throw new SQLException();
		}
		
	}

}
