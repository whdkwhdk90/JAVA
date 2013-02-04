<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %> 
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.el.score.Score" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//이게 생략되어있음.
	Score score = (Score)request.getAttribute("score");
%>
<body>
	<h1>EL Page</h1>
	<table border="1">
		<tr>
			<th colspan="2">${score.name } 님의 점수는....</th>
		</tr>
		<tr>
			<th>국어</th>
			<td><%=score.getKor() %></td>
		</tr>
		<tr>
			<th>영어</th>
			<td>${score.eng }</td>
		</tr>
		<tr>
			<th>수학</th>
			<td>${score.math }</td>
		</tr>
		<tr>
			<th>합계</th>
				<!-- sum에는 setter가 실행이 되어야 합계를 구할 수 있는데 getter를 호출해서 가져오는게 0이됨. -->
			<td>${score.sum }</td>
		</tr>
		<tr>
			<th>평균</th>
			<td>${(score.kor+score.eng+score.math)/3 }</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${score.grade }</td>
		</tr>
	</table>
</body>
</html>