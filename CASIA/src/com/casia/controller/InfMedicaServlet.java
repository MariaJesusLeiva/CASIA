package com.casia.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casia.dao.InfMedicaDao;
import com.casia.entity.InfMedicaEntity;

/**
 * Servlet implementation class InfMedicaServlet
 */

public class InfMedicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String CREARINFMEDICA = "CrearInfMedica.jsp";
	private static String VERINFMEDICAS = "InfMedicas.jsp";
	private static String VERINFMEDICA = "ConsultarInfMedica.jsp";
	private static String MODIFICARINFMEDICA = "ModificarInfMedica.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfMedicaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InfMedicaDao infmedicaDao = new InfMedicaDao();
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("crearInfMedica")) {
			forward = CREARINFMEDICA;
			request.setAttribute("infmedicas", infmedicaDao.getAllInfMedicas());

		} else if (action.equalsIgnoreCase("verInfMedicas")) {
			forward = VERINFMEDICAS;
			request.setAttribute("infmedicas", infmedicaDao.getAllInfMedicas());

		} else if (action.equalsIgnoreCase("verInfMedica")) {
			forward = VERINFMEDICA;
			int id_medica = Integer.parseInt(request.getParameter("id_medica"));
			request.setAttribute("infmedica", infmedicaDao.getInfMedicaById(id_medica));
			request.setAttribute("infmedicas", infmedicaDao.getAllInfMedicas());

		} else if (action.equalsIgnoreCase("modificarInfMedica")) {
			forward = MODIFICARINFMEDICA;
			int id_medica = Integer.parseInt(request.getParameter("id_medica"));
			request.setAttribute("infmedica", infmedicaDao.getInfMedicaById(id_medica));
			request.setAttribute("infmedicas", infmedicaDao.getAllInfMedicas());

		} else if (action.equalsIgnoreCase("eliminarInfMedica")) {
			forward = VERINFMEDICAS;
			int id_medica = Integer.parseInt(request.getParameter("id_medica"));
			infmedicaDao.deleteInfMedicaById(id_medica);
			request.setAttribute("infmedicas", infmedicaDao.getAllInfMedicas());
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InfMedicaEntity infmedicaEnt = new InfMedicaEntity();
		InfMedicaDao infmedicaDao = new InfMedicaDao();
		String forward= "";
		Date fecha_nacimiento = null;
		Integer id_medica;
		
		try {
			fecha_nacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_nacimiento"));
			infmedicaEnt.setFecha_nacimiento(fecha_nacimiento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		infmedicaEnt.setCurso(request.getParameter("curso"));
		infmedicaEnt.setDocumentacion(request.getParameter("documentacion"));
		infmedicaEnt.setGrupo(request.getParameter("grupo"));
		infmedicaEnt.setInf_medica(request.getParameter("inf_medica"));
		infmedicaEnt.setMedicacion(request.getParameter("medicacion"));
		infmedicaEnt.setNombre_alum(request.getParameter("nombre_alum"));
				
		String id_mdc = request.getParameter("id_medica");
		if(id_mdc == null || id_mdc.isEmpty()) {
			infmedicaDao.addInfMedica(infmedicaEnt);			
		} else {
			id_medica = Integer.parseInt(request.getParameter("id_medica"));
			infmedicaEnt.setId_medica(id_medica);
			infmedicaDao.updateInfMedica(infmedicaEnt);
		}
		
		forward = VERINFMEDICAS;
		request.setAttribute("infmedicas", infmedicaDao.getAllInfMedicas());
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}