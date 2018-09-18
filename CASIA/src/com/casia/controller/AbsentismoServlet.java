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

import com.casia.dao.AbsentismoDao;
import com.casia.entity.AbsentismoEntity;

/**
 * Servlet implementation class AbsentismoServlet
 */

public class AbsentismoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VERTODOABS = "Absentismos.jsp";
	private static String VERABSENTISMO = "ConsultarAbsentismo.jsp";
	private static String MODIFICARABSENTISMO = "ModificarAbsentismo.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbsentismoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");
		AbsentismoDao absentismoDao = new AbsentismoDao();
				
		if (action.equalsIgnoreCase("historialAbsentismos")) {
			forward = VERTODOABS;
			request.setAttribute("absentismos", absentismoDao.getAllAbsentismos());
		} else if (action.equalsIgnoreCase("verAbsentismo")) {
			forward = VERABSENTISMO;
			int id_absentismo = Integer.parseInt(request.getParameter("id_absentismo"));
			request.setAttribute("absentismo", absentismoDao.getAbsentismoById(id_absentismo));
		} else if (action.equalsIgnoreCase("modificarAbsentismo")) {
			forward = MODIFICARABSENTISMO;			
			int id_absentismo = Integer.parseInt(request.getParameter("id_absentismo"));
			request.setAttribute("absentismo", absentismoDao.getAbsentismoById(id_absentismo)); 
		} else if (action.equalsIgnoreCase("eliminarAbsentismo")) {
			forward = VERTODOABS;
			int id_absentismo = Integer.parseInt(request.getParameter("id_absentismo"));
			absentismoDao.deleteAbsentismoById(id_absentismo);
			request.setAttribute("absentismos", absentismoDao.getAllAbsentismos());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AbsentismoEntity absentismoEnt = new AbsentismoEntity();
		String forward="";
		Date fecha_nacimiento;		
		Integer id_abs, codigo_absen;
		AbsentismoDao absentismoDao = new AbsentismoDao();		
				
		codigo_absen = Integer.parseInt(request.getParameter("codigo_absen"));
		absentismoEnt.setCodigo_absen(codigo_absen);
		absentismoEnt.setNombre_alum(request.getParameter("nombre_alum"));
		
		try {
			fecha_nacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_nacimiento"));
			absentismoEnt.setFecha_nacimiento(fecha_nacimiento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		absentismoEnt.setCurso(request.getParameter("curso"));		
		absentismoEnt.setGrupo(request.getParameter("grupo"));
		String fase_actual = request.getParameter("fase_actual");
		absentismoEnt.setFase_actual(fase_actual);
		
		absentismoEnt.setFechacarta_faseuno(request.getParameter("fechacarta_faseuno"));
		absentismoEnt.setFechacarta_fasedos(request.getParameter("fechacarta_fasedos"));
		absentismoEnt.setFechacarta_fasetres(request.getParameter("fechacarta_fasetres"));
		absentismoEnt.setFechacarta_fasecuatro(request.getParameter("fechacarta_fasecuatro"));
		
		absentismoEnt.setMes_faseuno(request.getParameter("mes_faseuno"));
		absentismoEnt.setMes_fasedos(request.getParameter("mes_fasedos"));
		absentismoEnt.setMes_fasetres(request.getParameter("mes_fasetres"));
		absentismoEnt.setMes_fasecuatro(request.getParameter("mes_fasecuatro"));
		
		//String totalhoras_faseuno = request.getParameter("totalhoras_faseuno");
		//absentismoEnt.setTotalhoras_faseuno(Integer.parseInt(totalhoras_faseuno));
		//String totalhoras_fasedos = request.getParameter("totalhoras_fasedos");
		//absentismoEnt.setTotalhoras_fasedos(Integer.parseInt(totalhoras_fasedos));
		//String totalhoras_fasetres = request.getParameter("totalhoras_fasetres");
		//absentismoEnt.setTotalhoras_fasetres(Integer.parseInt(totalhoras_fasetres));
		//String totalhoras_fasecuatro = request.getParameter("totalhoras_fasecuatro");
		//absentismoEnt.setTotalhoras_fasecuatro(Integer.parseInt(totalhoras_fasecuatro));
		absentismoEnt.setTotalhoras_faseuno(request.getParameter("totalhoras_faseuno"));
		absentismoEnt.setTotalhoras_fasedos(request.getParameter("totalhoras_fasedos"));		
		absentismoEnt.setTotalhoras_fasetres(request.getParameter("totalhoras_fasetres"));
		absentismoEnt.setTotalhoras_fasecuatro(request.getParameter("totalhoras_fasecuatro"));
		
		absentismoEnt.setJustificada_faseuno(request.getParameter("justificada_faseuno"));
		absentismoEnt.setJustificada_fasedos(request.getParameter("justificada_fasedos"));
		absentismoEnt.setJustificada_fasetres(request.getParameter("justificada_fasetres"));
		
		absentismoEnt.setObservacion_faseuno(request.getParameter("observacion_faseuno"));
		absentismoEnt.setObservacion_fasedos(request.getParameter("observacion_fasedos"));
		absentismoEnt.setObservacion_fasetres(request.getParameter("observacion_fasetres"));
		absentismoEnt.setObservacion_fasecuatro(request.getParameter("observacion_fasecuatro"));		
		
		absentismoEnt.setHoracita_fasedos(request.getParameter("horacita_fasedos"));
		absentismoEnt.setHoracita_fasetres(request.getParameter("horacita_fasetres"));
		
		absentismoEnt.setAcude_fasedos(request.getParameter("acude_fasedos"));
		absentismoEnt.setAcude_fasetres(request.getParameter("acude_fasetres"));
		
		absentismoEnt.setJustificadacita_fasedos(request.getParameter("justificadacita_fasedos"));
		absentismoEnt.setJustificadacita_fasetres(request.getParameter("justificadacita_fasetres"));
		
		absentismoEnt.setCompromiso_fasedos(request.getParameter("compromiso_fasedos"));		
		absentismoEnt.setCompromiso_fasetres(request.getParameter("compromiso_fasetres"));
				
		absentismoEnt.setFechacita_fasedos(request.getParameter("fechacita_fasedos"));
		absentismoEnt.setFechacita_fasetres(request.getParameter("fechacita_fasetres"));
		
		absentismoEnt.setCaso_resuelto(request.getParameter("caso_resuelto"));
		absentismoEnt.setMayor_edad(request.getParameter("mayor_edad"));
		
		String id_absentismo = request.getParameter("id_absentismo");
		if(id_absentismo == null || id_absentismo.isEmpty()) {
			absentismoDao.addAbsentismo(absentismoEnt);
		} else {
			id_abs = Integer.parseInt(request.getParameter("id_absentismo"));
			absentismoEnt.setId_absentismo(id_abs);
			absentismoDao.updateAbsentismo(absentismoEnt);		
		}
		
		forward = VERTODOABS;
		request.setAttribute("absentismos", absentismoDao.getAllAbsentismos());
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);		
	}
}