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
		if(user == null) {
			HTMLUtil.sendBackMsg(out, "로그인후 이용해주세요.");
		}
	%>
	<section class="mx-5">
            <div class="container mt-5 bg-light">
                <div class="card px-5 pt-5 pb-3">
                    <form action="<%= request.getContextPath() %>/board/writeCheck" method="POST">
                        <div class="card-body">
                            <div class="card-title">
                                <h3 class="fw-bold mb-4">글 등록하기</h3>
                                <div class="input-group mb-3">
                                    <div class="input-group-append">
                                        <span class="input-group-text"> 제목 </span>
                                    </div>
                                    <input type="text" class="form-control" name="title" placeholder="제목을 입력하세요">
                                </div>
                            </div>
        
                            <div style="background-color: #ebecef; height: 1px" class="my-4"></div>
                            <div class="input-group" style="height: 600px;">
                                <div class="input-group-prepend">
                                    <span class="input-group-text h-100">
                                        내용
                                    </span>
                                </div>
                                <textarea class="form-control" name="content" placeholder="내용을 입력하세요"></textarea>
                            </div>
                            <div class="row mt-5 mb-3">
                                <button type="submit" class="btn btn-outline-primary">글 등록</button>
                            </div>
                        </div>
                    </form>
                </div> <!-- end of card -->
            </div> <!-- end of container -->
        </section>
	
	<%@ include file="../template/footer.jsp" %>
</body>
</html>