package com.casia.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casia.dao.ParteDao;
import com.casia.dao.SancionDao;
import com.casia.entity.SancionEntity;

/**
 * Servlet implementation class RecreoServlet
 */

public class RecreoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ASISTENCIARECREO = "/Recreo.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecreoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SancionDao sancionDao = new SancionDao();
		String forward="";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("asistencia")) {
			forward = ASISTENCIARECREO;
			request.setAttribute("recreo", sancionDao.getAllRecreos());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoPost");
		
		SancionDao sancionDao = new SancionDao();
		String [] Array = request.getParameterValues("asistencia");
		for(int i=0;i<Array.length-1;i++) {
			System.out.println("Array["+i+"] "+Array[i]);
		}
		for (int j=0; j<Array.length; j++) {
			String idAsistencia = Array[j];
			Integer id = Integer.parseInt(idAsistencia);
			System.out.println("idAsistencia " +id);
			sancionDao.updateAsistencia(id);
			System.out.println("Database was updated");
		}
		
		
		ParteDao parteDao = new ParteDao();
		RequestDispatcher view = request.getRequestDispatcher("Partes.jsp");
		request.setAttribute("partesSin", parteDao.getAllPartesSinSanciones());
		request.setAttribute("partes", parteDao.getAllPartes());
		view.forward(request, response);			
		} 


}
