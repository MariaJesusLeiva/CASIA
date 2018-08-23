package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.ActMedicaEntity;

public class ActMedicaDao {
	
private static Connection connection;
	
	public ActMedicaDao()
	{
		connection = conexionDB.getConnection();
	}
		
	public void addActMedica(ActMedicaEntity actmedicaEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO actmedica(nombre_alum, curso, grupo, "
							+ "fecha_actuacion, observacion) " +
							"VALUES (?, ?, ?, ?, ?)");

			preparedStatement.setString(1, actmedicaEnt.getNombre_alum());
			preparedStatement.setString(2, actmedicaEnt.getCurso());
			preparedStatement.setString(3, actmedicaEnt.getGrupo());
			preparedStatement.setDate(4, new java.sql.Date(actmedicaEnt.getFecha_actuacion().getTime()));
			preparedStatement.setString(5, actmedicaEnt.getObservacion());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateActMedica(ActMedicaEntity actmedicaEnt) {
		try
		{
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE actmedica SET nombre_alum=?, curso=?, grupo=?, " +
							"fecha_actuacion=?, observacion=? " +
							"WHERE id_actuacion=?");

			preparedStatement.setString(1, actmedicaEnt.getNombre_alum());
			preparedStatement.setString(2, actmedicaEnt.getCurso());
			preparedStatement.setString(3, actmedicaEnt.getGrupo());
			preparedStatement.setDate(4, new java.sql.Date(actmedicaEnt.getFecha_actuacion().getTime()));
			preparedStatement.setString(5, actmedicaEnt.getObservacion());
			preparedStatement.setInt(6, actmedicaEnt.getId_actuacion());
			
			preparedStatement.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void deleteActMedicaById(int id_actuacion) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM actmedica WHERE id_actuacion=?");
			preparedStatement.setInt(1, id_actuacion);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ActMedicaEntity getActMedicaById(int id_actuacion) {
		
		ActMedicaEntity actmedicaEnt = new ActMedicaEntity();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM actmedica WHERE id_actuacion=?");
			preparedStatement.setInt(1, id_actuacion);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				actmedicaEnt.setId_actuacion(rs.getInt("id_actuacion"));
				actmedicaEnt.setCurso(rs.getString("curso"));
				actmedicaEnt.setGrupo(rs.getString("grupo"));
				actmedicaEnt.setNombre_alum(rs.getString("nombre_alum"));
				actmedicaEnt.setFecha_actuacion(rs.getDate("fecha_actuacion"));
				actmedicaEnt.setObservacion(rs.getString("observacion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actmedicaEnt;
	}
	
	public List<ActMedicaEntity> getAllActMedicas()
	{
		List<ActMedicaEntity> actmedicas = new ArrayList<ActMedicaEntity>();
		try
		{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM actmedica ORDER BY fecha_actuacion ASC");
			
			while (rs.next())
			{
				ActMedicaEntity actmedicaEnt = new ActMedicaEntity();
				actmedicaEnt.setId_actuacion(rs.getInt("id_actuacion"));
				actmedicaEnt.setCurso(rs.getString("curso"));
				actmedicaEnt.setGrupo(rs.getString("grupo"));
				actmedicaEnt.setNombre_alum(rs.getString("nombre_alum"));
				actmedicaEnt.setFecha_actuacion(rs.getDate("fecha_actuacion"));
				actmedicaEnt.setObservacion(rs.getString("observacion"));
				
				actmedicas.add(actmedicaEnt);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return actmedicas;
	}

}

