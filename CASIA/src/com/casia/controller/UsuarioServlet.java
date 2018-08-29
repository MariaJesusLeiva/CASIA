package com.casia.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casia.dao.UsuarioDao;
import com.casia.entity.UsuarioEntity;

/**
 * Servlet implementation class UsuarioServlet
 */

public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String CREARUSUARIO = "AdmCrearUsuario.jsp";
	private static String MODIFICARUSUARIO = "AdmModificarUsuario.jsp";
       
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
		} else if (action.equalsIgnoreCase("modificarUsuario")) {
			forward = MODIFICARUSUARIO;
			int id_user = Integer.parseInt(request.getParameter("id_user"));
			request.setAttribute("usuario", usuarioDao.getUsuarioById(id_user));
			request.setAttribute("usuarios", usuarioDao.getAllUsuarios());
		} else if (action.equalsIgnoreCase("eliminarUsuario")) {
			forward = CREARUSUARIO;
			int id_user = Integer.parseInt(request.getParameter("id_user"));
			usuarioDao.deleteUsuarioById(id_user);
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
		String pass2 = null;
		
		
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
			System.out.println("contraseña crear: "+ request.getParameter("pass_user"));
			usuarioDao.addUsuario(usuarioEnt);
			forward = CREARUSUARIO;
			request.setAttribute("usuarios", usuarioDao.getAllUsuarios());
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		} else {
			id_user = Integer.parseInt(request.getParameter("id_user"));
			System.out.println("contraseña: "+ request.getParameter("pass_user"));
			usuarioEnt.setId_user(id_user);
			usuarioDao.updateUsuario(usuarioEnt);
			forward = CREARUSUARIO;
			request.setAttribute("usuarios", usuarioDao.getAllUsuarios());
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}	
	}

}
