<%@page import="java.util.Optional"%>
<%@page import="vo.UserVO"%>
<%@page import="util.HTMLUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 세션 세팅
	UserVO user = (UserVO) session.getAttribute("user");
	
	// 메시지
	String msg = (String)session.getAttribute("msg");

	if(msg != null) {
		session.removeAttribute("msg");
		HTMLUtil.sendMsg(out, msg);
	}
%>
<style>


body {
	padding-top: 4.5rem;
}
</style>

<div class="container">
	<nav class="navbar navbar-expand-md navbar-light fixed-top bg-light">
		<div class="container">
			<a class="navbar-brand" href="<%= request.getContextPath() %>/">게시판 만들기</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%= request.getContextPath() %>/board/board">게시판</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%= request.getContextPath() %>/board/write">글쓰기</a></li>
					<li class="nav-item"><a class="nav-link" title="미구현">회원목록</a>
					</li>
				</ul>
				<?php if(isset($_SESSION['user'])) : ?>
				<% if(user != null) { %>
				<form class="d-flex">
					<a href="#" class="btn btn-outline-success" type="submit"> <%= user.getUserNickname() %>
					</a> <a href="<%= request.getContextPath() %>/board/logout"
						class="btn btn-danger ms-3" type="submit">로그아웃</a>
				</form>
				<% } else { %>
				<form class="d-flex">
					<a href="<%= request.getContextPath() %>/board/login" class="btn btn-outline-success"
						type="submit">Login</a> <a href="<%= request.getContextPath() %>/board/register"
						class="btn btn-outline-warning ms-3" type="submit">Register</a>
				</form>
				<% } %>
			</div>
		</div>
	</nav>