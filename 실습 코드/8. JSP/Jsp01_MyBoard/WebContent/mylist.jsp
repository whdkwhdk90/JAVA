<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import='com.my.dao.MyBoardDao' %>
<%@ page import='com.my.dto.MyBoardDto' %>
<%@ page import='java.util.List' %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	tr{
		border:1px solid black;
	}
	th{
		border : 1px solid black;
	}
	td{
		border : 1px solid black;
	}
	table{
		border : 1px solid black;
	}
</style>
</head>
<%
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectAll();
%>
<body>
	<h1>List Page</h1>
	<table>
		<tr>
			<th width="50">NO</th>
			<th width="100">NAME</th>
			<th width="200">TITLE</th>
			<th width="100">DATE</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
<%
	for(int i=0; i<list.size();i++){
%>			
	<tr>
	 	<td><%=list.get(i).getMyno() %></td>
	 	<td><%=list.get(i).getMyname() %></td>
	 	<!--  밑에 처럼 myno= ~~ 해놨을 때 첫번째꺼누르면 1을 return 받아서 주소창에 출력됨. -->
	 	<td><a href="selectone.jsp?myno=<%=list.get(i).getMyno() %>"><%=list.get(i).getMytitle() %></a></td>
	 	<td><%=list.get(i).getMydate() %></td>
	 	<td onclick="location.href = 'myupdate.jsp?myno=<%=list.get(i).getMyno() %>'"><a>수정</a></td>
	 	<td><a href="mydelete.jsp?myno=<%=list.get(i).getMyno() %>">삭제</a></td>
	 </tr>	
<%
	}
%>			
	<td colspan="6" align="right">
		<button onclick="location.href='myinsert.jsp'">글쓰기</button>
	</td>		
	</table>
</body>
</html>