<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="2kb" autoFlush="false"%>

<!--     <script>
    	alert("네이버로 이동합니다.");
    	location.href="https://www.naver.com";
    </script> -->
    
    
<% for(int i =0; i<50000; i++){%>
<span>안녕하세요</span>
<%}%>
<!-- 50000만번 넣었을때 터진다. buffer="2kb" autoFlush="false" 오류: JSP 버퍼 오버플로우 -->