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

public class RecreoDao {
	
private static Connection connection;
	
	public RecreoDao()
	{
		connection = conexionDB.getConnection();
	}
	
	public List<SancionEntity> getAllAsistenciaRecreos() {
		List<SancionEntity> recreos = new ArrayList<SancionEntity>();
		try
		{
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion r " + 
										"INNER JOIN sancion s ON s.id_sancion=r.id_sancion " + 
										"WHERE r.tipo_sancion= 'recreo' AND s.asistencia IS NULL " +
										"ORDER BY r.fecha_inicio ASC");
			
			while (rs.next())
			{
				SancionEntity recreo = new SancionEntity();
				recreo.setId_sancion(rs.getInt("id_sancion"));
				recreo.setId_parte(rs.getInt("id_parte"));
				recreo.setFecha_inicio(rs.getDate("fecha_inicio"));
				recreo.setObservacion(rs.getString("observacion"));
				recreo.setTrabajo(rs.getString("trabajo"));
				recreo.setNombre_alum(rs.getString("nombre_alum"));
				recreo.setAsignado_dias(rs.getString("asignado_dias"));
				
				recreos.add(recreo);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return recreos;
	}
	public static List<SancionEntity> getAllRecreos() {
		List<SancionEntity> recreos = new ArrayList<SancionEntity>();
		try
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM sancion " + 
										"WHERE tipo_sancion= 'recreo' " +
										"ORDER BY fecha_inicio ASC");

			while (rs.next())
			{
				SancionEntity recreo = new SancionEntity();
				recreo.setId_sancion(rs.getInt("id_sancion"));
				recreo.setFecha_inicio(rs.getDate("fecha_inicio"));
				recreo.setObservacion(rs.getString("observacion"));
				recreo.setTrabajo(rs.getString("trabajo"));
				recreo.setNombre_alum(rs.getString("nombre_alum"));
				
				recreos.add(recreo);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return recreos;
	}

	public SancionEntity getAlumRecreoByIdSancion(int id_sancion)
	{
		SancionEntity alumrecreo = new SancionEntity();
		try
		{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM sancion WHERE id_sancion=?");
			preparedStatement.setInt(1, id_sancion);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next())
			{
				alumrecreo.setNombre_alum(rs.getString("nombre_alum"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return alumrecreo;
	}
}
