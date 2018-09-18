/*
 * Nombre aplicación: CASIA
 * Autor: María Jesús Leiva Romera
 * Año: 2018
 */

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
import javax.servlet.http.HttpSession;

import com.casia.dao.ParteDao;
import com.casia.dao.SancionDao;
import com.casia.entity.ParteEntity;
import com.casia.entity.SancionEntity;

/**
 * Servlet implementation class ParteServlet
 */

public class ParteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VERTODOPARTE = "Partes.jsp";
	private static String VERPARTE = "ConsultarParte.jsp";
	private static String MODIFICAR = "ModificarParte.jsp";
	private static String PENDIENTESANCION = "PendienteSancion.jsp";
	private static String VERSANCION = "ConsultarSancion.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SancionDao sancionDao = new SancionDao();
		ParteDao parteDao = new ParteDao();
		ParteEntity parteEnt = new ParteEntity();
		SancionEntity sancionEnt = new SancionEntity();
		Integer codigoparte, id_sancion;
		String alumsancion, profesancion;
		String forward = "";
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("historialParte")) {
			forward = VERTODOPARTE;
			request.setAttribute("partes", parteDao.getAllPartes());
			
		} else if (action.equalsIgnoreCase("verParte")) {
			forward = VERPARTE;			
			int id_parte = Integer.parseInt(request.getParameter("id_parte"));
			request.setAttribute("parte", parteDao.getParteById(id_parte));
			
		} else if (action.equalsIgnoreCase("modificarParte")) {
			forward = MODIFICAR;			
			int id_parte = Integer.parseInt(request.getParameter("id_parte"));
			request.setAttribute("parte", parteDao.getParteById(id_parte));
			
		} else if (action.equalsIgnoreCase("pendienteSancion")) {
			forward = PENDIENTESANCION;			
			request.setAttribute("partesSin", parteDao.getAllPartesSinSanciones());
			request.setAttribute("partes", parteDao.getAllPartes());
			
		} else if (action.equalsIgnoreCase("verSancion")) {
			forward = VERSANCION;
			int id_parte = Integer.parseInt(request.getParameter("id_parte"));
			sancionEnt = sancionDao.getSancionByIdParte(id_parte);
			id_sancion = sancionEnt.getId_sancion();
			request.setAttribute("sancion", sancionEnt);
			parteEnt = parteDao.getParteByIdsancion(id_sancion);
			alumsancion = parteEnt.getNombre_alum();
			profesancion = parteEnt.getNombre_profe();
			codigoparte = parteEnt.getCodigo();
			session.setAttribute("alumsancion", alumsancion);
			session.setAttribute("profesancion", profesancion);
			session.setAttribute("codigoparte", codigoparte);	
			
		} else if (action.equalsIgnoreCase("eliminarParte")) {
			forward = VERTODOPARTE;
			int id_parte = Integer.parseInt(request.getParameter("id_parte"));
			parteDao.deleteParteById(id_parte);
			request.setAttribute("partes", parteDao.getAllPartes());			
		} 
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ParteEntity parteEnt = new ParteEntity();
		Date fecha_parte = null;
		Integer codigo, id_parte;
		String forward= "";
		
		codigo = Integer.parseInt(request.getParameter("codigo"));
		parteEnt.setCodigo(codigo);
		parteEnt.setCurso(request.getParameter("curso"));
		parteEnt.setNombre_profe(request.getParameter("nombre_profe"));
		parteEnt.setNombre_alum(request.getParameter("nombre_alum"));
		parteEnt.setGrupo(request.getParameter("grupo"));
		parteEnt.setMotivo_parte(request.getParameter("motivo_parte"));
				
		try {
            fecha_parte = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_parte"));
            parteEnt.setFecha_parte(fecha_parte);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		String id_p = request.getParameter("id_parte");
		ParteDao parteDao = new ParteDao();
		
		if(id_p == null || id_p.isEmpty()) {			
			parteDao.addParte(parteEnt);
			
			forward = PENDIENTESANCION;
			request.setAttribute("partes", parteDao.getAllPartes());
			request.setAttribute("partesSin", parteDao.getAllPartesSinSanciones());
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		} else {
			id_parte = Integer.parseInt(request.getParameter("id_parte"));			
			parteEnt.setId_parte(id_parte);
			parteDao.updateParte(parteEnt);
			forward = VERTODOPARTE;
			request.setAttribute("partes", parteDao.getAllPartes());
			RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
		}	
	}
}