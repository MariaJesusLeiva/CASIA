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
import com.casia.dao.ReservaDiaSancionDao;
import com.casia.dao.SancionDao;
import com.casia.entity.ParteEntity;
import com.casia.entity.SancionEntity;

/**
 * Servlet implementation class SancionServlet
 */

public class SancionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String CREARSANCION = "CrearSancion.jsp";
	private static String VERSANCIONESSINDIAS = "SancionesSinDias.jsp";
	private static String VERTODASSANCION = "Sanciones.jsp";
	private static String VERSANCION = "ConsultarSancion.jsp";
	private static String MODIFICARSANCION = "ModificarSancion.jsp";
	private static String EXPULSIONACTIVA = "AsistenciaExpulsion.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SancionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SancionDao sancionDao = new SancionDao();
		ParteDao parteDao = new ParteDao();
		ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
		ParteEntity parteEnt = new ParteEntity();
		String forward = "";
		Integer codigoparte;
		String alumsancion, profesancion;
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("crearSancion")) {
			forward = CREARSANCION;
			int id_parte = Integer.parseInt(request.getParameter("id_parte"));
			request.setAttribute("sancion", sancionDao.getParteById(id_parte));

			// Para mostrar el nombre del alumno al cual se está seleccionando la sanción
			parteEnt = parteDao.getAlumSancionByIdParte(id_parte);
			alumsancion = parteEnt.getNombre_alum();
			profesancion = parteEnt.getNombre_profe();
			codigoparte = parteEnt.getCodigo();
			session.setAttribute("alumsancion", alumsancion);
			session.setAttribute("profesancion", profesancion);
			session.setAttribute("codigoparte", codigoparte);
			request.setAttribute("sanciones", sancionDao.getAllSanciones());

		} else if (action.equalsIgnoreCase("verSancionesSinDias")) {
			forward = VERSANCIONESSINDIAS;
			request.setAttribute("sancionSin", sancionDao.getAllSancionesSinDias());
			request.setAttribute("sanciones", reservaDao.getAllRecreoPROA());

		} else if (action.equalsIgnoreCase("historialSanciones")) {
			forward = VERTODASSANCION;
			request.setAttribute("sanciones", sancionDao.getAllSanciones());

		} else if (action.equalsIgnoreCase("verSancion")) {
			forward = VERSANCION;
			int id_sancion = Integer.parseInt(request.getParameter("id_sancion"));
			request.setAttribute("sancion", sancionDao.getSancionById(id_sancion));
			parteEnt = parteDao.getParteByIdsancion(id_sancion);
			alumsancion = parteEnt.getNombre_alum();
			profesancion = parteEnt.getNombre_profe();
			codigoparte = parteEnt.getCodigo();
			session.setAttribute("alumsancion", alumsancion);
			session.setAttribute("profesancion", profesancion);
			session.setAttribute("codigoparte", codigoparte);

		} else if (action.equalsIgnoreCase("modificarSancion")) {
			forward = MODIFICARSANCION;
			int id_sancion = Integer.parseInt(request.getParameter("id_sancion"));
			request.setAttribute("sancion", sancionDao.getSancionById(id_sancion));
		} else if (action.equalsIgnoreCase("eliminarSancion")) {
			forward = VERTODASSANCION;
			int id_sancion = Integer.parseInt(request.getParameter("id_sancion"));
			sancionDao.deleteSancionById(id_sancion);
			request.setAttribute("sanciones", sancionDao.getAllSanciones());
		} else if (action.equalsIgnoreCase("activaExpulsion")) {
			forward = EXPULSIONACTIVA;
			request.setAttribute("expulsionact", sancionDao.getAllExpulsionesActiva());
			request.setAttribute("expulsiones", sancionDao.getAllExpulsiones());

		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SancionEntity sancionEnt = new SancionEntity();
		SancionDao sancionDao = new SancionDao();
		ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
		Date fecha_inicio = null;
		Date fecha_fin = null;
		String forward = "";
		Integer id_snc;

		String id_parte = request.getParameter("id_parte");
		sancionEnt.setId_parte(Integer.parseInt(id_parte));
		sancionEnt.setTipo_sancion(request.getParameter("tipo_sancion"));
		sancionEnt.setObservacion(request.getParameter("observacion"));
		sancionEnt.setTrabajo(request.getParameter("trabajo"));
		sancionEnt.setNombre_alum(request.getParameter("nombre_alum"));

		String id_sancion = request.getParameter("id_sancion");

		if (id_sancion == null || id_sancion.isEmpty()) {

			sancionDao.addSancion(sancionEnt);

			String tipo_sancion = request.getParameter("tipo_sancion");

			if (tipo_sancion.equals("Expulsión")) {
				int id_p = Integer.parseInt(request.getParameter("id_parte"));
				int id_s = sancionDao.getIdSancionByIdParte(id_p);
				sancionEnt.setId_sancion(id_s);
				String total_dias = request.getParameter("total_dias");
				sancionEnt.setTotal_dias(Integer.parseInt(total_dias));

				if (total_dias != null) {
					sancionDao.updateAsignadoDias(id_s);
				}

				try {
					fecha_inicio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_inicio"));
					sancionEnt.setFecha_inicio(fecha_inicio);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				try {
					fecha_fin = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_fin"));
					sancionEnt.setFecha_fin(fecha_fin);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				sancionDao.updateSancionExpulsion(sancionEnt);

				forward = VERTODASSANCION;
				request.setAttribute("sanciones", sancionDao.getAllSanciones());
				RequestDispatcher view = request.getRequestDispatcher(forward);
				view.forward(request, response);
			}
			
			// Para actualizar el campo tipo_sancion de la tabla parte
			ParteDao parteDao = new ParteDao();
			Integer id_p = Integer.parseInt(request.getParameter("id_parte"));
			parteDao.updateSancionParte(id_p);
			
			if (tipo_sancion.equals("Recreo") || tipo_sancion.equals("PROA")) {
				forward = VERSANCIONESSINDIAS;
				RequestDispatcher view = request.getRequestDispatcher(forward);
				request.setAttribute("sancionSin", sancionDao.getAllSancionesSinDias());
				request.setAttribute("sanciones", reservaDao.getAllRecreoPROA());
				view.forward(request, response);
			}
		} else {

			id_snc = Integer.parseInt(request.getParameter("id_sancion"));
			sancionEnt.setId_sancion(id_snc);
			String tipo_sanc = sancionDao.getTipoSancionById(id_snc);
			String tipo_sancion = request.getParameter("tipo_sancion");
			sancionDao.updateSancion(sancionEnt);
			if (tipo_sancion != tipo_sanc) {
				sancionDao.reiniciarTotal_dias(id_snc);
				reservaDao.deleteReservaById(id_snc);
			}

			String total_dias = request.getParameter("total_dias");
			sancionEnt.setTotal_dias(Integer.parseInt(total_dias));

			if (tipo_sancion.equals("Expulsión")) {
				int id_p = Integer.parseInt(request.getParameter("id_parte"));
				int id_s = sancionDao.getIdSancionByIdParte(id_p);
				sancionEnt.setId_sancion(id_s);

				if (total_dias != null) {
					sancionDao.updateAsignadoDias(id_s);
				}

				try {
					fecha_inicio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_inicio"));
					sancionEnt.setFecha_inicio(fecha_inicio);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				try {
					fecha_fin = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_fin"));
					sancionEnt.setFecha_fin(fecha_fin);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				sancionDao.updateSancionExpulsion(sancionEnt);

				forward = VERTODASSANCION;
				request.setAttribute("sanciones", sancionDao.getAllSanciones());
				RequestDispatcher view = request.getRequestDispatcher(forward);
				view.forward(request, response);
			}

			// Para actualizar el campo tipo_sancion de la tabla parte
			ParteDao parteDao = new ParteDao();
			Integer id_p = Integer.parseInt(request.getParameter("id_parte"));
			parteDao.updateSancionParte(id_p);

			if (tipo_sancion.equals("Recreo") || tipo_sancion.equals("PROA")) {
				forward = VERSANCIONESSINDIAS;
				RequestDispatcher view = request.getRequestDispatcher(forward);
				request.setAttribute("sancionSin", sancionDao.getAllSancionesSinDias());
				request.setAttribute("sanciones", reservaDao.getAllRecreoPROA());
				view.forward(request, response);
			}
		}
	}
}