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

import com.casia.dao.AcosoDao;
import com.casia.entity.AcosoEntity;

/**
 * Servlet implementation class AcosoServlet
 */

public class AcosoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VERACOSOS = "ProtocolosAcoso.jsp";
	private static String VERACOSO = "ConsultarProtocoloAcoso.jsp";
	private static String MODIFICARACOSO = "ModificarProtocoloAcoso.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcosoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AcosoDao acosoDao = new AcosoDao();
		String forward="";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("verAcosos")) {
			forward = VERACOSOS;
			request.setAttribute("acosos", acosoDao.getAllAcosos());
		} else if (action.equalsIgnoreCase("verAcoso")){
			forward = VERACOSO;
			int id_acoso = Integer.parseInt(request.getParameter("id_acoso"));
			request.setAttribute("acoso", acosoDao.getAcosoById(id_acoso));
		} else if (action.equalsIgnoreCase("modificarAcoso")) {
			forward = MODIFICARACOSO;			
			int id_acoso = Integer.parseInt(request.getParameter("id_acoso"));
			request.setAttribute("acoso", acosoDao.getAcosoById(id_acoso));			
		} else if (action.equalsIgnoreCase("eliminarAcoso")) {
			forward = VERACOSOS;
			int id_acoso = Integer.parseInt(request.getParameter("id_acoso"));
			acosoDao.deleteAcosoById(id_acoso);
			request.setAttribute("acosos", acosoDao.getAllAcosos());			
		} 
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AcosoEntity acosoEnt = new AcosoEntity();
		AcosoDao acosoDao = new AcosoDao();
		String forward= "";
		Date fecha_reunion = null;
		Integer id_acoso;
		
		String codigo = request.getParameter("codigo");
		acosoEnt.setCodigo(Integer.parseInt(codigo));
		acosoEnt.setCurso(request.getParameter("curso"));
		acosoEnt.setHora_reunion(request.getParameter("hora_reunion"));
		acosoEnt.setGrupo(request.getParameter("grupo"));
		acosoEnt.setGrupo2(request.getParameter("grupo2"));
		acosoEnt.setTipo(request.getParameter("tipo"));
		acosoEnt.setTipo2(request.getParameter("tipo2"));
		acosoEnt.setNombre_alum(request.getParameter("nombre_alum"));
		acosoEnt.setNombre_alum2(request.getParameter("nombre_alum2"));				
		acosoEnt.setInf_aportada(request.getParameter("inf_aportada"));
		acosoEnt.setMedidas(request.getParameter("medidas"));
		acosoEnt.setAsistentes(request.getParameter("asistentes"));
		acosoEnt.setInicio_protocolo(request.getParameter("inicio_protocolo"));
		
		try {
			fecha_reunion = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_reunion"));
			acosoEnt.setFecha_reunion(fecha_reunion);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String id_acs = request.getParameter("id_acoso");
		if(id_acs == null || id_acs.isEmpty()) {
			acosoDao.addAcoso(acosoEnt);			
		} else {
			id_acoso = Integer.parseInt(request.getParameter("id_acoso"));
			acosoEnt.setId_acoso(id_acoso);
			acosoDao.updateAcoso(acosoEnt);
		}
		
		forward = VERACOSOS;
		request.setAttribute("acosos", acosoDao.getAllAcosos());
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}