package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {
	
	UserValidateService service= new UserValidateService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	String name=req.getParameter("name");
	String password=req.getParameter("password");
	req.setAttribute("name", name);
	req.setAttribute("password", password);
	req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String name = req.getParameter("name");
	req.setAttribute("name", name);
	String password = req.getParameter("password");
	req.setAttribute("password", password);
	
	boolean isvalid=service.IsUserValid(name, password);
	if(isvalid){
		req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, res);
	}else{
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
	}
	}
	
}
