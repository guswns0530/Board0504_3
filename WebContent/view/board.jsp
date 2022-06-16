<%@page import="util.PagiNation"%>
<%@page import="vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="./style/app.css">
<script type="module" src="<%= request.getContextPath()%>/script/app.js"></script>
<title>Board</title>
</head>

<body>
	<%@ include file="../template/header.jsp" %>
	<%
		ArrayList<BoardVO> list = (ArrayList<BoardVO>) request.getAttribute("list");
	
		PagiNation pn = (PagiNation) request.getAttribute("pagination");
	%>
	<section class="mx-5">
            <div class="container mt-5 px-5 bg-lighter">
                <section class="px-5">
                    <header class="d-flex  justify-content-between mb-4">
                        <div id="header" class="d-flex align-items-end">
                            <h3 class="fw-bolder" style="margin-bottom: 3px">전체글</h3>
                                <div class="lead ms-2 fs-5"><%= pn.getLength() %>건</div>
                        </div>
                        <form action="" method="GET">
                            <div class="row">
                                <form action="<%= request.getContextPath() %>/board/board" method="post">
                                    <input type="text" class="form-control col" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="검색어를 입력하세요" name="query">
                                    <button class="btn btn-primary col-md-3" type="submit">입력</button>
                                </form>
                            </div>
                        </form>
                    </header>
                    <div class="list">
                        <div class="row">
                            <% for(BoardVO boardVO : list) {
                            	UserVO userVO = boardVO.getUserVO();
                            %>
                                <div class="col-md-6">
                                    <div class="card p-2 mb-3">
                                        <div class="card-body">
                                            <h5 class="card-title w-100">
                                                <a href="<%= request.getContextPath() %>/board/read?id=<%= boardVO.getBoardId() %>" class="text-decoration-none text-dark text-nowrap w-100 overflow-hidden" style="display: inline-block;">
                                                    <%= boardVO.getTitle() %>
                                                </a>
                                            </h5>
                                            <p class="card-text text-secondary overflow-hidden" style="max-height: 48px; height: 48px;">
                                                <%= boardVO.getContent() %>
                                            </p>
                                            <div class="d-flex align-items-center">
                                                <div class="d-flex align-items-center p-1">
                                                    <img class="rounded border border-secondary" src="<%= request.getContextPath() %>/img/profile.png" alt="" style="width: 24px; height:24px;">
                                                    <div class="nickname text-secondary text-center ms-2 h-auto" style="line-height: 20px; font-size: 16px">
                                                        <%= userVO.getUserNickname() %>
                                                    </div>
                                                </div>
                                               	<div class="text-secondary text-center ms-3" style="font-size: 14px"><%= boardVO.getWriteDate() %></div>
                                            </div>
                                        </div>
                                    </div> <!-- card-end-->
                                </div> <!-- col-end-->
                            <% } %>
                        </div> <!-- row-end -->
                    </div> <!-- list-end -->
                    <div class="d-flex justify-content-center mt-4">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item <%= pn.isPrev() ? "" : "disabled" %>"><a class="page-link btn btn-primary" href="<%= request.getContextPath() %>/board/board?page=<%= (int)Math.ceil(pn.getPage() / 10.0) * 10 - 10 %>">이전</a></li> <!-- disabled -->
        
        						<% for(int i = pn.getPageStart(); i <= pn.getPageLast(); i++) { %>
                                   <li class="page-item <%= pn.getPage() == i  ? "active" : "" %>" ><a class="page-link" href="<%= request.getContextPath() %>/board/board?page=<%= i %>"><%= i %></a></li>
        						<% } %>
        						
                                <li class="page-item <%= pn.isNext() ? "" : "disabled" %>"><a class="page-link" href="<%= request.getContextPath() %>/board/board?page=<%= pn.getPageStart() + 10 %>">다음</a></li> 
                            </ul>
                        </nav>
                    </div> <!-- page navigaion -->
                </section>
            </div>
        </section>
	
	<%@ include file="../template/footer.jsp" %>
</body>
</html>