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

import com.casia.dao.ReunionDao;
import com.casia.entity.ReunionEntity;

/**
 * Servlet implementation class ReunionServlet
 */

public class ReunionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VERREUNIONES = "Reuniones.jsp";
	private static String VERREUNION = "ConsultarReunion.jsp";
	private static String CREARREUNION = "CrearReunion.jsp";
	private static String MODIFICARREUNION = "ModificarReunion.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReunionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReunionDao reunionDao = new ReunionDao();
		String forward="";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("crearReunion")) {
			forward = CREARREUNION;
			request.setAttribute("reuniones", reunionDao.getAllReuniones());
		} else if (action.equalsIgnoreCase("verReuniones")) {
			forward = VERREUNIONES;
			request.setAttribute("reuniones", reunionDao.getAllReuniones());
		} else if (action.equalsIgnoreCase("verReunion")) {
			forward = VERREUNION;
			int id_reunion = Integer.parseInt(request.getParameter("id_reunion"));
			request.setAttribute("reunion", reunionDao.getReunionById(id_reunion));
			request.setAttribute("reuniones", reunionDao.getAllReuniones());
		} else if (action.equalsIgnoreCase("modificarReunion")) {
			forward = MODIFICARREUNION;
			int id_reunion = Integer.parseInt(request.getParameter("id_reunion"));
			request.setAttribute("reunion", reunionDao.getReunionById(id_reunion));
			request.setAttribute("reuniones", reunionDao.getAllReuniones());
			
		} else if (action.equalsIgnoreCase("eliminarReunion")) {
			forward = VERREUNIONES;
			int id_reunion = Integer.parseInt(request.getParameter("id_reunion"));
			reunionDao.deleteReunionById(id_reunion);
			request.setAttribute("reuniones", reunionDao.getAllReuniones());
		}
		
		 RequestDispatcher view = request.getRequestDispatcher(forward);
		 view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReunionEntity reunionEnt = new ReunionEntity();
		ReunionDao reunionDao = new ReunionDao();
		String forward= "";
		Date fecha_reunion = null;
		Integer id_rn;

		reunionEnt.setAsistente1(request.getParameter("asistente1"));
		reunionEnt.setEn_calidad_de1(request.getParameter("en_calidad_de1"));
		reunionEnt.setAsistente2(request.getParameter("asistente2"));
		reunionEnt.setEn_calidad_de2(request.getParameter("en_calidad_de2"));
		reunionEnt.setAsistente3(request.getParameter("asistente3"));
		reunionEnt.setEn_calidad_de3(request.getParameter("en_calidad_de3"));
		reunionEnt.setAsistente4(request.getParameter("asistente4"));
		reunionEnt.setEn_calidad_de4(request.getParameter("en_calidad_de4"));
		reunionEnt.setAsistente5(request.getParameter("asistente5"));
		reunionEnt.setEn_calidad_de5(request.getParameter("en_calidad_de5"));
		reunionEnt.setConclusiones(request.getParameter("conclusiones"));
		reunionEnt.setTemas_tratados(request.getParameter("temas_tratados"));
		reunionEnt.setLugar_reunion(request.getParameter("lugar_reunion"));
		reunionEnt.setHora_reunion(request.getParameter("hora_reunion"));
		reunionEnt.setCurso(request.getParameter("curso"));
		
		try {
			fecha_reunion = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_reunion"));
			reunionEnt.setFecha_reunion(fecha_reunion);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String id_reunion = request.getParameter("id_reunion");
		if(id_reunion == null || id_reunion.isEmpty()) {
			reunionDao.addReunion(reunionEnt);			
		}else {
			id_rn = Integer.parseInt(request.getParameter("id_reunion"));
			reunionEnt.setId_reunion(id_rn);
			reunionDao.updateReunion(reunionEnt);
		}
		
		forward = VERREUNIONES;
		request.setAttribute("reuniones", reunionDao.getAllReuniones());
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);		
	}
}