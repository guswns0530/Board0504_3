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
		if(user != null) {
			HTMLUtil.sendBackMsg(out, "잘못된 접근입니다.");
		}
	%>
	<section>
            <div class="container mt-5">
                <div class="container p-5">
                <div class="title text-center mb-5">
                    <h1 class="fw-bolder">로그인</h1>
                </div>
                <form class="" method="POST" action="<%= request.getContextPath() %>/board/loginCheck" style="padding: 0 400px">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label fw-bolder">아이디</label>
                        <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                            placeholder="id" name="userId">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label fw-bolder">비밀번호</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="password" name="pwd">
                        <div id="emailHelp" class="form-text">공공시설에서 비밀번호 저장을 하지마세요.</div>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary py-2">로그인하기</button>
                    </div>
                    <div class="row">
                        <div class="col">
                            <hr>
                        </div>
                        <div class="col-md-1 text-center text-secondary">
                            or
                        </div>
                        <div class="col">
                            <hr>
                        </div>
                    </div>
                    <div class="d-grid">
                        <a href="<%= request.getContextPath() %>/board/register" type="submit" class="btn btn-outline-primary py-2">회원가입하기</a>
                    </div>
                </form>
            </div>
        </section>
	
	<%@ include file="../template/footer.jsp" %>
</body>
</html>