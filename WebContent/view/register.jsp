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
	<section class="mx-5">
            <div class="title text-center mb-5">
                <h1 class="fw-bolder">환영합니다!</h1>
                <p class="lead">가입하여서 사람들과 소통하세요</p>
            </div>
            <form class="px-5" method="post" action="<%= request.getContextPath()%>/board/registerCheck">
                <div class="mb-3">
                    <label for="id" class="form-label fw-bolder">아이디</label>
                    <input type="text" class="form-control" id="id" placeholder="id" name="userId">
                </div>
                <div class="mb-3">
                    <label for="pwd" class="form-label fw-bolder">비밀번호</label>
                    <input type="password" class="form-control" id="pwd" placeholder="password" name="pwd">
                    <div id="emailHelp" class="form-text">* 8자이상 20자 이하.</div>
                </div>
                <div class="mb-3">
                    <label for="pwdc" class="form-label fw-bolder">비밀번호 확인</label>
                    <input type="password" class="form-control" id="pwdc" placeholder="password" name="pwdc">
                    <div id="emailHelp" class="form-text">* 다시한번 입력해주세요</div>
                </div>
                <div class="row mb-5">
                    <div class="col">
                        <label for="name" class="form-label fw-bolder">이름</label>
                        <input type="text" class="form-control" id="name" placeholder="name" name="userName">
                        <div id="emailHelp" class="form-text">* 이름을 입력해주세요</div>
                    </div>
                    <div class="col">
                        <label for="nickname" class="form-label fw-bolder">닉네임</label>
                        <input type="text" class="form-control" id="nickname" placeholder="nickname" name="userNickname">
                        <div id="emailHelp" class="form-text">* 커뮤니티내에서 사용하실 이름을 입력해주세요</div>
                    </div>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary py-2">가입하기</button>
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
                    <a href="<%= request.getContextPath() %>/board/login" type="submit" class="btn btn-outline-primary py-2">로그인하기</a>
                </div>
            </form>
        </section>
	
	<%@ include file="../template/footer.jsp" %>
</body>
</html>