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
					.prepareStatement("INSERT INTO sancion(id_parte, tipo_sancion, " +
							"observacion, trabajo, asistencia, nombre_alum, asignado_dias) " +
							"VALUES (?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, sancionEnt.getId_parte());
			preparedStatement.setString(2, sancionEnt.getTipo_sancion());
			preparedStatement.setString(3, sancionEnt.getObservacion());
			preparedStatement.setString(4, sancionEnt.getTrabajo());
			preparedStatement.setString(5, sancionEnt.getAsistencia());
			preparedStatement.setString(6, sancionEnt.getNombre_alum());
			preparedStatement.setString(7, sancionEnt.getAsignado_dias());
//			preparedStatement.setDate(8, new java.sql.Date(sancionEnt.getFecha_inicio().getTime()));
//			preparedStatement.setDate(9, new java.sql.Date(sancionEnt.getFecha_fin().getTime()));
//			preparedStatement.setInt(10, sancionEnt.getTotal_dias());
			
			preparedStatement.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void updateSancion(SancionEntity sancionEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE sancion SET tipo_sancion=?, observacion=?, trabajo=?," + 
							"asistencia=?, nombre_alum=?, asignado_dias=?, fecha_inicio=?, fecha_fin=?, total_dias=? " +
							"WHERE id_sancion=?");
			// Parameters start with 1
			preparedStatement.setString(1, sancionEnt.getTipo_sancion());
			preparedStatement.setString(2, sancionEnt.getObservacion());
			preparedStatement.setString(3, sancionEnt.getTrabajo());
			preparedStatement.setString(4, sancionEnt.getAsistencia());
			preparedStatement.setString(5, sancionEnt.getNombre_alum());
			preparedStatement.setString(6, sancionEnt.getAsignado_dias());
			preparedStatement.setDate(7, new java.sql.Date(sancionEnt.getFecha_inicio().getTime()));
			preparedStatement.setDate(8, new java.sql.Date(sancionEnt.getFecha_fin().getTime()));
			preparedStatement.setInt(9, sancionEnt.getTotal_dias());
			preparedStatement.setInt(10, sancionEnt.getId_sancion());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<SancionEntity> getAllSanciones()
	{
		List<SancionEntity> sanciones = new ArrayList<SancionEntity>();
		try
		{
			Statement statement = connection.createStatement();
			/*ResultSet rs = statement.executeQuery("SELECT * FROM sancion s " + 
										"INNER JOIN parte p ON s.id_parte=p.id_parte " +
										"ORDER BY s.fecha_inicio ASC");*/
			ResultSet rs = statement.executeQuery("SELECT * FROM sancion " + 
										"ORDER BY id_sancion ASC");
			
			while (rs.next())
			{
				SancionEntity sancion = new SancionEntity();
				sancion.setId_sancion(rs.getInt("id_sancion"));
				sancion.setId_parte(rs.getInt("id_parte"));
				sancion.setAsistencia(rs.getString("asistencia"));
				sancion.setObservacion(rs.getString("observacion"));
				sancion.setTipo_sancion(rs.getString("tipo_sancion"));
				sancion.setTotal_dias(rs.getInt("total_dias"));
				sancion.setTrabajo(rs.getString("trabajo"));
				sancion.setNombre_alum(rs.getString("nombre_alum"));
				sancion.setAsignado_dias(rs.getString("asignado_dias"));
				sancion.setFecha_inicio(rs.getDate("fecha_inicio"));
				sancion.setFecha_fin(rs.getDate("fecha_fin"));
				
				sanciones.add(sancion);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return sanciones;
	}
	
	public List<SancionEntity> getAllRecreoPROA()
	{
		List<SancionEntity> sanciones = new ArrayList<SancionEntity>();
		try
		{
			Statement statement = connection.createStatement();
			/*ResultSet rs = statement.executeQuery("SELECT * FROM sancion s " + 
										"INNER JOIN parte p ON s.id_parte=p.id_parte " +
										"ORDER BY s.fecha_inicio ASC");*/
			ResultSet rs = statement.executeQuery("SELECT * FROM sancion " + 
										"WHERE tipo_sancion != 'Expulsi�n' " +
										"ORDER BY fecha_inicio ASC");
			
			while (rs.next())
			{
				SancionEntity sancion = new SancionEntity();
				sancion.setId_sancion(rs.getInt("id_sancion"));
				sancion.setTipo_sancion(rs.getString("tipo_sancion"));
				sancion.setTotal_dias(rs.getInt("total_dias"));
				sancion.setNombre_alum(rs.getString("nombre_alum"));
				sancion.setFecha_inicio(rs.getDate("fecha_inicio"));				
				sanciones.add(sancion);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return sanciones;
	}

	public List<SancionEntity> getAllRecreos() {
		List<SancionEntity> recreos = new ArrayList<SancionEntity>();
		try
		{
			Statement statement = connection.createStatement();
			/*ResultSet rs = statement.executeQuery("SELECT * FROM sancion s " + 
										"INNER JOIN parte p ON s.id_parte=p.id_parte " +
										"ORDER BY s.fecha_inicio ASC");*/
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

	public void updateAsistencia(Integer id_sancion) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE sancion SET asistencia= 'S�'" + 
							"WHERE id_sancion=?");
			// Parameters start with 1
			preparedStatement.setInt(1, id_sancion);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<SancionEntity> getAllSancionesSinDias() {
		List<SancionEntity> sanciones = new ArrayList<SancionEntity>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM sancion WHERE tipo_sancion != 'Expulsi�n' AND asignado_dias IS NULL");
			while (rs.next()) {
				SancionEntity sancion = new SancionEntity();
				sancion.setId_sancion(rs.getInt("id_sancion"));
				sancion.setNombre_alum(rs.getString("nombre_alum"));
				sancion.setTipo_sancion(rs.getString("tipo_sancion"));
				sancion.setTotal_dias(rs.getInt("total_dias"));
				sancion.setAsignado_dias(rs.getString("asignado_dias"));
				sancion.setFecha_inicio(rs.getDate("fecha_inicio"));
				sancion.setFecha_fin(rs.getDate("fecha_fin"));
				
				sanciones.add(sancion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sanciones;
	}

	public SancionEntity getSancionById(int id_sancion) {
		
		SancionEntity sancion = new SancionEntity();
		
		try 
		{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM sancion WHERE id_sancion=? ORDER BY id_sancion DESC");
			preparedStatement.setInt(1, id_sancion);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next())
			{
				sancion.setId_sancion(rs.getInt("id_sancion"));
				sancion.setNombre_alum(rs.getString("nombre_alum"));
				sancion.setTipo_sancion(rs.getString("tipo_sancion"));
				sancion.setAsignado_dias(rs.getString("asignado_dias"));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return sancion;
	}
	
	public void updateSancionDias (int id_sancion)
	{		
		try
		{
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE sancion " +
							"SET total_dias = IFNULL(total_dias,0)+1 " +
							"WHERE id_sancion=?");

			preparedStatement.setInt(1, id_sancion);
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void updateAsignadoDias(int id_sancion) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE sancion SET asignado_dias= 'S�'" + 
							"WHERE id_sancion=?");
			// Parameters start with 1
			preparedStatement.setInt(1, id_sancion);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public int getIdSancionByIdParte(int id_parte) {
		int id_s = 0;
		
		try 
		{
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM sancion WHERE id_parte=?");
			preparedStatement.setInt(1, id_parte);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next())
			{
				id_s = rs.getInt("id_sancion");

			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return id_s;
	}
	
}
