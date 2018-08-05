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

public class ParteDao {
	private static Connection connection;
	
	public ParteDao() {
		connection = conexionDB.getConnection();
	}
	
	public void addParte(ParteEntity parteEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into parte(codigo,fecha_parte,nombre_profe,nombre_alum,grupo,motivo_parte) values (?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, parteEnt.getCodigo());
			preparedStatement.setDate(2, new java.sql.Date(parteEnt.getFecha_parte().getTime()));
			preparedStatement.setString(3, parteEnt.getNombre_profe());
			preparedStatement.setString(4, parteEnt.getNombre_alum());
			preparedStatement.setString(5, parteEnt.getGrupo());
			preparedStatement.setString(6, parteEnt.getMotivo_parte());
			/*preparedStatement.setDate(5, new java.sql.Date(parteEnt.getFecha_inicio().getTime()));
			preparedStatement.setDate(6, new java.sql.Date(parteEnt.getFecha_fin().getTime()));
			preparedStatement.setInt(7, parteEnt.getTotal_dias());*/
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ParteEntity> getAllPartes() {
		List<ParteEntity> partes = new ArrayList<ParteEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from parte where tipo_sancion is not null order by fecha_parte asc");
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
	
	public ParteEntity getParteById(int id_parte) {
		ParteEntity parte = new ParteEntity();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from parte where id_parte=?");
			preparedStatement.setInt(1, id_parte);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				parte.setId_parte(rs.getInt("id_parte"));
				parte.setCodigo(rs.getInt("codigo"));
				parte.setFecha_parte(rs.getDate("fecha_parte"));
				parte.setNombre_profe(rs.getString("nombre_profe"));
				parte.setNombre_alum(rs.getString("nombre_alum"));
				parte.setGrupo(rs.getString("grupo"));
				parte.setTipo_sancion(rs.getString("tipo_sancion"));
				parte.setMotivo_parte(rs.getString("motivo_parte"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return parte;
	}
	
	public ParteEntity getAlumSancionByIdParte(int id_parte) {
		ParteEntity alumsancion = new ParteEntity();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM parte where id_parte =?");
			preparedStatement.setInt(1, id_parte);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				alumsancion.setNombre_alum(rs.getString("nombre_alum"));
				alumsancion.setNombre_profe(rs.getString("nombre_profe"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alumsancion;
	}
	
	public void updateSancionParte (int id_parte) {
		ParteEntity parte = new ParteEntity();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE parte AS p "+
							"INNER JOIN sancion AS s " +
							"ON s.id_parte = p.id_parte " +
							"Set p.tipo_sancion = s.tipo_sancion " +
							"Where p.id_parte=?");
			// Parameters start with 1
			preparedStatement.setInt(1, id_parte);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ParteEntity> getAllPartesSinSanciones() {
		List<ParteEntity> partes = new ArrayList<ParteEntity>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from parte  where tipo_sancion is null order by fecha_parte asc");
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
