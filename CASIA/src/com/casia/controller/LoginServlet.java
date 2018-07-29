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
import com.casia.entity.UsuarioEntity;

/**
 * Servlet implementation class UsuarioServlet
 */
//@WebServlet("/UsuarioServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
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
		
        PrintWriter out = response.getWriter();  
        RequestDispatcher rd = null;
        
        
        String name_user = request.getParameter("name_user");  
        String pass_user = request.getParameter("pass_user");

		UsuarioEntity userEnt = new UsuarioEntity();
		userEnt.setName_user(name_user);
		userEnt.setPass_user(pass_user);
		
		UsuarioDao userDao = new UsuarioDao();

		try {
			String userRol = userDao.ObtenerRol(userEnt);
			System.out.println("El rol es: "+userDao.ObtenerRol(userEnt));
			if (userRol.equals("admin")) {
				System.out.println("Entro en admin");
				HttpSession session = request.getSession();
				session.setAttribute("admin", name_user);
				session.setAttribute("name_user", name_user);
				rd = request.getRequestDispatcher("PrincipalAdmin.jsp");
				rd.forward(request, response);
			} else if (userRol.equals("directiva")) {
				System.out.println("Entro en directiva");
				HttpSession session = request.getSession();
				session.setAttribute("directiva", name_user);
				session.setAttribute("name_user", name_user);
				rd = request.getRequestDispatcher("Principal.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("Error message = "+userRol);
				request.setAttribute("errMessage", userRol);
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


