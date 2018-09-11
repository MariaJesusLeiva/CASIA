package com.casia.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.casia.config.conexionDB;
import com.casia.dao.AbsentismoDao;
import com.casia.entity.AbsentismoEntity;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class InformeAbsentismoServlet
 */

public class InformeAbsentismoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VERINFABS = "CrearInformeAbsentismo.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformeAbsentismoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		AbsentismoDao absentismoDao = new AbsentismoDao();
		
		if (action.equalsIgnoreCase("verInfAbsentismo")) {
			forward = VERINFABS;
			request.setAttribute("abs", absentismoDao.getAllAbsentismos());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		AbsentismoEntity absentismo = new AbsentismoEntity();
		absentismo.setCurso(request.getParameter("curso"));	
		absentismo.setMes_faseuno(request.getParameter("mes"));
		
		OutputStream out = response.getOutputStream();
		try {
			Connection connection = conexionDB.getConnection();			
			String curso = request.getParameter("curso");
			String mes = request.getParameter("mes");
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM absentismo WHERE curso= '" + curso + "' AND mes_faseuno='" + mes + "' OR mes_fasedos='" + mes + "' OR mes_fasetres='" + mes + "' OR mes_fasecuatro= '"+ mes + "'");
			ResultSet rs = preparedStatement.executeQuery();

			try {
				Document documento = new Document();
				PdfWriter.getInstance(documento, out);

				documento.open();

				Paragraph part1 = new Paragraph();

				Font fonttitulo = new Font(Font.FontFamily.HELVETICA, 25, Font.BOLD, BaseColor.BLACK);
				Font fonttitulo2 = new Font(Font.FontFamily.HELVETICA, 20, Font.NORMAL, BaseColor.BLACK);
				Font fonttitulo3 = new Font(Font.FontFamily.HELVETICA, 20, Font.NORMAL, BaseColor.BLUE);
				
				part1.add(new Phrase("Control mensual de absentismo", fonttitulo));
				part1.setAlignment(Element.ALIGN_CENTER);
				part1.add(new Phrase(Chunk.NEWLINE));// Para salto de linea
				part1.add(new Phrase(Chunk.NEWLINE));
				Paragraph part2 = new Paragraph();
				part2.add(new Phrase("Curso: ", fonttitulo2));
				part2.add(new Phrase(curso, fonttitulo3));				
				part2.add(new Phrase(Chunk.NEWLINE));
				part2.add(new Phrase(Chunk.NEWLINE));
				part2.add(new Phrase("Mes: ", fonttitulo2));
				part2.add(new Phrase(mes, fonttitulo3));
				part2.setAlignment(Element.ALIGN_LEFT);	
				part2.add(new Phrase(Chunk.NEWLINE));
				part2.add(new Phrase(Chunk.NEWLINE));

				documento.add(part1);
				documento.add(part2);

				PdfPTable tabla = new PdfPTable(6);
				tabla.setTotalWidth(new float[] { 200, 50, 70, 70, 70, 70});
				tabla.setLockedWidth(true);

				PdfPCell celda1 = new PdfPCell(
						new Paragraph("Alumno", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK)));
				PdfPCell celda2 = new PdfPCell(
						new Paragraph("Fase Actual", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK)));
				PdfPCell celda3 = new PdfPCell(
						new Paragraph("Mes Fase 1", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK)));
				PdfPCell celda4 = new PdfPCell(
						new Paragraph("Mes Fase 2", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK)));
				PdfPCell celda5 = new PdfPCell(
						new Paragraph("Mes Fase 3", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK)));
				PdfPCell celda6 = new PdfPCell(
						new Paragraph("Mes Fase 4", FontFactory.getFont("Arial", 10, Font.BOLD, BaseColor.BLACK)));

				celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda6.setHorizontalAlignment(Element.ALIGN_CENTER);

				celda1.setBackgroundColor(new BaseColor(214, 214, 214));
				celda2.setBackgroundColor(new BaseColor(70, 100, 200));
				celda3.setBackgroundColor(new BaseColor(214, 214, 214));
				celda4.setBackgroundColor(new BaseColor(214, 214, 214));
				celda5.setBackgroundColor(new BaseColor(214, 214, 214));
				celda6.setBackgroundColor(new BaseColor(214, 214, 214));
				
				tabla.addCell(celda1);
				tabla.addCell(celda2);
				tabla.addCell(celda3);
				tabla.addCell(celda4);
				tabla.addCell(celda5);
				tabla.addCell(celda6);

				while (rs.next()) {
					tabla.addCell(rs.getString(5));
					tabla.addCell(rs.getString(36));
					tabla.addCell(rs.getString(7));
					tabla.addCell(rs.getString(12));
					tabla.addCell(rs.getString(22));
					tabla.addCell(rs.getString(32));
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