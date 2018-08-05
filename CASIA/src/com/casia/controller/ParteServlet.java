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
import com.casia.entity.ParteEntity;

/**
 * Servlet implementation class ParteServlet
 */

public class ParteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String CONSULTAR = "/Parte.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ParteDao parteDao = new ParteDao();
		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("consultar")) {
			forward = CONSULTAR;
			request.setAttribute("partesSin", parteDao.getAllPartesSinSanciones());
			request.setAttribute("partes", parteDao.getAllPartes());
		}

		RequestDispatcher view = request.getRequestDispatcher("Partes.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*ParteEntity parteEnt = new ParteEntity();
		ParteDao parteDao = new ParteDao();
		String id_parte = request.getParameter("id_parte");
		String codigo = request.getParameter("codigo");
		String sancion = request.getParameter("sancion");
		String grupo = request.getParameter("grupo");
		String nombre_alum = request.getParameter("nombre_alum");
		try {
			Date fecha_parte = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fecha_parte"));
			parteEnt.setFecha_parte(fecha_parte);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parteEnt.setCodigo(Integer.parseInt(codigo));		
		parteEnt.setGrupo(grupo);
		parteEnt.setNombre_alum(nombre_alum);
		parteEnt.setSancion(sancion);
		if(id_parte == null || id_parte.isEmpty()) {
			
			parteDao.addParte(parteEnt);
		}
		RequestDispatcher view = request.getRequestDispatcher("Principal.jsp");
        //request.setAttribute("partes", parteDao.getAllPartes());
        view.forward(request, response);*/
		ParteEntity parteEnt = new ParteEntity();
		Date fecha_parte = null;
		Integer codigo, id_parte;
		
		codigo = Integer.parseInt(request.getParameter("codigo"));
		parteEnt.setCodigo(codigo);
		parteEnt.setNombre_profe(request.getParameter("nombre_profe"));
		parteEnt.setNombre_alum(request.getParameter("nombre_alum"));
		parteEnt.setGrupo(request.getParameter("grupo"));
		parteEnt.setMotivo_parte(request.getParameter("motivo_parte"));
		
		try {
            fecha_parte = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("fecha_parte"));
            parteEnt.setFecha_parte(fecha_parte);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		/*try {
            fecha_inicio = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("fecha_inicio"));
            parteEnt.setFecha_inicio(fecha_inicio);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		try {
            fecha_fin = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("fecha_fin"));
            parteEnt.setFecha_fin(fecha_fin);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        total_dias = Integer.parseInt(request.getParameter("total_dias"));
		parteEnt.setTotal_dias(total_dias);*/
		List<ParteEntity> id;
		ParteDao parteDao = new ParteDao();
		id = (List<ParteEntity>)parteDao.getAllPartes();
		id_parte = id.size()+1;
		parteEnt.setId_parte(id_parte);
		parteDao.addParte(parteEnt);
        System.out.println("id "+parteEnt.getId_parte());    
            	
            	/*RecreoEntity recreoEnt = new RecreoEntity();
            	RecreoDao recreoDao = new RecreoDao();
            	recreoEnt.setId_parte(id_parte);
            	recreoEnt.setFecha_inicio(fecha_inicio);
            	recreoDao.addRecreo(recreoEnt);*/
		RequestDispatcher view = request.getRequestDispatcher("Partes.jsp");
        request.setAttribute("partes", parteDao.getAllPartes());
        request.setAttribute("partesSin", parteDao.getAllPartesSinSanciones());
        view.forward(request, response);
	}
	

}
