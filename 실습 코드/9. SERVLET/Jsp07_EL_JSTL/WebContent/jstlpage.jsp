<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");
%>
<%
   response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- core
c: if...
   fmt,fn,sql
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>JSTL Page</h1>
   <table border="1">
      <tr>
         <th>NAME</th>
         <th>KOR</th>
         <th>ENG</th>
         <th>MATH</th>
         <th>SUM</th>
         <th>AVG</th>
         <th>GRADE</th>
      </tr>
      <!-- forEach : items에 담긴 목록을 var 에 담는다 -->
      <c:forEach var="score" items="${list }">
         <tr>
            <td><c:if test="${score.name eq '이름1'}">
                  <c:out value="홍길동"></c:out>
               </c:if> <c:choose>
                  <c:when test="${score.name eq '이름2'}">
                     <c:out value="${score.name} 님!"></c:out>
                  </c:when>
                  <c:when test="${score.name eq '이름3' }">
                     <c:out value="${score.name} 님!"></c:out>
                  </c:when>
                  <c:otherwise>
                     <c:out value="누구지...?"></c:out>
                  </c:otherwise>
               </c:choose></td>
               <td>${score.kor }</td>
               <td>${score.eng }</td>
               <td>${score.math }</td>
               <td>${score.sum }</td>
               <!-- 화명에 평균 출력, 평균이 83 or 84 이면 '00**으로 출력 -->
               <td>
               <c:choose>
               <c:when test="${score.avg eq '83' || score.avg eq '84'}">
               <c:out value="${score.avg }**"></c:out>
               </c:when>
               <c:otherwise>
               <c:out value="${score.avg }"></c:out>
               </c:otherwise>
               </c:choose>
               </td>
               <td>${score.grade }</td>
         </tr>
      </c:forEach>
   </table>
   <hr>
   <c:forEach var="i" begin="1" end="10" step="1">
   	${i }<br>
   </c:forEach>
   
   <hr>
  	<table border="1" style="text-align: center">
  	<col width="30px">
  	<col width="30px">
  	<col width="30px">
  	<col width="30px">
  	<col width="30px">
  		<tr>
  			<th colspan="5">구구단</th>
  		</tr>
  			 <c:forEach var="i" begin="2" end="9" step="1">
    			<c:forEach var="j" begin="1" end="9" step="1">
    			<tr>
	    			<td>${i}</td>
	    			<td>*</td>
	    			<td>${j}</td>
	    			<td>=</td>
	    			<td>${i*j}</td>
	    		</tr>			
	   			</c:forEach>
   			</c:forEach>
  	</table> 
  	
  	
  	<c:set var="test" value="hi~"></c:set>
  	<c:out value="${test }"></c:out>
  	<c:forEach var="i" begin="1" end="10" step="2">
  		<c:out value="${test }+${i }"></c:out>
  	</c:forEach>
  	
  	
  	
  	
  	
  
   
   
</body>
</html>