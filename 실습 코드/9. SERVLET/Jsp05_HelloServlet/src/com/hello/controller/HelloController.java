package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloController")
public class HelloController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public HelloController() {
        super();
        System.out.println("servlet 생성자");
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
       System.out.println("servlet init()");
       //getServletContext() : 서블릿 컨테이너에 접근해 서블릿의 정보를 가져올 수 있음
       System.out.println("context param: "+ config.getServletContext().getInitParameter("url"));
       System.out.println("init param: "+ config.getInitParameter("driver"));
    }
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("get 방식");
      doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("post 방식");
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      String command = request.getParameter("command");
      System.out.println("Parameter: "+ command);
      //자바에서 외부로 데이터를 출력하기 위해 PrintWriter를 사용
      PrintWriter out = response.getWriter(); 
      out.print("<h1 style='background-color:skyblue;'>helloServlet</h1>");
      out.print("<h2>servlet 라이플사이클,url mapping</h2>");
      out.print("<a href='home.html'>돌아가기</a>");
      
   }
   @Override
   public void destroy() {
      System.out.println("servlet destroy()");
   }

}