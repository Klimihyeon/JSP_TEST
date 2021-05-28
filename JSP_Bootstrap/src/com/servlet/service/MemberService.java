package com.servlet.service;

import java.sql.SQLException;
import java.util.List;

import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

public interface MemberService {
	public MemberVO login(String id, String pwd) throws NotFoundIDException, InvalidPasswordException, SQLException;
	public MemberVO MemberDetail(String id) throws NotFoundIDException, InvalidPasswordException, SQLException;
	public List<MemberVO> allMemberList() throws SQLException;
	public int join(MemberVO vo) throws SQLException;
	public int	updateMember(MemberVO vo) throws NotFoundIDException, SQLException;
	public int	deleteMember(String id, String pass) throws NotFoundIDException, SQLException, InvalidPasswordException;
	public int countAllMembers()throws SQLException;
}
