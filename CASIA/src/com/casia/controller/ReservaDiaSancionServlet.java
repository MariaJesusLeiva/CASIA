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

import com.casia.dao.ReservaDiaSancionDao;
import com.casia.dao.SancionDao;
import com.casia.entity.ReservaDiaSancionEntity;
import com.casia.entity.SancionEntity;

/**
 * Servlet implementation class ReservaDiaSancionServlet
 */

public class ReservaDiaSancionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ASIGNARDIAS = "AsignarDiasSancion.jsp";
	private static String ASIGNADODIAS = "SancionesSinDias.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaDiaSancionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SancionEntity sancionEnt = new SancionEntity();
		SancionDao sancionDao = new SancionDao();
		ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
		String alumsancion;
		String forward = "";
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("asignarDias")) {
			forward = ASIGNARDIAS;
			int id_sancion = Integer.parseInt(request.getParameter("id_sancion"));
			request.setAttribute("sancion", sancionDao.getSancionById(id_sancion));
			sancionEnt = sancionDao.getSancionById(id_sancion);
			alumsancion = sancionEnt.getNombre_alum();
			session.setAttribute("alumsancion", alumsancion);
			request.setAttribute("reservas", reservaDao.getAllReservas());
		} else if (action.equalsIgnoreCase("asignadoDias")) {
			forward = ASIGNADODIAS;
			int id_sancion = Integer.parseInt(request.getParameter("id_sancion"));
			sancionDao.updateAsignadoDias(id_sancion);   
			request.setAttribute("sancionSin", sancionDao.getAllSancionesSinDias());
			request.setAttribute("sanciones", reservaDao.getAllRecreoPROA());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReservaDiaSancionEntity reservaEnt = new ReservaDiaSancionEntity();
		ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
		Date fecha_inicio;
		HttpSession session = request.getSession();
		String forward = "";

		String id_sancion = request.getParameter("id_sancion");
		System.out.println("id_sancion " + id_sancion);
		reservaEnt.setId_sancion(Integer.parseInt(id_sancion));
		reservaEnt.setNombre_alum(request.getParameter("nombre_alum"));
		reservaEnt.setTipo_sancion(request.getParameter("tipo_sancion"));
		
		try {
			fecha_inicio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_inicio"));
			reservaEnt.setFecha_inicio(fecha_inicio);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		reservaDao.addReserva(reservaEnt);

		// Para actualizar el campo total_dias de la tabla sancion
		SancionDao sancionDao = new SancionDao();
		Integer id_s = Integer.parseInt(request.getParameter("id_sancion"));
		sancionDao.updateSancionDias(id_s);
		SancionEntity sancionEnt = new SancionEntity();
		forward = ASIGNARDIAS;
		request.setAttribute("sancion", sancionDao.getSancionById(id_s));
		sancionEnt = sancionDao.getSancionById(id_s);
		String alumsancion = sancionEnt.getNombre_alum();
		session.setAttribute("alumsancion", alumsancion);
		request.setAttribute("reservas", reservaDao.getAllReservas());
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
