<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head></head>

<title>회원 목록</title>

<body>
 <!-- Main content -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row md-2">
				<div class="col-sm-6">
					<h1>회원목록</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="list.do"> <i
								class="fa fa-dashboard"></i>회원관리
						</a></li>
						<li class="breadcrumb-item active">목록</li>
					</ol>
				</div>
			</div>
		</div>
	</section>

	<!-- Main content -->
   <section class="content">
		<div class="card">
			<div class="card-header with-border">
				<div id="keyword" class="card-tools" style="width: 550px;">
					<div class="input-group row">
						<!-- sort num -->
						<select class="form-control col-md-3" name="perPageNum"
							id="perPageNum" onchange="list_go()">
							<option value="10">정렬개수</option>
							<option value="2">2개씩</option>
							<option value="3">3개씩</option>
							<option value="5">5개씩</option>
						</select>
					</div>
				</div>
			</div>
			<div class="card-body" style="text-align: center;">
				<div class="row">
					<div class="col-sm-12">
						<table class="table table=bordered">
							<tr>
								<th>아이디</th>
								<th>패스워드</th>
								<th>이메일</th>
								<th>전화번호</th>
								<th>등록날짜</th>
								<!-- yyyy-MM-dd -->
							</tr>
							<c:forEach var="member" items="${memberList}">
								<tr>
									<td>${member.id }</td>
									<td>${member.pwd }</td>
									<td>${member.email }</td>
									<td>${member.phone }</td>
									<td><fmt:formatDate value="${member.regdate }"
											pattern="yyyy-MM-dd" /></td>
								</tr>

							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<form id="jobForm">
		<input type="hidden" name="page" value="" />
		<input type="hidden" name="perPageNum" value="" />
	</form>
	
	<script>
		function list_go(){
			//alert($('select#perPageNum').val());
 			 $('input[name="perPageNum"]').val($('select#perPageNum').val());
			//alert($('input[name="perPageNum"]').val($('select#perPageNum').val());
			$('form#jobForm').attr({
				action:'list.do',
				method:'get'
			}).submit(); 
		}
	</script>
</body>