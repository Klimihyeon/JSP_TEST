<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>

<script>
	alert("회원등록에 성공했습니다.\n 회원리스트 페이지로 이동합니다.");
	
	window.onload=function(){
		$.ajax({
			url:"/getMCode.do?mName=회원목록"
			,type:"get"
			,success: function(menu){
				window.opener.parent.location.href="/index.do?mCode="+ menu.mcode;
				window.close();
				
			}
			,error: function(error){

			}
		});
	}
</script>
</body>