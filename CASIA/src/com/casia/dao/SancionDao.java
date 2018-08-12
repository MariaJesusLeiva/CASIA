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

public class SancionDao
{
private static Connection connection;
	
	public SancionDao()
	{
		connection = conexionDB.getConnection();
	}
	
	public SancionEntity getParteById(int id_parte)
	{
		SancionEntity sancion = new SancionEntity();
		try
		{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM parte WHERE id_parte=?");
			preparedStatement.setInt(1, id_parte);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next())
			{
				sancion.setId_parte(rs.getInt("id_parte"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return sancion;
	}
	
	public void addSancion(SancionEntity sancionEnt)
	{
		try
		{
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO sancion(id_parte, tipo_sancion, fecha_inicio, fecha_fin, " +
							"total_dias, observacion, trabajo, asistencia, nombre_alum) " +
							"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, sancionEnt.getId_parte());
			preparedStatement.setString(2, sancionEnt.getTipo_sancion());
			preparedStatement.setDate(3, new java.sql.Date(sancionEnt.getFecha_inicio().getTime()));
			preparedStatement.setDate(4, new java.sql.Date(sancionEnt.getFecha_fin().getTime()));
			preparedStatement.setInt(5, sancionEnt.getTotal_dias());
			preparedStatement.setString(6, sancionEnt.getObservacion());
			preparedStatement.setString(7, sancionEnt.getTrabajo());
			preparedStatement.setString(8, sancionEnt.getAsistencia());
			preparedStatement.setString(9, sancionEnt.getNombre_alum());
			
			preparedStatement.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Object getAllSanciones()
	{
		List<SancionEntity> sanciones = new ArrayList<SancionEntity>();
		try
		{
			Statement statement = connection.createStatement();
			/*ResultSet rs = statement.executeQuery("SELECT * FROM sancion s " + 
										"INNER JOIN parte p ON s.id_parte=p.id_parte " +
										"ORDER BY s.fecha_inicio ASC");*/
			ResultSet rs = statement.executeQuery("SELECT * FROM sancion " + 
										"ORDER BY fecha_inicio ASC");
			
			while (rs.next())
			{
				SancionEntity sancion = new SancionEntity();
				sancion.setId_sancion(rs.getInt("id_sancion"));
				sancion.setId_parte(rs.getInt("id_parte"));
				sancion.setFecha_inicio(rs.getDate("fecha_inicio"));
				sancion.setFecha_fin(rs.getDate("fecha_fin"));
				sancion.setAsistencia(rs.getString("asistencia"));
				sancion.setObservacion(rs.getString("observacion"));
				sancion.setTipo_sancion(rs.getString("tipo_sancion"));
				sancion.setTotal_dias(rs.getInt("total_dias"));
				sancion.setTrabajo(rs.getString("trabajo"));
				sancion.setNombre_alum(rs.getString("nombre_alum"));
				
				sanciones.add(sancion);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return sanciones;
	}

}
