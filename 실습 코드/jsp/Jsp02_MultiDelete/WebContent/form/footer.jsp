<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	
	a{
		text-decoration : none;
	}
	footer{
		background-color : skyblue;
		height : 50px;
		text-align : center;
		line-height : 50px;
	}
</style>
<body>
		<!--  ./boardlist.jsp를 쓰면 form폴더안에 boardlist를 찾기때문에 404에러 뜸. -->
		<!-- 점 1개면 header랑 같은 위치를 검색
			점2개면 상위폴더로 올라가서 같은 위치 검색
		 -->
	<footer>KH정보교육원 &copy; all rights reserved...</footer>
</body>
</html>