package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.AcosoEntity;
import com.casia.entity.ReunionEntity;
import com.casia.entity.SancionEntity;

public class AcosoDao {
	
private static Connection connection;
	
	public AcosoDao() {
		connection = conexionDB.getConnection();
	}	
	
	public void addAcoso(AcosoEntity acosoEnt) {
		try {
			/*PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO acoso(codigo, curso, grupo, grupo2, tipo, tipo2, nombre_alum, nombre_alum2, "
							+ "inf_aportada, medidas, inicio_protocolo, fecha_reunion, hora_reunion, asistentes) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");*/
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO acoso(codigo, curso, grupo, grupo2, tipo, tipo2, nombre_alum, nombre_alum2, "
							+ "inf_aportada, medidas, inicio_protocolo) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, acosoEnt.getCodigo());
			preparedStatement.setString(2, acosoEnt.getCurso());
			preparedStatement.setString(3, acosoEnt.getGrupo());
			preparedStatement.setString(4, acosoEnt.getGrupo2());
			preparedStatement.setString(5, acosoEnt.getTipo());
			preparedStatement.setString(6, acosoEnt.getTipo2());
			preparedStatement.setString(7, acosoEnt.getNombre_alum());
			preparedStatement.setString(8, acosoEnt.getNombre_alum2());			
			preparedStatement.setString(9, acosoEnt.getInf_aportada());			
			preparedStatement.setString(10, acosoEnt.getMedidas());
			preparedStatement.setString(11, acosoEnt.getInicio_protocolo());
			//preparedStatement.setString(10, acosoEnt.getAsistentes());
			/*preparedStatement.setString(12, acosoEnt.getHora_reunion());
			preparedStatement.setDate(13, new java.sql.Date(acosoEnt.getFecha_reunion().getTime()));*/			
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAcoso(AcosoEntity acosoEnt) {
		try {
			/*PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE acoso SET codigo=?, curso=?, grupo=?, grupo2=?, tipo=?, tipo2=?, nombre_alum=?, nombre_alum2=?, " + 
							"inf_aportada=?, medidas=?, inicio_protocolo=?, fecha_reunion=?, hora_reunion=?, asistentes=? " +
							"WHERE id_acoso=?");
			
			preparedStatement.setInt(1, acosoEnt.getCodigo());
			preparedStatement.setString(2, acosoEnt.getCurso());
			preparedStatement.setString(3, acosoEnt.getGrupo());
			preparedStatement.setString(4, acosoEnt.getGrupo2());
			preparedStatement.setString(5, acosoEnt.getTipo());
			preparedStatement.setString(6, acosoEnt.getTipo2());
			preparedStatement.setString(7, acosoEnt.getNombre_alum());
			preparedStatement.setString(8, acosoEnt.getNombre_alum2());
			preparedStatement.setDate(9, new java.sql.Date(acosoEnt.getFecha_reunion().getTime()));
			preparedStatement.setString(10, acosoEnt.getHora_reunion());
			preparedStatement.setString(11, acosoEnt.getInf_aportada());
			preparedStatement.setString(12, acosoEnt.getMedidas());
			preparedStatement.setString(13, acosoEnt.getAsistentes());
			preparedStatement.setString(14, acosoEnt.getInicio_protocolo());
			preparedStatement.setInt(15, acosoEnt.getId_acoso());
			preparedStatement.executeUpdate();*/
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE acoso SET codigo=?, curso=?, grupo=?, grupo2=?, tipo=?, tipo2=?, nombre_alum=?, nombre_alum2=?, " + 
							"inf_aportada=?, medidas=?, inicio_protocolo=? " +
							"WHERE id_acoso=?");
			
			preparedStatement.setInt(1, acosoEnt.getCodigo());
			preparedStatement.setString(2, acosoEnt.getCurso());
			preparedStatement.setString(3, acosoEnt.getGrupo());
			preparedStatement.setString(4, acosoEnt.getGrupo2());
			preparedStatement.setString(5, acosoEnt.getTipo());
			preparedStatement.setString(6, acosoEnt.getTipo2());
			preparedStatement.setString(7, acosoEnt.getNombre_alum());
			preparedStatement.setString(8, acosoEnt.getNombre_alum2());
			preparedStatement.setString(9, acosoEnt.getInf_aportada());
			preparedStatement.setString(10, acosoEnt.getMedidas());
			preparedStatement.setString(11, acosoEnt.getInicio_protocolo());
			preparedStatement.setInt(12, acosoEnt.getId_acoso());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAcosoById(int id_acoso) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM acoso WHERE id_acoso=?");
			preparedStatement.setInt(1, id_acoso);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<AcosoEntity> getAllAcosos() {
		List<AcosoEntity> acosos = new ArrayList<AcosoEntity>();
		try	{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM acoso " + 
										"ORDER BY id_acoso DESC");
			
			while (rs.next()) {
				AcosoEntity acoso = new AcosoEntity();
				acoso.setId_acoso(rs.getInt("id_acoso"));
				acoso.setCodigo(rs.getInt("codigo"));
				acoso.setCurso(rs.getString("curso"));
				//acoso.setFecha_reunion(rs.getDate("fecha_reunion"));
				//acoso.setHora_reunion(rs.getString("hora_reunion"));
				acoso.setGrupo(rs.getString("grupo"));
				acoso.setGrupo2(rs.getString("grupo2"));
				acoso.setTipo(rs.getString("tipo"));
				acoso.setTipo2(rs.getString("tipo2"));
				acoso.setNombre_alum(rs.getString("nombre_alum"));
				acoso.setNombre_alum2(rs.getString("nombre_alum2"));				
				acoso.setInf_aportada(rs.getString("inf_aportada"));
				acoso.setMedidas(rs.getString("medidas"));
				//acoso.setAsistentes(rs.getString("asistentes"));
				acoso.setInicio_protocolo(rs.getString("inicio_protocolo"));
								
				acosos.add(acoso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acosos;
	}
	
	public AcosoEntity getAcosoById(int id_acoso) {

		AcosoEntity acoso = new AcosoEntity();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM acoso WHERE id_acoso=?");
			preparedStatement.setInt(1, id_acoso);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				acoso.setId_acoso(rs.getInt("id_acoso"));
				acoso.setCodigo(rs.getInt("codigo"));
				acoso.setCurso(rs.getString("curso"));
				//acoso.setFecha_reunion(rs.getDate("fecha_reunion"));
				//acoso.setHora_reunion(rs.getString("hora_reunion"));
				acoso.setGrupo(rs.getString("grupo"));
				acoso.setGrupo2(rs.getString("grupo2"));
				acoso.setTipo(rs.getString("tipo"));
				acoso.setTipo2(rs.getString("tipo2"));
				acoso.setNombre_alum(rs.getString("nombre_alum"));
				acoso.setNombre_alum2(rs.getString("nombre_alum2"));				
				acoso.setInf_aportada(rs.getString("inf_aportada"));
				acoso.setMedidas(rs.getString("medidas"));
				//acoso.setAsistentes(rs.getString("asistentes"));
				acoso.setInicio_protocolo(rs.getString("inicio_protocolo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acoso;
	}
}
