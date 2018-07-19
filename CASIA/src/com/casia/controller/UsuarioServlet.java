package com.casia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.casia.dao.UsuarioDao;

/**
 * Servlet implementation class UsuarioServlet
 */
//@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
		dao = new UsuarioDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        RequestDispatcher rd = null;
        
        String name_user = request.getParameter("name_user");  
        String pass_user = request.getParameter("pass_user"); 
        
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name_user", name_user);

        try {
			if(UsuarioDao.validarLogin(name_user, pass_user))
				
			{  
				rd = request.getRequestDispatcher("Principal.jsp");
			    rd.forward(request,response);
			    
			}  
			else
			{  
			    out.print("<p style=\"color:red\">Sorry username or password error</p>");  
			    rd = request.getRequestDispatcher("Login.jsp");  
			    rd.include(request,response);  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

        out.close();  
    
		
	}
}


