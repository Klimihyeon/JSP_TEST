<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int k=5;
	pageContext.setAttribute("k", k);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(k>3){
			out.print("잘한다.");
		}
	%>
	
	<c:if test="${k>3 }">
		잘한다.
	</c:if>

</body>
</html>