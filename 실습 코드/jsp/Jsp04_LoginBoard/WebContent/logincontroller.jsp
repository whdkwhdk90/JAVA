<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.login.dao.MyMemberDao" %>
<%@ page import="com.login.dto.MyMemberDto" %>
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
	System.out.println("[command: " + command+"]");
	
	MyMemberDao dao = new MyMemberDao();
	
	if(command.equals("login")){
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MyMemberDto dto = dao.login(id,pw);
		
		if(dto.getMyid() != null){
			//로그인을 session에 저장해두면 page가 꺼지지않는이상 살아있음(페이지를 넘어가도 살아있음)
			//브라우저당 1개의 세션객체 생성
			session.setAttribute("dto", dto);
			//session객체 살아있는 시간에 대한 디폴트는 30분, 음수넣으면 무제한, 60*60이면 60분.
			session.setMaxInactiveInterval(60*60);
			
			/*
			스코프(scope)
			1. page 영역 : pageContext 객체
			=>페이지당 1개의 pageContext객체가 있고 다른 page의 pageContext객체랑은 다른놈임.
			= JSP 파일에는 pageContext객체가 내장, 이 객체는 page 영역에서만 유효
			2. request 영역 : request 객체
			요청을 받아서 응답하기 까지 객체가 유효, forward, include 사용하면 request 객체가 공유
			3. session 영역 : session 객체
			브라우저당 1개
				request.getSession()
 			4. application 영역 : application 객체 
 			어플리케이션당 1개
 			request.getServletContext() 메서드사용하여 어플리케이션 객체를 얻을 수 있다.
			*/
			
			if(dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
			}else if(dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			}
			
		}else{
			//id가 null일때
%>
			<script type="text/javascript">
				alert("login 실패");
				location.href="index.jsp";
			</script>
<% 
			
		}
	}else if(command.equals("logout")){
		//세션 정보 삭제
		session.invalidate();
		response.sendRedirect("index.jsp");
	}else if(command.equals("userlistall")){
		List<MyMemberDto> list = dao.selectAll();
		request.setAttribute("list", list);
		pageContext.forward("userlistall.jsp");
		
		
	}else if(command.equals("userlistenabled")){
		List<MyMemberDto> list =dao.selectEnabled();
		request.setAttribute("list", list);
		pageContext.forward("userlistenabled.jsp");
		
	}else if(command.equals("updateroleform")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		MyMemberDto dto = dao.selectUser(myno);
		
		request.setAttribute("selectone", dto);
		pageContext.forward("updateroleform.jsp");
	}else if(command.equals("updaterole")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		
		int res = dao.updateRole(myno,myrole);
		
		if(res>0){
%>	
		<script type="text/javascript">
			alert("회원등급 조정 성공");
			location.href="logincontroller.jsp?command=userlistenabled";
		</script>	
<%		
		}else{
%>			
		<script type="text/javascript">
			alert("회원등급 조정 실패");
			location.href="logincontroller.jsp?command=updateroleform&myno=<%=myno%>";
		</script>
<% 
		}
	}else if(command.equals("registform")){
		response.sendRedirect("registform.jsp");
	}else if(command.equals("idchk")){
		
		String myid = request.getParameter("id");
		String res = dao.idChk(myid);
		boolean idnotused = true;
		
		if(res != null){
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
		
	}
%>

</body>
</html>