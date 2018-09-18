/*
 * Nombre aplicación: CASIA
 * Autor: María Jesús Leiva Romera
 * Año: 2018
 */

package com.casia.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.casia.dao.ReservaDiaSancionDao;
import com.casia.dao.SancionDao;
import com.casia.dao.UsuarioDao;
import com.casia.entity.UsuarioEntity;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        RequestDispatcher rd = null;     
        UsuarioDao usuarioDao = new UsuarioDao();
        ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
        SancionDao sancionDao = new SancionDao();

		if (request.getParameter("btnEntrar") != null) {
			String name_user = request.getParameter("name_user");
			String pass_user = request.getParameter("pass_user");

			UsuarioEntity userEnt = new UsuarioEntity();
			userEnt.setName_user(name_user);
			userEnt.setPass_user(pass_user);

			UsuarioDao userDao = new UsuarioDao();
			HttpSession session = request.getSession();
			
			try {
				String rol_user = userDao.ObtenerRol(userEnt);
				if (rol_user.equals("admin")) {
					session.setAttribute("admin", rol_user);
					session.setAttribute("name_user", name_user);
					request.setAttribute("usuarios", usuarioDao.getAllUsuarios());
					rd = request.getRequestDispatcher("AdmCrearUsuario.jsp");
					rd.include(request, response);
				} else if (rol_user.equals("directiva")) {
					session.setAttribute("directiva", rol_user);
					session.setAttribute("user_name", name_user);
					request.setAttribute("recreohoy", reservaDao.getAllRecreosHoy());
					request.setAttribute("proahoy", reservaDao.getAllPROAsHoy());
					request.setAttribute("expulsionact", sancionDao.getAllExpulsionesActiva());
					rd = request.getRequestDispatcher("Resumen.jsp");
					rd.include(request, response);
				} else {
					request.setAttribute("errMessage", rol_user);
					rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}