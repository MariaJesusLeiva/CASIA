package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.SancionEntity;

public class ExpulsionDao {
	private static Connection connection;

	public ExpulsionDao() {
		connection = conexionDB.getConnection();
	}


	public static List<SancionEntity> getAllExpulsiones() {
		List<SancionEntity> expulsiones = new ArrayList<SancionEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM sancion WHERE tipo_sancion= 'Expulsión' ORDER BY fecha_inicio ASC");

			while (rs.next()) {
				SancionEntity expulsion = new SancionEntity();
				expulsion.setId_sancion(rs.getInt("id_sancion"));
				expulsion.setFecha_inicio(rs.getDate("fecha_inicio"));
				expulsion.setObservacion(rs.getString("observacion"));
				expulsion.setTrabajo(rs.getString("trabajo"));
				expulsion.setNombre_alum(rs.getString("nombre_alum"));

				expulsiones.add(expulsion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expulsiones;
	}

}

