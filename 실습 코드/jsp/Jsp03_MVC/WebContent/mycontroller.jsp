<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.mvc.dto.MVCBoardDto" %>
<%@ page import="com.mvc.dao.MVCBoardDao" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	System.out.println("[command : "+command+" ]");

	MVCBoardDao dao = new MVCBoardDao();
	
	if(command.equals("boardlist")){
		List<MVCBoardDto> list = dao.selectAll();
		
		//데이터 이동
		request.setAttribute("allList", list);
		//페이지 이동
		pageContext.forward("boardlist.jsp");
		/*
			페이지의 흐름을 제어
			*포워드 : request, response가 유지
				1) requestDispatcher 이용
				2) <jsp:forward>
				3) pageContext.forward()
			*리다이렉트 : 새로운 request, response 객체를 가짐.
				response.sendRedirect()
		*/
	}else if(command.equals("boarddetail")){
		//1. 파라미터로 넘어오는 seq 처리
		//2. dao를 이용하여 data 처리
		//3. 페이지 처리(boarddetail.jsp : jsp02의 detail 페이지와 같은 양식으로 작성)
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = dao.selectOne(seq);
		
		request.setAttribute("dtoList", dto);
		pageContext.forward("boarddetail.jsp");
		
	}else if(command.equals("boardinsertform")){
		
		response.sendRedirect("boardinsert.jsp");
		
	}else if(command.equals("boardinsert")){
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = dao.insert(dto);
		
		if(res>0){		
%>
		<script type="text/javascript">
			alert("글 작성 성공");
			location.href="mycontroller.jsp?command=boardlist";
		</script>		
<% 			
		}else{
%>
		<script type="text/javascript">
			alert("글 작성 실패");
		</script>
<%			
		response.sendRedirect("mycontroller.jsp?command=boardinsertform");
		}
	}else if(command.equals("boardupdateform")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto dto = dao .selectOne(seq);
	
		request.setAttribute("dto", dto);
		pageContext.forward("boardupdate.jsp");
	}else if(command.equals("boardupdate")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setTitle(title);
		dto.setSeq(seq);
		dto.setContent(content);

		int res = dao.update(dto);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("글 수정 성공");
			location.href="mycontroller.jsp?command=boarddetail&seq="+<%=seq%>;
		</script>
<%			
		}else{
%>
		<script type="text/javascript">
			alert("글 수정 실패");
			location.href="mycontroller.jsp?command=boardupdateform&seq="+<%=seq%>;
		</script>
<%			
		}
	}else if(command.equals("deletelist")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = dao.delete(seq);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("글 삭제 성공");
			location.href="mycontroller.jsp?command=boardlist";
		</script>
<%		
		}else{
%>
		<script type="text/javascript">
			alert("글 삭제 실패");
			location.href="mycontroller.jsp?command=boarddetail&seq="<%=seq%>;
		</script>
<%

		}
	}
%>



</body>
</html>