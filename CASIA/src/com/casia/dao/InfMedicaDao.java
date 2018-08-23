package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.InfMedicaEntity;

public class InfMedicaDao {
	private static Connection connection;

	public InfMedicaDao() {
		connection = conexionDB.getConnection();
	}

	public void addInfMedica(InfMedicaEntity infmedicaEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO infmedica(nombre_alum, curso, grupo, "
							+ "fecha_nacimiento, inf_medica, documentacion, medicacion) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, infmedicaEnt.getNombre_alum());
			preparedStatement.setString(2, infmedicaEnt.getCurso());
			preparedStatement.setString(3, infmedicaEnt.getGrupo());
			preparedStatement.setDate(4, new java.sql.Date(infmedicaEnt.getFecha_nacimiento().getTime()));
			preparedStatement.setString(5, infmedicaEnt.getInf_medica());
			preparedStatement.setString(6, infmedicaEnt.getDocumentacion());
			preparedStatement.setString(7, infmedicaEnt.getMedicacion());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateInfMedica(InfMedicaEntity infmedicaEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE infmedica SET nombre_alum=?, curso=?, grupo=?, "
							+ "fecha_nacimiento=?, inf_medica=?, documentacion=?, medicacion=? " + "WHERE id_medica=?");

			preparedStatement.setString(1, infmedicaEnt.getNombre_alum());
			preparedStatement.setString(2, infmedicaEnt.getCurso());
			preparedStatement.setString(3, infmedicaEnt.getGrupo());
			preparedStatement.setDate(4, new java.sql.Date(infmedicaEnt.getFecha_nacimiento().getTime()));
			preparedStatement.setString(5, infmedicaEnt.getInf_medica());
			preparedStatement.setString(6, infmedicaEnt.getDocumentacion());
			preparedStatement.setString(7, infmedicaEnt.getMedicacion());
			preparedStatement.setInt(8, infmedicaEnt.getId_medica());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteInfMedicaById(int id_medica) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM infmedica WHERE id_medica=?");
			preparedStatement.setInt(1, id_medica);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public InfMedicaEntity getInfMedicaById(int id_medica) {

		InfMedicaEntity infmedicaEnt = new InfMedicaEntity();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM infmedica WHERE id_medica=?");
			preparedStatement.setInt(1, id_medica);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				infmedicaEnt.setId_medica(rs.getInt("id_medica"));
				infmedicaEnt.setCurso(rs.getString("curso"));
				infmedicaEnt.setGrupo(rs.getString("grupo"));
				infmedicaEnt.setNombre_alum(rs.getString("nombre_alum"));
				infmedicaEnt.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				infmedicaEnt.setInf_medica(rs.getString("inf_medica"));
				infmedicaEnt.setDocumentacion(rs.getString("documentacion"));
				infmedicaEnt.setMedicacion(rs.getString("medicacion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return infmedicaEnt;
	}

	public List<InfMedicaEntity> getAllInfMedicas() {
		List<InfMedicaEntity> medicas = new ArrayList<InfMedicaEntity>();
		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * FROM infmedica ORDER BY nombre_alum ASC");

			while (rs.next()) {
				InfMedicaEntity infmedicaEnt = new InfMedicaEntity();
				infmedicaEnt.setId_medica(rs.getInt("id_medica"));
				infmedicaEnt.setCurso(rs.getString("curso"));
				infmedicaEnt.setGrupo(rs.getString("grupo"));
				infmedicaEnt.setNombre_alum(rs.getString("nombre_alum"));
				infmedicaEnt.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				infmedicaEnt.setInf_medica(rs.getString("inf_medica"));
				infmedicaEnt.setDocumentacion(rs.getString("documentacion"));
				infmedicaEnt.setMedicacion(rs.getString("medicacion"));

				medicas.add(infmedicaEnt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medicas;
	}

}
