<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	<c:if test="${empty loginUser}">
		window.onener.parent.location.href="/";
		window.close();
	</c:if>

	<c:if test="${!empty loginUser}">
		location.href="detail.do?id=${member.id}";
	</c:if>
</script>