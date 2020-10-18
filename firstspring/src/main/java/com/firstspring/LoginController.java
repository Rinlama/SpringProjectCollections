package com.firstspring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login.do")
public class LoginController extends HttpServlet {
	
	
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
	

	}
	
}
