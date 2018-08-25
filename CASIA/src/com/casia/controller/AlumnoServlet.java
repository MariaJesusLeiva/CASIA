package com.casia.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.casia.dao.AbsentismoDao;
import com.casia.dao.AcosoDao;
import com.casia.dao.ActMedicaDao;
import com.casia.dao.AlumnoDao;
import com.casia.dao.InfJuridicaDao;
import com.casia.dao.InfMedicaDao;
import com.casia.dao.ParteDao;
import com.casia.dao.ReunionDao;
import com.casia.dao.SancionDao;

/**
 * Servlet implementation class AlumnoServlet
 */

public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String RESULTADO = "AlumnoBuscado.jsp"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward= "";
		HttpSession session = request.getSession();
		AlumnoDao alumDao = new AlumnoDao();
		
		
		String nombre_alum = request.getParameter("nombre_alum");
		System.out.println("alumno buscado: " + nombre_alum);
		
		forward = RESULTADO;
		session.setAttribute("nombre_alum", nombre_alum);
		request.setAttribute("alumabs", alumDao.getAlumAbsentismo(nombre_alum));
		request.setAttribute("alumacoso", alumDao.getAlumAcoso(nombre_alum));
		request.setAttribute("alumactmedica", alumDao.getAlumActMedica(nombre_alum));
		request.setAttribute("aluminfjur", alumDao.getAlumInfJuridica(nombre_alum));
		request.setAttribute("aluminfmedica", alumDao.getAlumInfMedica(nombre_alum));
		request.setAttribute("alumparte", alumDao.getAlumParte(nombre_alum));
		request.setAttribute("alumsancion", alumDao.getAlumSancion(nombre_alum));
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
