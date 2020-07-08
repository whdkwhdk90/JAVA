package com.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.el.score.Score;

//어노테이션으로 매핑을 시킴.
//controller.do라는 주소가 들어오면 얘가 처리하겠다.
@WebServlet("/controller.do")
public class Mycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Mycontroller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("[command : "+command+"]");
		
		if(command.equals("elpage")) {
			
			response.sendRedirect("basic-arithmetic.jsp");
			
		}else if(command.equals("eltest")) {
			
			Score sc = new Score("이창진",100,72,95);
			
			request.setAttribute("score", sc);
			RequestDispatcher dispatch = request.getRequestDispatcher("eltest.jsp");
			dispatch.forward(request, response);
			
		}else if(command.equals("jstlpage")) {
			List<Score> res = new ArrayList<>();
			
			for(int i=1;i<6;i++) {
				Score sc = new Score("이름"+i,70+i,80+i,90+i);
				res.add(sc);
			}
			
			request.setAttribute("list", res);
			RequestDispatcher dispatch = request.getRequestDispatcher("jstlpage.jsp");
			dispatch.forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
