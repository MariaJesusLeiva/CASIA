package com.casia.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.casia.dao.ParteDao;
import com.casia.dao.RecreoDao;
import com.casia.dao.ReservaDiaSancionDao;
import com.casia.dao.SancionDao;
import com.casia.entity.ParteEntity;
import com.casia.entity.RecreoEntity;
import com.casia.entity.SancionEntity;


/**
 * Servlet implementation class SancionServlet
 */

public class SancionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static String ASIGNAR = "/CrearSancion.jsp";
	private static String ASIGNADODIAS = "/AsignarDiasSancion.jsp";
	private static String VERSANCIONESSINDIAS = "/SancionesSinDias.jsp";
	private static String HISTORIAL = "/Sanciones.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SancionServlet()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		SancionDao sancionDao = new SancionDao();
		ParteDao parteDao = new ParteDao();
		ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
		ParteEntity parteEnt = new ParteEntity();
		SancionEntity sancionEnt = new SancionEntity();
		String forward="";
		Integer codigoparte;
		String alumsancion, profesancion;
		HttpSession session = request.getSession(); //Se ha sacado del if de asignar, pendiente de que no falle en un futuro
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("asignar"))
		{
			forward = ASIGNAR;
            int id_parte = Integer.parseInt(request.getParameter("id_parte"));            
			request.setAttribute("sancion", sancionDao.getParteById(id_parte));
			
			//Para mostrar el nombre del alumno al cual se está seleccionando la sanción			
			parteEnt = parteDao.getAlumSancionByIdParte(id_parte);
			alumsancion = parteEnt.getNombre_alum();
			profesancion = parteEnt.getNombre_profe();
			codigoparte = parteEnt.getCodigo();
			System.out.println("Nombre alum "+alumsancion); 
			session.setAttribute("alumsancion", alumsancion);
			session.setAttribute("profesancion", profesancion);
			session.setAttribute("codigoparte", codigoparte);
			request.setAttribute("sanciones", sancionDao.getAllSanciones());
		
		} else if (action.equalsIgnoreCase("asignadoDias")) {
			forward = ASIGNADODIAS;
			int id_sancion = Integer.parseInt(request.getParameter("id_sancion"));
			sancionDao.updateAsignadoDias(id_sancion);   
			alumsancion = sancionEnt.getNombre_alum();
			session.setAttribute("alumsancion", alumsancion);
			request.setAttribute("sancion", sancionDao.getSancionById(id_sancion));
			
		} else if (action.equalsIgnoreCase("verSancionesSinDias")) {
			forward = VERSANCIONESSINDIAS;
			request.setAttribute("sancionSin", sancionDao.getAllSancionesSinDias());
			request.setAttribute("sanciones", reservaDao.getAllRecreoPROA());
			
		} else if (action.equalsIgnoreCase("verSancionesSinDias")) {
			forward = HISTORIAL;
			request.setAttribute("sanciones", sancionDao.getAllSanciones());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
		//request.setAttribute("sanciones", sancionDao.getAllSanciones());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		SancionEntity sancionEnt = new SancionEntity();
		Date fecha_inicio = null;
		Date fecha_fin = null;
		String forward="";
				
		sancionEnt.setTipo_sancion(request.getParameter("tipo_sancion"));
		String id_parte = request.getParameter("id_parte");
		sancionEnt.setId_parte(Integer.parseInt(id_parte));
		sancionEnt.setObservacion(request.getParameter("observacion"));
		sancionEnt.setTrabajo(request.getParameter("trabajo"));
		sancionEnt.setAsistencia(request.getParameter("asistencia"));
		sancionEnt.setNombre_alum(request.getParameter("nombre_alum"));
		SancionDao sancionDao = new SancionDao();
		sancionDao.addSancion(sancionEnt);
		System.out.println("Sancion creada");

		String tipo_sancion =  request.getParameter("tipo_sancion");
		System.out.println("tipo_sancion "+tipo_sancion);
		if (tipo_sancion.equals("Expulsión")) {
			int id_p = Integer.parseInt(request.getParameter("id_parte"));
			int id_s = sancionDao.getIdSancionByIdParte(id_p);
			sancionEnt.setId_sancion(id_s);
			String total_dias = request.getParameter("total_dias");
			System.out.println("total_dias " + total_dias);
			sancionEnt.setTotal_dias(Integer.parseInt(total_dias));

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
			sancionDao.updateSancion(sancionEnt);
			
			forward = HISTORIAL;
			request.setAttribute("sanciones", sancionDao.getAllSanciones());
			RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
		}else {
		//Para actualizar el campo tipo_sancion de la tabla parte
		ParteDao parteDao = new ParteDao();
		Integer id_p = Integer.parseInt(request.getParameter("id_parte"));
		parteDao.updateSancionParte(id_p);

		
		/*//Para crear varios recreos
		String tipo_sancion = (request.getParameter("tipo_sancion"));
		String id_s = request.getParameter("id_sancion");

		if(tipo_sancion.equals("recreo")) {
			
			RecreoEntity recreoEnt = new RecreoEntity();
			recreoEnt.setAsistencia(request.getParameter("asistencia"));
			recreoEnt.setNombre_alum(request.getParameter("nombre_alum"));
			recreoEnt.setFecha_inicio(fecha_inicio);
			recreoEnt.setObservacion(request.getParameter("observacion"));
			recreoEnt.setTrabajo(request.getParameter("trabajo"));
			
			Integer id_sancion;
			if(id_s == null || id_s.isEmpty()) {
				List<SancionEntity> id;
				id = (List<SancionEntity>)sancionDao.getAllSanciones();
				System.out.println("id de lista "+id.size()); 
				id_sancion = id.size()+1;
				recreoEnt.setId_sancion(id_sancion);
			} else {
				id_sancion = Integer.parseInt(request.getParameter("id_sancion"));			
				recreoEnt.setId_sancion(id_sancion);
			}
			for(int i = 0; i<total_dias;i++) {
		      Calendar calendar = Calendar.getInstance();
		      calendar.setTime(fecha_inicio);
		      calendar.add(Calendar.DAY_OF_YEAR, i);
		      System.out.println("Nueva fecha: "+fecha_inicio);
		      recreoEnt.setFecha_inicio(fecha_inicio);
		      recreoEnt.setId_sancion(id_sancion);
		      
		      RecreoDao.addRecreo(recreoEnt);
			}
		}*/	
		ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
		RequestDispatcher view = request.getRequestDispatcher("SancionesSinDias.jsp");
		request.setAttribute("sancionSin", sancionDao.getAllSancionesSinDias());
		request.setAttribute("sanciones", reservaDao.getAllRecreoPROA());
		view.forward(request, response);
		}
	}
}
