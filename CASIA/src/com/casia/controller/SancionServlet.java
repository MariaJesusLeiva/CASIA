package com.casia.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

public class SancionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static String CREARSANCION = "CrearSancion.jsp";
	private static String VERSANCIONESSINDIAS = "SancionesSinDias.jsp";
	private static String HISTORIAL = "Sanciones.jsp";
	private static String VERSANCION = "ConsultarSancion.jsp";
	private static String MODIFICARSANCION = "ModificarSancion.jsp";
	
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
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("crearSancion"))
		{
			forward = CREARSANCION;
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
		
		} else if (action.equalsIgnoreCase("verSancionesSinDias")) {
			forward = VERSANCIONESSINDIAS;
			request.setAttribute("sancionSin", sancionDao.getAllSancionesSinDias());
			request.setAttribute("sanciones", reservaDao.getAllRecreoPROA());
			
		} else if (action.equalsIgnoreCase("historialSanciones")) {
			forward = HISTORIAL;
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
		Integer id_snc;
		
		String id_parte = request.getParameter("id_parte");
		sancionEnt.setId_parte(Integer.parseInt(id_parte));						
		sancionEnt.setTipo_sancion(request.getParameter("tipo_sancion"));
		sancionEnt.setObservacion(request.getParameter("observacion"));
		sancionEnt.setTrabajo(request.getParameter("trabajo"));
		sancionEnt.setAsistencia(request.getParameter("asistencia"));
		sancionEnt.setNombre_alum(request.getParameter("nombre_alum"));
		
		String id_sancion = request.getParameter("id_sancion");
		SancionDao sancionDao = new SancionDao();
		
		if(id_sancion == null || id_sancion.isEmpty()) {

			List<SancionEntity> id;
			id = (List<SancionEntity>)sancionDao.getAllSanciones();
			Integer id_nuevo = id.size()+1;
			sancionEnt.setId_sancion(id_nuevo);
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
				
				if(total_dias != null) {
					sancionDao.updateAsignadoDias(id_s); 
					System.out.println("Cambiado el asignado dia");
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
				
				forward = HISTORIAL;
				request.setAttribute("sanciones", sancionDao.getAllSanciones());
				RequestDispatcher view = request.getRequestDispatcher(forward);
		        view.forward(request, response);
		        
			} else {

				// Para actualizar el campo tipo_sancion de la tabla parte
				ParteDao parteDao = new ParteDao();
				Integer id_p = Integer.parseInt(request.getParameter("id_parte"));
				parteDao.updateSancionParte(id_p);
				forward = VERSANCIONESSINDIAS;
				ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
				RequestDispatcher view = request.getRequestDispatcher(forward);
				request.setAttribute("sancionSin", sancionDao.getAllSancionesSinDias());
				request.setAttribute("sanciones", reservaDao.getAllRecreoPROA());
				view.forward(request, response);
			}
			
		} else {
			System.out.println("Entro en el else");
			id_snc = Integer.parseInt(request.getParameter("id_sancion"));			
			sancionEnt.setId_sancion(id_snc);
			sancionDao.updateSancion(sancionEnt);
			String total_dias = request.getParameter("total_dias");
			System.out.println("total_dias " + total_dias);
			sancionEnt.setTotal_dias(Integer.parseInt(total_dias));
			String tipo_sancion =  request.getParameter("tipo_sancion");
			System.out.println("tipo_sancion "+tipo_sancion);
			
			if(tipo_sancion.equals("Seleccionar")) {
				request.setAttribute("errMessage", "Seleccionar sanción");
				
			} else if (tipo_sancion.equals("Expulsión")) {
				int id_p = Integer.parseInt(request.getParameter("id_parte"));
				int id_s = sancionDao.getIdSancionByIdParte(id_p);
				sancionEnt.setId_sancion(id_s);
				
				if(total_dias != null) {
					sancionDao.updateAsignadoDias(id_s); 
					System.out.println("Cambiado el asignado dia");
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
				
				forward = HISTORIAL;
				request.setAttribute("sanciones", sancionDao.getAllSanciones());
				RequestDispatcher view = request.getRequestDispatcher(forward);
		        view.forward(request, response);
		        
			} else {

				// Para actualizar el campo tipo_sancion de la tabla parte
				ParteDao parteDao = new ParteDao();
				Integer id_p = Integer.parseInt(request.getParameter("id_parte"));
				parteDao.updateSancionParte(id_p);

				forward = VERSANCIONESSINDIAS;
				ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
				RequestDispatcher view = request.getRequestDispatcher(forward);
				request.setAttribute("sancionSin", sancionDao.getAllSancionesSinDias());
				request.setAttribute("sanciones", reservaDao.getAllRecreoPROA());
				view.forward(request, response);
			}
		}		
	}
}