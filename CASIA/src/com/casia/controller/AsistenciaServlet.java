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


import com.casia.dao.ReservaDiaSancionDao;
import com.casia.dao.SancionDao;


/**
 * Servlet implementation class AsistenciaServlet
 */

public class AsistenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ASISTENCIARECREO = "AsistenciaRecreo.jsp";
	private static String ASISTENCIAPROA = "AsistenciaPROA.jsp";	
	private static String VERSANCIONESSINDIAS = "SancionesSinDias.jsp";
	private static String VERSANCIONESHOY = "Resumen.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsistenciaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SancionDao sancionDao = new SancionDao();
		ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
		String forward="";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("asistenciaRecreo")) {
			forward = ASISTENCIARECREO;
			request.setAttribute("recreo", reservaDao.getAllAsistenciaRecreos());
			request.setAttribute("reservare", reservaDao.getAllReservasRecreo());
			
		} else if (action.equalsIgnoreCase("asistenciaPROA")) {
			forward = ASISTENCIAPROA;
			request.setAttribute("proa", reservaDao.getAllAsistenciaPROAs());
			request.setAttribute("reservaproa", reservaDao.getAllReservasPROA());
			
		} else if (action.equalsIgnoreCase("sancionesHoy")) {
			forward = VERSANCIONESHOY;
			request.setAttribute("recreohoy", reservaDao.getAllRecreosHoy());
			request.setAttribute("proahoy", reservaDao.getAllPROAsHoy());
			request.setAttribute("expulsionact", sancionDao.getAllExpulsionesActiva());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
		String forward="";		
		SancionDao sancionDao = new SancionDao();
		String [] Array = request.getParameterValues("asistencia");
		
		for (int j=0; j<Array.length; j++) {
			String idAsistencia = Array[j];
			Integer id = Integer.parseInt(idAsistencia);
			reservaDao.updateAsistencia(id);
		}
		
		forward = VERSANCIONESSINDIAS;
		RequestDispatcher view = request.getRequestDispatcher(forward);
		request.setAttribute("sancionSin", sancionDao.getAllSancionesSinDias());
		request.setAttribute("sanciones", reservaDao.getAllRecreoPROA());
		view.forward(request, response);			
		} 
}