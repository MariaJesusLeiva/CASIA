package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.ParteEntity;

public class ParteDao
{
	private static Connection connection;
	
	public ParteDao()
	{
		connection = conexionDB.getConnection();
	}
	
	public void addParte(ParteEntity parteEnt)
	{
		try
		{
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO parte(codigo, fecha_parte, nombre_profe, nombre_alum, grupo, motivo_parte) " +
							"VALUES (?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, parteEnt.getCodigo());
			preparedStatement.setDate(2, new java.sql.Date(parteEnt.getFecha_parte().getTime()));
			preparedStatement.setString(3, parteEnt.getNombre_profe());
			preparedStatement.setString(4, parteEnt.getNombre_alum());
			preparedStatement.setString(5, parteEnt.getGrupo());
			preparedStatement.setString(6, parteEnt.getMotivo_parte());
			preparedStatement.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<ParteEntity> getAllPartes()
	{
		List<ParteEntity> partes = new ArrayList<ParteEntity>();
		
		try
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM parte WHERE tipo_sancion " +
									"IS NOT NULL ORDER BY fecha_parte ASC");
			
			while (rs.next())
			{
				ParteEntity parte = new ParteEntity();
				parte.setId_parte(rs.getInt("id_parte"));
				parte.setCodigo(rs.getInt("codigo"));
				parte.setFecha_parte(rs.getDate("fecha_parte"));
				parte.setNombre_profe(rs.getString("nombre_profe"));
				parte.setNombre_alum(rs.getString("nombre_alum"));
				parte.setGrupo(rs.getString("grupo"));
				parte.setTipo_sancion(rs.getString("tipo_sancion"));
				parte.setMotivo_parte(rs.getString("motivo_parte"));
				partes.add(parte);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return partes;
	}
	
	public ParteEntity getParteById(int id_parte)
	{
		ParteEntity parte = new ParteEntity();
		
		try 
		{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM parte WHERE id_parte=?");
			preparedStatement.setInt(1, id_parte);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next())
			{
				parte.setId_parte(rs.getInt("id_parte"));
				parte.setCodigo(rs.getInt("codigo"));
				parte.setFecha_parte(rs.getDate("fecha_parte"));
				parte.setNombre_profe(rs.getString("nombre_profe"));
				parte.setNombre_alum(rs.getString("nombre_alum"));
				parte.setGrupo(rs.getString("grupo"));
				parte.setTipo_sancion(rs.getString("tipo_sancion"));
				parte.setMotivo_parte(rs.getString("motivo_parte"));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return parte;
	}
	
	public ParteEntity getAlumSancionByIdParte(int id_parte)
	{
		ParteEntity alumsancion = new ParteEntity();
		try
		{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM parte WHERE id_parte=?");
			preparedStatement.setInt(1, id_parte);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next())
			{
				alumsancion.setNombre_alum(rs.getString("nombre_alum"));
				alumsancion.setNombre_profe(rs.getString("nombre_profe"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return alumsancion;
	}
	
	public void updateSancionParte (int id_parte)
	{		
		try
		{
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE parte AS p " +
							"INNER JOIN sancion AS s " +
							"ON s.id_parte = p.id_parte " +
							"SET p.tipo_sancion = s.tipo_sancion " +
							"WHERE p.id_parte=?");

			preparedStatement.setInt(1, id_parte);
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<ParteEntity> getAllPartesSinSanciones() {
		List<ParteEntity> partes = new ArrayList<ParteEntity>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM parte WHERE tipo_sancion IS NULL ORDER BY fecha_parte ASC");
			while (rs.next()) {
				ParteEntity parte = new ParteEntity();
				parte.setId_parte(rs.getInt("id_parte"));
				parte.setCodigo(rs.getInt("codigo"));
				parte.setFecha_parte(rs.getDate("fecha_parte"));
				parte.setNombre_profe(rs.getString("nombre_profe"));
				parte.setNombre_alum(rs.getString("nombre_alum"));
				parte.setGrupo(rs.getString("grupo"));
				parte.setTipo_sancion(rs.getString("tipo_sancion"));
				parte.setMotivo_parte(rs.getString("motivo_parte"));
				
				partes.add(parte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return partes;
	}
}
