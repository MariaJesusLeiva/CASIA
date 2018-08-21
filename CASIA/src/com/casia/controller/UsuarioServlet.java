package com.casia.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casia.dao.PROADao;
import com.casia.dao.ParteDao;
import com.casia.dao.RecreoDao;
import com.casia.dao.UsuarioDao;
import com.casia.entity.ParteEntity;
import com.casia.entity.UsuarioEntity;

/**
 * Servlet implementation class UsuarioServlet
 */

public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String CREARUSUARIO = "CrearUsuario.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDao usuarioDao = new UsuarioDao();
		
		String forward="";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("crearUsuario")) {
			forward = CREARUSUARIO;
			request.setAttribute("usuarios", usuarioDao.getAllUsuarios());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioEntity usuarioEnt = new UsuarioEntity();
		Integer id_user;
		String rol_user = "directiva";
		String forward= "";
		
		usuarioEnt.setName_user(request.getParameter("name_user"));
		usuarioEnt.setPass_user(request.getParameter("pass_user"));
		usuarioEnt.setRol_user(rol_user);
		
		String id_u = request.getParameter("id_user");
		UsuarioDao usuarioDao = new UsuarioDao();
		
		if(id_u == null || id_u.isEmpty()) {
			List<UsuarioEntity> id;
			id = (List<UsuarioEntity>)usuarioDao.getAllUsuarios();
			Integer id_nuevo = id.size()+1;
			usuarioEnt.setId_user(id_nuevo);
			usuarioDao.addUsuario(usuarioEnt);
			forward = CREARUSUARIO;
			request.setAttribute("usuarios", usuarioDao.getAllUsuarios());
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		} else {
			id_user = Integer.parseInt(request.getParameter("id_user"));			
			usuarioEnt.setId_user(id_user);
			usuarioDao.updateUsuario(usuarioEnt);
			forward = CREARUSUARIO;
			request.setAttribute("usuarios", usuarioDao.getAllUsuarios());
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}	
	}

}
