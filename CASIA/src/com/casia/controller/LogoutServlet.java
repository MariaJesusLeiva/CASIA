/*
 * Nombre aplicaci�n: CASIA
 * Autor: Mar�a Jes�s Leiva Romera
 * A�o: 2018
 */

package com.casia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String SALIR = "Login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String forward= "";
		RequestDispatcher rd = null;
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("salir")) {
			if(session != null) {
				forward = SALIR;
				session.removeAttribute("user_name");
				session.invalidate();
				request.setAttribute("errMessage", "* Cierre de sesi�n correcto");
				rd = request.getRequestDispatcher(forward);
				rd.forward(request, response);
			}
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
