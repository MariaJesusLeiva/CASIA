package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.casia.config.conexionDB;
import com.casia.entity.ParteEntity;
import com.casia.entity.SancionEntity;

public class SancionDao {
private static Connection connection;
	
	public SancionDao() {
		connection = conexionDB.getConnection();
	}
	
	public SancionEntity getParteById(int id_parte) {
		SancionEntity sancion = new SancionEntity();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from parte where id_parte=?");
			preparedStatement.setInt(1, id_parte);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				sancion.setId_parte(rs.getInt("id_parte"));
				/*sancion.setFecha_inicio(rs.getDate("fecha_inicio"));
				sancion.setFecha_fin(rs.getDate("fecha_fin"));
				sancion.setTotal_dias(rs.getInt("total_dias"));*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sancion;
	}
	
	public void addSancion(SancionEntity sancionEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into sancion(id_parte,tipo_sancion,fecha_inicio,fecha_fin,total_dias,observacion,asistencia,trabajo) values (?, ?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, sancionEnt.getId_parte());
			preparedStatement.setString(2, sancionEnt.getTipo_sancion());
			preparedStatement.setDate(3, new java.sql.Date(sancionEnt.getFecha_inicio().getTime()));
			preparedStatement.setDate(4, new java.sql.Date(sancionEnt.getFecha_fin().getTime()));
			preparedStatement.setInt(5, sancionEnt.getTotal_dias());
			preparedStatement.setString(6, sancionEnt.getObservacion());
			preparedStatement.setString(7, sancionEnt.getTrabajo());
			preparedStatement.setString(8, sancionEnt.getAsistencia());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
