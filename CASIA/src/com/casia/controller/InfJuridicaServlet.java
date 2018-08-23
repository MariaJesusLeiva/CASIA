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

import com.casia.dao.InfJuridicaDao;
import com.casia.dao.InfMedicaDao;
import com.casia.entity.InfJuridicaEntity;
import com.casia.entity.InfMedicaEntity;

/**
 * Servlet implementation class InfJuridicaServlet
 */

public class InfJuridicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String CREARINFJURIDICA = "CrearInfJuridica.jsp";
	private static String VERINFJURIDICAS = "InfJuridicas.jsp";
	private static String VERINFJURIDICA = "ConsultarInfJuridica.jsp";
	private static String MODIFICARINFJURIDICA = "ModificarInfJuridica.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfJuridicaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InfJuridicaDao infjuridicaDao = new InfJuridicaDao();
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("crearInfJuridica")) {
			forward = CREARINFJURIDICA;
			request.setAttribute("infuridicas", infjuridicaDao.getAllInfJuridicas());

		} else if (action.equalsIgnoreCase("verInfJuridicas")) {
			forward = VERINFJURIDICAS;
			request.setAttribute("infuridicas", infjuridicaDao.getAllInfJuridicas());

		} else if (action.equalsIgnoreCase("verInfJuridica")) {
			forward = VERINFJURIDICA;
			int id_juridica = Integer.parseInt(request.getParameter("id_juridica"));
			request.setAttribute("infuridica", infjuridicaDao.getInfJuridicaById(id_juridica));
			request.setAttribute("infjuridicas", infjuridicaDao.getAllInfJuridicas());

		} else if (action.equalsIgnoreCase("modificarInfJuridica")) {
			forward = MODIFICARINFJURIDICA;
			int id_juridica = Integer.parseInt(request.getParameter("id_juridica"));
			request.setAttribute("infuridica", infjuridicaDao.getInfJuridicaById(id_juridica));
			request.setAttribute("infuridicas", infjuridicaDao.getAllInfJuridicas());

		} else if (action.equalsIgnoreCase("eliminarInfMedica")) {
			forward = VERINFJURIDICAS;
			int id_juridica = Integer.parseInt(request.getParameter("id_juridica"));
			infjuridicaDao.deleteInfJuridicaById(id_juridica);
			request.setAttribute("infuridicas", infjuridicaDao.getAllInfJuridicas());
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InfJuridicaEntity infjuridicaEnt = new InfJuridicaEntity();
		InfJuridicaDao infjuridicaDao = new InfJuridicaDao();
		String forward= "";
		Date fecha_nacimiento = null;
		Integer id_juridica;
		
		try {
			fecha_nacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_nacimiento"));
			infjuridicaEnt.setFecha_nacimiento(fecha_nacimiento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		infjuridicaEnt.setCurso(request.getParameter("curso"));
		infjuridicaEnt.setDocumentacion(request.getParameter("documentacion"));
		infjuridicaEnt.setGrupo(request.getParameter("grupo"));
		infjuridicaEnt.setInf_juridica(request.getParameter("inf_juridica"));
		infjuridicaEnt.setNombre_alum(request.getParameter("nombre_alum"));
		
		
		String id_mdc = request.getParameter("id_juridica");
		if(id_mdc == null || id_mdc.isEmpty()) {
			infjuridicaDao.addInfJuridica(infjuridicaEnt);			
		} else {
			id_juridica = Integer.parseInt(request.getParameter("id_juridica"));
			infjuridicaEnt.setId_juridica(id_juridica);
			infjuridicaDao.updateInfJuridica(infjuridicaEnt);
		}
		
		forward = VERINFJURIDICAS;
		request.setAttribute("infjuridicas", infjuridicaDao.getAllInfJuridicas());
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
