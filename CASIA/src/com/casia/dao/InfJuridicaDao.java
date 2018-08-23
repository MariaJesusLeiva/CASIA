package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.InfJuridicaEntity;

public class InfJuridicaDao {
	private static Connection connection;

	public InfJuridicaDao() {
		connection = conexionDB.getConnection();
	}

	public void addInfJuridica(InfJuridicaEntity infjuridicaEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO infjuridica(nombre_alum, curso, grupo, "
							+ "fecha_nacimiento, inf_juridica, documentacion) "
							+ "VALUES (?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, infjuridicaEnt.getNombre_alum());
			preparedStatement.setString(2, infjuridicaEnt.getCurso());
			preparedStatement.setString(3, infjuridicaEnt.getGrupo());
			preparedStatement.setDate(4, new java.sql.Date(infjuridicaEnt.getFecha_nacimiento().getTime()));
			preparedStatement.setString(5, infjuridicaEnt.getInf_juridica());
			preparedStatement.setString(6, infjuridicaEnt.getDocumentacion());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateInfJuridica(InfJuridicaEntity infjuridicaEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE infjuridica SET nombre_alum=?, curso=?, grupo=?, "
							+ "fecha_nacimiento=?, inf_juridica=?, documentacion=? " 
							+ "WHERE id_juridica=?");

			preparedStatement.setString(1, infjuridicaEnt.getNombre_alum());
			preparedStatement.setString(2, infjuridicaEnt.getCurso());
			preparedStatement.setString(3, infjuridicaEnt.getGrupo());
			preparedStatement.setDate(4, new java.sql.Date(infjuridicaEnt.getFecha_nacimiento().getTime()));
			preparedStatement.setString(5, infjuridicaEnt.getInf_juridica());
			preparedStatement.setString(6, infjuridicaEnt.getDocumentacion());
			preparedStatement.setInt(7, infjuridicaEnt.getId_juridica());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteInfJuridicaById(int id_juridica) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM infjuridica WHERE id_juridica=?");
			preparedStatement.setInt(1, id_juridica);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public InfJuridicaEntity getInfJuridicaById(int id_juridica) {

		InfJuridicaEntity infjuridicaEnt = new InfJuridicaEntity();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM infjuridica WHERE id_juridica=?");
			preparedStatement.setInt(1, id_juridica);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				infjuridicaEnt.setId_juridica(rs.getInt("id_juridica"));
				infjuridicaEnt.setCurso(rs.getString("curso"));
				infjuridicaEnt.setGrupo(rs.getString("grupo"));
				infjuridicaEnt.setNombre_alum(rs.getString("nombre_alum"));
				infjuridicaEnt.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				infjuridicaEnt.setInf_juridica(rs.getString("inf_juridica"));
				infjuridicaEnt.setDocumentacion(rs.getString("documentacion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return infjuridicaEnt;
	}

	public List<InfJuridicaEntity> getAllInfJuridicas() {
		List<InfJuridicaEntity> juridicas = new ArrayList<InfJuridicaEntity>();
		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * FROM infjuridica ORDER BY nombre_alum ASC");

			while (rs.next()) {
				InfJuridicaEntity infjuridicaEnt = new InfJuridicaEntity();
				infjuridicaEnt.setId_juridica(rs.getInt("id_juridica"));
				infjuridicaEnt.setCurso(rs.getString("curso"));
				infjuridicaEnt.setGrupo(rs.getString("grupo"));
				infjuridicaEnt.setNombre_alum(rs.getString("nombre_alum"));
				infjuridicaEnt.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				infjuridicaEnt.setInf_juridica(rs.getString("inf_juridica"));
				infjuridicaEnt.setDocumentacion(rs.getString("documentacion"));

				juridicas.add(infjuridicaEnt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return juridicas;
	}
}