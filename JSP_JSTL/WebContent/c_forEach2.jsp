<%@page import="java.util.ArrayList"%>
<%@page import="com.jsp.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<MemberVO> memberList = new ArrayList<MemberVO>();
	for(int i =1; i < 11; i++){
	MemberVO member = new MemberVO("mimi"+i, "mimi", "mimi@naver.com", "010-1234-1234");
		memberList.add(member);
	}
	pageContext.setAttribute("memberList",memberList);
%>

<%! //선언자. .java 안에 들어가서 class 안으로 들어간다.%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>아이디 : ${memberList[0] }</h1>
<!-- 	propertyNotFoundException: 호출된 er문에 내용이 읍스요. -->
<!-- get을 생략하고 나니까 할게 없다. 그래서 배열 표기법을 쓴다. [0]번째를 뽑는다. -->
<!-- 맵은? memberlist.key.key. -->
	<table border="1px solid">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이메일</th>
			<th>전화번호</th>
		</tr>
		<%--
			if(memberList!=null) for(MemberVO member : memberList){
				pageContext.setAttribute("member", member);
			el문은 null판단 안해	--%>
			<c:if test="${empty memberList }">
				<tr>
					<td colspan="4">해당 내용이 없습니다. </td>
				</tr>
			</c:if>
		<c:forEach items="${memberList }" var="member" >
				<tr>
					<td>${member.id }</td>
					<td>${member.pwd }</td>
					<td>${member.email }</td>
					<td>${member.phone }</td>
				</tr>
		</c:forEach>

	</table>
</body>
</html>





