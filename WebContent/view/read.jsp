<%@page import="vo.CommentVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="vo.BoardVO"%>
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
<title>Board</title>
</head>

<body>
	<%@ include file="../template/header.jsp" %>
	<%
		BoardVO boardVO = (BoardVO) request.getAttribute("boardVO");
		UserVO userVO = (UserVO) request.getAttribute("userVO");
		ArrayList<CommentVO> commentList = (ArrayList<CommentVO>) request.getAttribute("commentList");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String writeDate = sdf.format(new Date(boardVO.getWriteDate().getTime()));
	%>
	<section class="mx-5">
            <div class="container mt-5 bg-light">
                <div class="card px-5 pt-5 pb-3">
                    <div class="card-body">
                        <div class="card-title">
                            <h4><%= boardVO.getTitle() %></h4>
                        </div>
                        <div class="d-flex align-items-center">
                            <div class="d-flex align-items-center p-1">
                                <img class="rounded-circle border border-secondary" src="<%= request.getContextPath() %>/img/profile.png" alt="" style="width: 26px; height:26px;">
                                <div class="nickname text-secondary text-center ms-2 h-auto" style="line-height: 20px; font-size: 16px">
                                	<%= userVO.getUserNickname() %>
                                </div>
                            </div>
                            <div class="text-secondary text-center ms-3" style="font-size: 14px"><%= writeDate %></div>
                        </div>
                        <div style="background-color: #ebecef; height: 1px" class="my-4"></div>
                        <div class="card-text" style="white-space: break-spaces;"><%= boardVO.getContent() %></div>
                        <div class="d-flex mt-3 justify-content-end">
                            <% if ( user != null && userVO.getUserId().equals(user.getUserId())) { %>
                                <a href="<%= request.getContextPath() %>/board/boardUpdate?id=<%= boardVO.getBoardId() %>" class="btn btn-outline-success me-2">수정</a>
                                <a href="<%= request.getContextPath() %>/board/boardDelete?id=<%= boardVO.getBoardId() %>" class="btn btn-outline-danger">삭제</a>
                            <% } %>
                        </div>
                        
                        <%
                        	if ( user != null ) {
                        %>
                        <div class="card-footer mt-4">
                            <form action="<%= request.getContextPath() %>/board/commentInsert" method="POST" style="display: flex;">
                            	<input type="hidden" name="boardId" value="<%= boardVO.getBoardId() %>">
                                <input type="text" class="form-control" name="content">
                                <button style="border: none;">
                                    <span class="input-group-text h-100">등록</span>
                                </button>
                            </form>
                        </div>
                        
                        <%
                        	}
                        %>
                        
                        <% for(CommentVO vo : commentList ) { %>
                        <div class="p-3 card-footer" style="border-radius: 10px; margin-top: 15px;">
                            <div class="d-flex align-items-center p-1">
                                <img class="rounded-circle border border-secondary" src="<%= request.getContextPath() %>/img/profile.png" alt="" style="width: 26px; height:26px;">
                                <div class="nickname text-secondary text-center ms-2 h-auto" style="line-height: 20px; font-size: 16px">
                                	<%= vo.getUserVO().getUserNickname() %>
                                </div>
                            </div>
                            <div>
                            	<%= vo.getContent()%>
                            </div>
                            <div class="text-secondary text-end ms-3" style="font-size: 14px;"><%= sdf.format(new Date(vo.getWriteDate().getTime())) %></div>
                        </div>
                        
                        <% } %>
                    </div>
                </div>
            </div>
        </section>
	
	<%@ include file="../template/footer.jsp" %>
</body>
</html>