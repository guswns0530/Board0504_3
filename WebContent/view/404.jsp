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
<title>404 not found</title>
</head>

<body>
	<%@ include file="../template/header.jsp" %>
	<section>
		<main class="container mt-4">
			<div class="bg-light p-5 rounded">
				<h1>404 ERROR</h1>
				<p class="lead">페이지를 찾을수 없습니다.</p>
				<hr class="my-4">
				<a class="btn btn-lg btn-primary" href="<%= request.getContextPath() %>/"
					role="button"> 메인화면으로 이동 >></a>
			</div>
		</main>
	</section>
	
	<%@ include file="../template/footer.jsp" %>
</body>
</html>