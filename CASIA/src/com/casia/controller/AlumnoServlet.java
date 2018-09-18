/*
 * Nombre aplicación: CASIA
 * Autor: María Jesús Leiva Romera
 * Año: 2018
 */

package com.casia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.casia.dao.AlumnoDao;

/**
 * Servlet implementation class AlumnoServlet
 */

public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String RESULTADO = "AlumnoBuscado.jsp"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoServlet() {
        super();
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
		
		String forward= "";
		HttpSession session = request.getSession();
		AlumnoDao alumDao = new AlumnoDao();		
		
		String nombre_alum = request.getParameter("nombre_alum");
		
		forward = RESULTADO;
		session.setAttribute("nombre_alum", nombre_alum);
		request.setAttribute("alumabs", alumDao.getAlumAbsentismo(nombre_alum));
		request.setAttribute("alumacoso", alumDao.getAlumAcoso(nombre_alum));
		request.setAttribute("alumactmedica", alumDao.getAlumActMedica(nombre_alum));
		request.setAttribute("aluminfjur", alumDao.getAlumInfJuridica(nombre_alum));
		request.setAttribute("aluminfmedica", alumDao.getAlumInfMedica(nombre_alum));
		request.setAttribute("alumparte", alumDao.getAlumParte(nombre_alum));
		request.setAttribute("alumsancion", alumDao.getAlumSancion(nombre_alum));
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}