package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.ReunionEntity;
import com.casia.entity.SancionEntity;

public class ReunionDao {
	
	private static Connection connection;
	
	public ReunionDao() {
		connection = conexionDB.getConnection();
	}

	public List<ReunionEntity> getAllReuniones() {
		List<ReunionEntity> reuniones = new ArrayList<ReunionEntity>();
		try	{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM reunion " + 
										"ORDER BY fecha_reunion DESC");
			
			while (rs.next()) {
				ReunionEntity reunion = new ReunionEntity();
				reunion.setId_reunion(rs.getInt("id_reunion"));
				reunion.setCurso(rs.getString("curso"));
				reunion.setFecha_reunion(rs.getDate("fecha_reunion"));
				reunion.setHora_reunion(rs.getString("hora_reunion"));
				reunion.setLugar_reunion(rs.getString("lugar_reunion"));
				reunion.setAsistente1(rs.getString("asistente1"));
				reunion.setEn_calidad_de1(rs.getString("en_calidad_de1"));
				reunion.setAsistente2(rs.getString("asistente2"));
				reunion.setEn_calidad_de2(rs.getString("en_calidad_de2"));
				reunion.setAsistente3(rs.getString("asistente3"));
				reunion.setEn_calidad_de3(rs.getString("en_calidad_de3"));
				reunion.setAsistente4(rs.getString("asistente4"));
				reunion.setEn_calidad_de4(rs.getString("en_calidad_de4"));
				reunion.setAsistente5(rs.getString("asistente1"));
				reunion.setEn_calidad_de5(rs.getString("en_calidad_de1"));
				reunion.setTemas_tratados(rs.getString("temas_tratados"));
				reunion.setConclusiones(rs.getString("conclusiones"));
				
				reuniones.add(reunion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reuniones;
	}

	public void addReunion(ReunionEntity reunionEnt) {
		try	{
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO reunion(curso, fecha_reunion, hora_reunion, lugar_reunion, " +
							"asistente1, en_calidad_de1, asistente2, en_calidad_de2, asistente3, en_calidad_de3, " +
							"asistente4, en_calidad_de4, asistente5, en_calidad_de5, temas_tratados, conclusiones) " +
							"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, reunionEnt.getCurso());
			preparedStatement.setDate(2, new java.sql.Date(reunionEnt.getFecha_reunion().getTime()));
			preparedStatement.setString(3, reunionEnt.getHora_reunion());
			preparedStatement.setString(4, reunionEnt.getLugar_reunion());
			preparedStatement.setString(5, reunionEnt.getAsistente1());
			preparedStatement.setString(6, reunionEnt.getEn_calidad_de1());
			preparedStatement.setString(7, reunionEnt.getAsistente1());
			preparedStatement.setString(8, reunionEnt.getEn_calidad_de1());
			preparedStatement.setString(9, reunionEnt.getAsistente2());
			preparedStatement.setString(10, reunionEnt.getEn_calidad_de2());
			preparedStatement.setString(11, reunionEnt.getAsistente3());
			preparedStatement.setString(12, reunionEnt.getEn_calidad_de3());
			preparedStatement.setString(13, reunionEnt.getAsistente4());
			preparedStatement.setString(14, reunionEnt.getEn_calidad_de4());
			preparedStatement.setString(15, reunionEnt.getTemas_tratados());
			preparedStatement.setString(16, reunionEnt.getConclusiones());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void updateReunion(ReunionEntity reunionEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE reunion SET curso=?, fecha_reunion=?, lugar_reunion=?, hora_reunion=? " + 
							"asistente1=?, en_calidad_de1=?, asistente2=?, en_calidad_de2=?, asistente3=?, en_calidad_de3=?, " +
							"asistente4=?, en_calidad_de4=?, asistente5=?, en_calidad_de5=?, temas_tratados=?, conclusiones=? " +
							"WHERE id_reunion=?");
			
			preparedStatement.setString(1, reunionEnt.getCurso());
			preparedStatement.setDate(2, new java.sql.Date(reunionEnt.getFecha_reunion().getTime()));
			preparedStatement.setString(3, reunionEnt.getHora_reunion());
			preparedStatement.setString(4, reunionEnt.getLugar_reunion());
			preparedStatement.setString(5, reunionEnt.getAsistente1());
			preparedStatement.setString(6, reunionEnt.getEn_calidad_de1());
			preparedStatement.setString(7, reunionEnt.getAsistente1());
			preparedStatement.setString(8, reunionEnt.getEn_calidad_de1());
			preparedStatement.setString(9, reunionEnt.getAsistente2());
			preparedStatement.setString(10, reunionEnt.getEn_calidad_de2());
			preparedStatement.setString(11, reunionEnt.getAsistente3());
			preparedStatement.setString(12, reunionEnt.getEn_calidad_de3());
			preparedStatement.setString(13, reunionEnt.getAsistente4());
			preparedStatement.setString(14, reunionEnt.getEn_calidad_de4());
			preparedStatement.setString(15, reunionEnt.getTemas_tratados());
			preparedStatement.setString(16, reunionEnt.getConclusiones());
			preparedStatement.setInt(17, reunionEnt.getId_reunion());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteReunionById(int id_reunion) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM reunion WHERE id_reunion=?");
			preparedStatement.setInt(1, id_reunion);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ReunionEntity getReunionById(int id_reunion) {
		ReunionEntity reunion = new ReunionEntity();
		
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM reunion WHERE id_reunion=?");
			preparedStatement.setInt(1, id_reunion);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				reunion.setId_reunion(rs.getInt("id_reunion"));
				reunion.setCurso(rs.getString("curso"));
				reunion.setFecha_reunion(rs.getDate("fecha_reunion"));
				reunion.setHora_reunion(rs.getString("hora_reunion"));
				reunion.setLugar_reunion(rs.getString("lugar_reunion"));
				reunion.setAsistente1(rs.getString("asistente1"));
				reunion.setEn_calidad_de1(rs.getString("en_calidad_de1"));
				reunion.setAsistente2(rs.getString("asistente2"));
				reunion.setEn_calidad_de2(rs.getString("en_calidad_de2"));
				reunion.setAsistente3(rs.getString("asistente3"));
				reunion.setEn_calidad_de3(rs.getString("en_calidad_de3"));
				reunion.setAsistente4(rs.getString("asistente4"));
				reunion.setEn_calidad_de4(rs.getString("en_calidad_de4"));
				reunion.setAsistente5(rs.getString("asistente1"));
				reunion.setEn_calidad_de5(rs.getString("en_calidad_de1"));
				reunion.setTemas_tratados(rs.getString("temas_tratados"));
				reunion.setConclusiones(rs.getString("conclusiones"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reunion;
	}
}
