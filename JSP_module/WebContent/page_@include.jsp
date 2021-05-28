<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

		<%@ include file="/WEB-INF/views/include/style.jsp" %>

</head>


<% request.setAttribute("msg","from page"); %>
<% String msg="local variable"; %>
<body>
	<header>
		<%@ include file="/WEB-INF/views/include/header.jsp" %>
	</header>
	<div id="content-wrap">
		<aside>
			<%@ include file="/WEB-INF/views/include/aside.jsp" %>
		</aside>
		<section>
			<h1>section</h1>
		</section>
	</div>
	<footer>
			<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	</footer>
</body>
</html>