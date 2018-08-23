package com.casia.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casia.dao.ActMedicaDao;
import com.casia.dao.InfMedicaDao;
import com.casia.entity.ActMedicaEntity;
import com.casia.entity.InfMedicaEntity;

/**
 * Servlet implementation class ActMedicaServlet
 */

public class ActMedicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String CREARACTMEDICA = "CrearActMedica.jsp";
	private static String VERACTMEDICAS = "ActMedicas.jsp";
	private static String VERACTMEDICA = "ConsultarActMedica.jsp";
	private static String MODIFICARACTMEDICA = "ModificarActMedica.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActMedicaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActMedicaDao actmedicaDao = new ActMedicaDao();
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("crearActMedica")) {
			forward = CREARACTMEDICA;
			request.setAttribute("actmedicas", actmedicaDao.getAllActMedicas());

		} else if (action.equalsIgnoreCase("verActMedicas")) {
			forward = VERACTMEDICAS;
			request.setAttribute("actmedicas", actmedicaDao.getAllActMedicas());

		} else if (action.equalsIgnoreCase("verActMedica")) {
			forward = VERACTMEDICA;
			int id_actuacion = Integer.parseInt(request.getParameter("id_actuacion"));
			request.setAttribute("actmedica", actmedicaDao.getActMedicaById(id_actuacion));
			request.setAttribute("actmedicas", actmedicaDao.getAllActMedicas());

		} else if (action.equalsIgnoreCase("modificarActMedica")) {
			forward = MODIFICARACTMEDICA;
			int id_actuacion = Integer.parseInt(request.getParameter("id_actuacion"));
			request.setAttribute("actmedica", actmedicaDao.getActMedicaById(id_actuacion));
			request.setAttribute("actmedicas", actmedicaDao.getAllActMedicas());

		} else if (action.equalsIgnoreCase("eliminarActMedica")) {
			forward = VERACTMEDICAS;
			int id_actuacion = Integer.parseInt(request.getParameter("id_actuacion"));
			actmedicaDao.deleteActMedicaById(id_actuacion);
			request.setAttribute("actmedicas", actmedicaDao.getAllActMedicas());
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ActMedicaEntity actmedicaEnt = new ActMedicaEntity();
		ActMedicaDao actmedicaDao = new ActMedicaDao();
		String forward = "";
		Date fecha_actuacion = null;
		Integer id_actuacion;

		try {
			fecha_actuacion = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_actuacion"));
			actmedicaEnt.setFecha_actuacion(fecha_actuacion);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		actmedicaEnt.setCurso(request.getParameter("curso"));
		actmedicaEnt.setGrupo(request.getParameter("grupo"));
		actmedicaEnt.setObservacion(request.getParameter("observacion"));
		actmedicaEnt.setNombre_alum(request.getParameter("nombre_alum"));

		String id_mdc = request.getParameter("id_actuacion");
		if (id_mdc == null || id_mdc.isEmpty()) {
			actmedicaDao.addActMedica(actmedicaEnt);
		} else {
			id_actuacion = Integer.parseInt(request.getParameter("id_actuacion"));
			actmedicaEnt.setId_actuacion(id_actuacion);
			actmedicaDao.updateActMedica(actmedicaEnt);
		}

		forward = VERACTMEDICAS;
		request.setAttribute("actmedicas", actmedicaDao.getAllActMedicas());
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}