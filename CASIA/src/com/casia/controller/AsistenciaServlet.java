package com.casia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casia.dao.PROADao;
import com.casia.dao.ParteDao;
import com.casia.dao.RecreoDao;
import com.casia.dao.SancionDao;

/**
 * Servlet implementation class AsistenciaServlet
 */

public class AsistenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ASISTENCIARECREO = "/AsistenciaRecreo.jsp";
	private static String ASISTENCIAPROA = "/AsistenciaPROA.jsp"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsistenciaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecreoDao recreoDao = new RecreoDao();
		PROADao proaDao = new PROADao();
		String forward="";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("asistenciaRecreo")) {
			forward = ASISTENCIARECREO;
			request.setAttribute("recreo", recreoDao.getAllAsistenciaRecreos());
		} else if (action.equalsIgnoreCase("asistenciaPROA")) {
			forward = ASISTENCIAPROA;
			request.setAttribute("proa", proaDao.getAllAsistenciaPROAs());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoPost");
		
		SancionDao sancionDao = new SancionDao();
		String [] Array = request.getParameterValues("asistencia");
		for(int i=0;i<Array.length-1;i++) {
			System.out.println("Array["+i+"] "+Array[i]);
		}
		for (int j=0; j<Array.length; j++) {
			String idAsistencia = Array[j];
			Integer id = Integer.parseInt(idAsistencia);
			System.out.println("idAsistencia " +id);
			sancionDao.updateAsistencia(id);
			System.out.println("Database was updated");
		}
		
		//CAMBIAR DESTINO
		ParteDao parteDao = new ParteDao();
		RequestDispatcher view = request.getRequestDispatcher("Partes.jsp");
		request.setAttribute("partesSin", parteDao.getAllPartesSinSanciones());
		request.setAttribute("partes", parteDao.getAllPartes());
		view.forward(request, response);			
		} 

}
