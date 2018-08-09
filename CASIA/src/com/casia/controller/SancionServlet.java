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
import javax.servlet.http.HttpSession;

import com.casia.dao.ParteDao;
import com.casia.dao.SancionDao;
import com.casia.entity.ParteEntity;
import com.casia.entity.SancionEntity;


/**
 * Servlet implementation class SancionServlet
 */

public class SancionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ASIGNAR = "/Sancion.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SancionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SancionDao sancionDao = new SancionDao();
		ParteDao parteDao = new ParteDao();
		ParteEntity parteEnt = new ParteEntity();
		String forward="";
		String alumsancion, profesancion;
		HttpSession session = request.getSession(); //Se ha sacado del if de asignar, pendiente de que no falle en un futuro
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("asignar")){
			forward = ASIGNAR;
            int id_parte = Integer.parseInt(request.getParameter("id_parte"));            
			request.setAttribute("sancion", sancionDao.getParteById(id_parte));
			
			//Para mostrar el nombre del alumno al cual se está seleccionando la sanción			
			parteEnt = parteDao.getAlumSancionByIdParte(id_parte);
			alumsancion = parteEnt.getNombre_alum();
			profesancion = parteEnt.getNombre_profe();
			System.out.println("Nombre alum "+alumsancion); 
			session.setAttribute("alumsancion", alumsancion);
			session.setAttribute("profesancion", profesancion);
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SancionEntity sancionEnt = new SancionEntity();
		Date fecha_inicio = null;
		Date fecha_fin = null;
		Integer total_dias;		

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

		total_dias = Integer.parseInt(request.getParameter("total_dias"));
		sancionEnt.setTotal_dias(total_dias);
		sancionEnt.setTipo_sancion(request.getParameter("tipo_sancion"));
		String id_parte = request.getParameter("id_parte");
		sancionEnt.setId_parte(Integer.parseInt(id_parte));
		sancionEnt.setObservacion(request.getParameter("observacion"));
		sancionEnt.setTrabajo(request.getParameter("trabajo"));
		sancionEnt.setAsistencia(request.getParameter("asistencia"));
		SancionDao sancionDao = new SancionDao();
		sancionDao.addSancion(sancionEnt);
		System.out.println("Sancion creada");
		
		//Para actualizar el campo tipo_sancion de la tabla parte
		ParteDao parteDao = new ParteDao();
		Integer id_p = Integer.parseInt(request.getParameter("id_parte"));
		parteDao.updateSancionParte(id_p);
		RequestDispatcher view = request.getRequestDispatcher("Partes.jsp");
		request.setAttribute("partesSin", parteDao.getAllPartesSinSanciones());
		request.setAttribute("partes", parteDao.getAllPartes());
		view.forward(request, response);
		
	}
}
