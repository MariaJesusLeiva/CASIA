package com.casia.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casia.config.conexionDB;
import com.casia.dao.ReservaDiaSancionDao;
import com.casia.entity.ReservaDiaSancionEntity;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

/**
 * Servlet implementation class InformeRecreoServlet
 */

public class InformeRecreoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VERINFRECREO = "CrearInformeRecreo.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformeRecreoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		ReservaDiaSancionDao reservaDao = new ReservaDiaSancionDao();
		
		if (action.equalsIgnoreCase("verInfRecreo")) {
			forward = VERINFRECREO;
			request.setAttribute("recreos", reservaDao.getAllRecreosPendientes());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/pdf");
		ReservaDiaSancionEntity reserva = new ReservaDiaSancionEntity();
		Date fecha_inicio = null;

		try {
			fecha_inicio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_inicio"));
			reserva.setFecha_inicio(fecha_inicio);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String fechatitulo = new SimpleDateFormat("dd-MM-yyyy").format(fecha_inicio);

		OutputStream out = response.getOutputStream();
		try {
			Connection connection = conexionDB.getConnection();
			java.sql.Date fecha;
			fecha = new java.sql.Date(reserva.getFecha_inicio().getTime());
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM reservadiasancion WHERE tipo_sancion= 'Recreo' AND fecha_inicio='" + fecha + "'");
			ResultSet rs = preparedStatement.executeQuery();

			try {
				Document documento = new Document();
				PdfWriter.getInstance(documento, out);

				documento.open();

				Paragraph part1 = new Paragraph();

				Font fonttitulo = new Font(Font.FontFamily.HELVETICA, 25, Font.BOLD, BaseColor.BLUE);
				Font fonttitulo2 = new Font(Font.FontFamily.HELVETICA, 20, Font.NORMAL, BaseColor.BLUE);
				
				part1.add(new Phrase("RECREO", fonttitulo));
				
				part1.add(new Phrase(Chunk.NEWLINE));// Para salto de linea
				part1.add(new Phrase(Chunk.NEWLINE));
				
				part1.add(new Phrase(fechatitulo, fonttitulo2));
				part1.setAlignment(Element.ALIGN_CENTER);
				
				part1.add(new Phrase(Chunk.NEWLINE));
				part1.add(new Phrase(Chunk.NEWLINE));
				part1.add(new Phrase(Chunk.NEWLINE));
				part1.add(new Phrase(Chunk.NEWLINE));
				part1.add(new Phrase(Chunk.NEWLINE));

				documento.add(part1);

				PdfPTable tabla = new PdfPTable(4);
				tabla.setTotalWidth(new float[] { 200, 38, 48, 300 });
				tabla.setLockedWidth(true);

				PdfPCell celda1 = new PdfPCell(
						new Paragraph("Alumno", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK)));
				PdfPCell celda2 = new PdfPCell(
						new Paragraph("Asiste", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK)));
				PdfPCell celda3 = new PdfPCell(
						new Paragraph("Trabaja", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK)));
				PdfPCell celda4 = new PdfPCell(
						new Paragraph("Observación", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK)));

				celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda4.setHorizontalAlignment(Element.ALIGN_CENTER);

				celda1.setBackgroundColor(new BaseColor(214, 214, 214));
				celda2.setBackgroundColor(new BaseColor(214, 214, 214));
				celda3.setBackgroundColor(new BaseColor(214, 214, 214));
				celda4.setBackgroundColor(new BaseColor(214, 214, 214));
				
				tabla.addCell(celda1);
				tabla.addCell(celda2);
				tabla.addCell(celda3);
				tabla.addCell(celda4);

				while (rs.next()) {
					tabla.addCell(rs.getString(4));
					tabla.addCell("");
					tabla.addCell("");
					tabla.addCell("");
				}
				documento.add(tabla);

				documento.close();
			} catch (Exception ex) {
				ex.getMessage();
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
}