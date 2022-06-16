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
	<%@ include file="./template/header.jsp" %>
	<section>
		<main class="container mt-4">
			<div class="bg-light p-5 rounded">
				<h1>게시판</h1>
				<p class="lead">안녕하세요 게시판 사이트 입니다.</p>
				<hr class="my-4">
				<p>사람들과 자유롭게 소통해보세요</p>
				<a class="btn btn-lg btn-primary" href="/view/board.php"
					role="button"> 게시물 보러가기 >></a>
			</div>
		</main>
	</section>
	
	<%@ include file="./template/footer.jsp" %>
</body>
</html>