package com.casia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.SancionEntity;

public class PROADao {
	
private static Connection connection;
	
	public PROADao()
	{
		connection = conexionDB.getConnection();
	}
	
	public List<SancionEntity> getAllAsistenciaPROAs() {
		List<SancionEntity> proas = new ArrayList<SancionEntity>();
		try
		{
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion r " + 
										"INNER JOIN sancion s ON s.id_sancion=r.id_sancion " + 
										"WHERE r.tipo_sancion= 'PROA' AND s.asistencia IS NULL " +
										"ORDER BY r.fecha_inicio ASC");
			
			while (rs.next())
			{
				SancionEntity proa = new SancionEntity();
				proa.setId_sancion(rs.getInt("id_sancion"));
				proa.setId_parte(rs.getInt("id_parte"));
				proa.setFecha_inicio(rs.getDate("fecha_inicio"));
				proa.setObservacion(rs.getString("observacion"));
				proa.setTrabajo(rs.getString("trabajo"));
				proa.setNombre_alum(rs.getString("nombre_alum"));
				proa.setAsignado_dias(rs.getString("asignado_dias"));
				
				proas.add(proa);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return proas;
	}

}
