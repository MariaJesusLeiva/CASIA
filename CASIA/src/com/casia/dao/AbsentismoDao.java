/*
 * Nombre aplicación: CASIA
 * Autor: María Jesús Leiva Romera
 * Año: 2018
 */

package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.AbsentismoEntity;

public class AbsentismoDao {

	private static Connection connection;

	public AbsentismoDao() {
		connection = conexionDB.getConnection();
	}

	public void addAbsentismo(AbsentismoEntity absentismoEnt) {
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO absentismo(codigo_absen, grupo, curso, "
							+ "nombre_alum, fecha_nacimiento, mes_faseuno, totalhoras_faseuno, fechacarta_faseuno, "
							+ "justificada_faseuno, observacion_faseuno, mes_fasedos, totalhoras_fasedos, fechacarta_fasedos, "
							+ "justificada_fasedos, fechacita_fasedos, horacita_fasedos, acude_fasedos, justificadacita_fasedos, "
							+ "compromiso_fasedos, observacion_fasedos, mes_fasetres, totalhoras_fasetres, fechacarta_fasetres, "
							+ "justificada_fasetres, fechacita_fasetres, horacita_fasetres, acude_fasetres, justificadacita_fasetres, "
							+ "compromiso_fasetres, observacion_fasetres, mes_fasecuatro, totalhoras_fasecuatro, fechacarta_fasecuatro, "
							+ "observacion_fasecuatro, fase_actual, caso_resuelto, mayor_edad) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, absentismoEnt.getCodigo_absen());
			preparedStatement.setString(2, absentismoEnt.getGrupo());
			preparedStatement.setString(3, absentismoEnt.getCurso());
			preparedStatement.setString(4, absentismoEnt.getNombre_alum());
			preparedStatement.setDate(5, new java.sql.Date(absentismoEnt.getFecha_nacimiento().getTime()));
			preparedStatement.setString(6, absentismoEnt.getMes_faseuno());
			preparedStatement.setString(7, absentismoEnt.getTotalhoras_faseuno());
			preparedStatement.setString(8, absentismoEnt.getFechacarta_faseuno());
			preparedStatement.setString(9, absentismoEnt.getJustificada_faseuno());
			preparedStatement.setString(10, absentismoEnt.getObservacion_faseuno());
			preparedStatement.setString(11, absentismoEnt.getMes_fasedos());			
			preparedStatement.setString(12, absentismoEnt.getTotalhoras_fasedos());
			preparedStatement.setString(13, absentismoEnt.getFechacarta_fasedos());
			preparedStatement.setString(14, absentismoEnt.getJustificada_fasedos());
			preparedStatement.setString(15, absentismoEnt.getFechacita_fasedos());
			preparedStatement.setString(16, absentismoEnt.getHoracita_fasedos());
			preparedStatement.setString(17, absentismoEnt.getAcude_fasedos());
			preparedStatement.setString(18, absentismoEnt.getJustificadacita_fasedos());
			preparedStatement.setString(19, absentismoEnt.getCompromiso_fasedos());
			preparedStatement.setString(20, absentismoEnt.getObservacion_fasedos());
			preparedStatement.setString(21, absentismoEnt.getMes_fasetres());			
			preparedStatement.setString(22, absentismoEnt.getTotalhoras_fasetres());
			preparedStatement.setString(23, absentismoEnt.getFechacarta_fasetres());
			preparedStatement.setString(24, absentismoEnt.getJustificada_fasetres());
			preparedStatement.setString(25, absentismoEnt.getFechacita_fasetres());
			preparedStatement.setString(26, absentismoEnt.getHoracita_fasetres());
			preparedStatement.setString(27, absentismoEnt.getAcude_fasetres());
			preparedStatement.setString(28, absentismoEnt.getJustificadacita_fasetres());
			preparedStatement.setString(29, absentismoEnt.getCompromiso_fasetres());
			preparedStatement.setString(30, absentismoEnt.getObservacion_fasetres());
			preparedStatement.setString(31, absentismoEnt.getMes_fasecuatro());			
			preparedStatement.setString(32, absentismoEnt.getTotalhoras_fasecuatro());
			preparedStatement.setString(33, absentismoEnt.getFechacarta_fasecuatro());
			preparedStatement.setString(34, absentismoEnt.getObservacion_fasecuatro());
			preparedStatement.setString(35, absentismoEnt.getFase_actual());
			preparedStatement.setString(36, absentismoEnt.getCaso_resuelto());
			preparedStatement.setString(37, absentismoEnt.getMayor_edad());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<AbsentismoEntity> getAllAbsentismos() {
		
		List<AbsentismoEntity> absentismos = new ArrayList<AbsentismoEntity>();
		
		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement
					.executeQuery("SELECT * FROM absentismo " + "ORDER BY curso DESC, codigo_absen DESC");

			while (rs.next()) {
				AbsentismoEntity absentismo = new AbsentismoEntity();
				absentismo.setId_absentismo(rs.getInt("id_absentismo"));
				absentismo.setCodigo_absen(rs.getInt("codigo_absen"));
				absentismo.setGrupo(rs.getString("grupo"));
				absentismo.setCurso(rs.getString("curso"));
				absentismo.setNombre_alum(rs.getString("nombre_alum"));
				absentismo.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));

				absentismo.setMes_faseuno(rs.getString("mes_faseuno"));
				absentismo.setMes_fasedos(rs.getString("mes_fasedos"));
				absentismo.setMes_fasetres(rs.getString("mes_fasetres"));
				absentismo.setMes_fasecuatro(rs.getString("mes_fasecuatro"));

				absentismo.setTotalhoras_faseuno(rs.getString("totalhoras_faseuno"));
				absentismo.setTotalhoras_fasedos(rs.getString("totalhoras_fasedos"));
				absentismo.setTotalhoras_fasetres(rs.getString("totalhoras_fasetres"));
				absentismo.setTotalhoras_fasecuatro(rs.getString("totalhoras_fasecuatro"));

				absentismo.setFechacarta_faseuno(rs.getString("fechacarta_faseuno"));
				absentismo.setFechacarta_fasedos(rs.getString("fechacarta_fasedos"));
				absentismo.setFechacarta_fasetres(rs.getString("fechacarta_fasetres"));
				absentismo.setFechacarta_fasecuatro(rs.getString("fechacarta_fasecuatro"));

				absentismo.setJustificada_faseuno(rs.getString("justificada_faseuno"));
				absentismo.setJustificada_fasedos(rs.getString("justificada_fasedos"));
				absentismo.setJustificada_fasetres(rs.getString("justificada_fasetres"));

				absentismo.setJustificadacita_fasedos(rs.getString("justificadacita_fasedos"));
				absentismo.setJustificadacita_fasetres(rs.getString("justificadacita_fasetres"));

				absentismo.setObservacion_faseuno(rs.getString("observacion_faseuno"));
				absentismo.setObservacion_fasedos(rs.getString("observacion_fasedos"));
				absentismo.setObservacion_fasetres(rs.getString("observacion_fasetres"));
				absentismo.setObservacion_fasecuatro(rs.getString("observacion_fasecuatro"));

				absentismo.setFechacita_fasedos(rs.getString("fechacita_fasedos"));
				absentismo.setFechacita_fasetres(rs.getString("fechacita_fasetres"));

				absentismo.setHoracita_fasedos(rs.getString("horacita_fasedos"));
				absentismo.setHoracita_fasetres(rs.getString("horacita_fasetres"));

				absentismo.setAcude_fasedos(rs.getString("acude_fasedos"));
				absentismo.setAcude_fasetres(rs.getString("acude_fasetres"));

				absentismo.setCompromiso_fasedos(rs.getString("compromiso_fasedos"));
				absentismo.setCompromiso_fasetres(rs.getString("compromiso_fasetres"));

				absentismo.setFase_actual(rs.getString("fase_actual"));
				absentismo.setCaso_resuelto(rs.getString("caso_resuelto"));
				absentismo.setMayor_edad(rs.getString("mayor_edad"));

				absentismos.add(absentismo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return absentismos;
	}

	public void updateAbsentismo(AbsentismoEntity absentismoEnt) {
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE absentismo SET codigo_absen=?, grupo=?, curso=?, "
							+ "nombre_alum=?, fecha_nacimiento=?, mes_faseuno=?, totalhoras_faseuno=?, fechacarta_faseuno=?, "
							+ "justificada_faseuno=?, observacion_faseuno=?, mes_fasedos=?, totalhoras_fasedos=?, fechacarta_fasedos=?, "
							+ "justificada_fasedos=?, fechacita_fasedos=?, horacita_fasedos=?, acude_fasedos=?, justificadacita_fasedos=?, "
							+ "compromiso_fasedos=?, observacion_fasedos=?, mes_fasetres=?, totalhoras_fasetres=?, fechacarta_fasetres=?, "
							+ "justificada_fasetres=?, fechacita_fasetres=?, horacita_fasetres=?, acude_fasetres=?, justificadacita_fasetres=?, "
							+ "compromiso_fasetres=?, observacion_fasetres=?, mes_fasecuatro=?, totalhoras_fasecuatro=?, fechacarta_fasecuatro=?, "
							+ "observacion_fasecuatro=?, fase_actual=?, caso_resuelto=?, mayor_edad=? "
							+ "WHERE id_absentismo=?");

			preparedStatement.setInt(1, absentismoEnt.getCodigo_absen());
			preparedStatement.setString(2, absentismoEnt.getGrupo());
			preparedStatement.setString(3, absentismoEnt.getCurso());
			preparedStatement.setString(4, absentismoEnt.getNombre_alum());
			preparedStatement.setDate(5, new java.sql.Date(absentismoEnt.getFecha_nacimiento().getTime()));
			preparedStatement.setString(6, absentismoEnt.getMes_faseuno());			
			preparedStatement.setString(7, absentismoEnt.getTotalhoras_faseuno());			
			preparedStatement.setString(8, absentismoEnt.getFechacarta_faseuno());
			preparedStatement.setString(9, absentismoEnt.getJustificada_faseuno());
			preparedStatement.setString(10, absentismoEnt.getObservacion_faseuno());
			preparedStatement.setString(11, absentismoEnt.getMes_fasedos());			
			preparedStatement.setString(12, absentismoEnt.getTotalhoras_fasedos());			
			preparedStatement.setString(13, absentismoEnt.getFechacarta_fasedos());
			preparedStatement.setString(14, absentismoEnt.getJustificada_fasedos());			
			preparedStatement.setString(15, absentismoEnt.getFechacita_fasedos());
			preparedStatement.setString(16, absentismoEnt.getHoracita_fasedos());
			preparedStatement.setString(17, absentismoEnt.getAcude_fasedos());
			preparedStatement.setString(18, absentismoEnt.getJustificadacita_fasedos());
			preparedStatement.setString(19, absentismoEnt.getCompromiso_fasedos());
			preparedStatement.setString(20, absentismoEnt.getObservacion_fasedos());
			preparedStatement.setString(21, absentismoEnt.getMes_fasetres());			
			preparedStatement.setString(22, absentismoEnt.getTotalhoras_fasetres());
			preparedStatement.setString(23, absentismoEnt.getFechacarta_fasetres());
			preparedStatement.setString(24, absentismoEnt.getJustificada_fasetres());
			preparedStatement.setString(25, absentismoEnt.getFechacita_fasetres());
			preparedStatement.setString(26, absentismoEnt.getHoracita_fasetres());
			preparedStatement.setString(27, absentismoEnt.getAcude_fasetres());
			preparedStatement.setString(28, absentismoEnt.getJustificadacita_fasetres());
			preparedStatement.setString(29, absentismoEnt.getCompromiso_fasetres());
			preparedStatement.setString(30, absentismoEnt.getObservacion_fasetres());
			preparedStatement.setString(31, absentismoEnt.getMes_fasecuatro());
			preparedStatement.setString(32, absentismoEnt.getTotalhoras_fasecuatro());
			preparedStatement.setString(33, absentismoEnt.getFechacarta_fasecuatro());
			preparedStatement.setString(34, absentismoEnt.getObservacion_fasecuatro());
			preparedStatement.setString(35, absentismoEnt.getFase_actual());
			preparedStatement.setString(36, absentismoEnt.getCaso_resuelto());
			preparedStatement.setString(37, absentismoEnt.getMayor_edad());
			preparedStatement.setInt(38, absentismoEnt.getId_absentismo());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAbsentismoById(int id_absentismo) {
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM absentismo WHERE id_absentismo=?");
			preparedStatement.setInt(1, id_absentismo);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public AbsentismoEntity getAbsentismoById(int id_absentismo) {
		
		AbsentismoEntity absentismo = new AbsentismoEntity();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM absentismo WHERE id_absentismo=?");
			preparedStatement.setInt(1, id_absentismo);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				absentismo.setId_absentismo(rs.getInt("id_absentismo"));
				absentismo.setCodigo_absen(rs.getInt("codigo_absen"));
				absentismo.setGrupo(rs.getString("grupo"));
				absentismo.setCurso(rs.getString("curso"));
				absentismo.setNombre_alum(rs.getString("nombre_alum"));
				absentismo.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				absentismo.setMes_faseuno(rs.getString("mes_faseuno"));
				absentismo.setTotalhoras_faseuno(rs.getString("totalhoras_faseuno"));
				absentismo.setFechacarta_faseuno(rs.getString("fechacarta_faseuno"));
				absentismo.setJustificada_faseuno(rs.getString("justificada_faseuno"));
				absentismo.setObservacion_faseuno(rs.getString("observacion_faseuno"));
				absentismo.setMes_fasedos(rs.getString("mes_fasedos"));
				absentismo.setTotalhoras_fasedos(rs.getString("totalhoras_fasedos"));
				absentismo.setFechacarta_fasedos(rs.getString("fechacarta_fasedos"));
				absentismo.setJustificada_fasedos(rs.getString("justificada_fasedos"));
				absentismo.setFechacita_fasedos(rs.getString("fechacita_fasedos"));
				absentismo.setHoracita_fasedos(rs.getString("horacita_fasedos"));
				absentismo.setAcude_fasedos(rs.getString("acude_fasedos"));
				absentismo.setJustificadacita_fasedos(rs.getString("justificadacita_fasedos"));
				absentismo.setCompromiso_fasedos(rs.getString("compromiso_fasedos"));
				absentismo.setObservacion_fasedos(rs.getString("observacion_fasedos"));
				absentismo.setMes_fasetres(rs.getString("mes_fasetres"));
				absentismo.setTotalhoras_fasetres(rs.getString("totalhoras_fasetres"));
				absentismo.setFechacarta_fasetres(rs.getString("fechacarta_fasetres"));
				absentismo.setJustificada_fasetres(rs.getString("justificada_fasetres"));
				absentismo.setFechacita_fasetres(rs.getString("fechacita_fasetres"));
				absentismo.setHoracita_fasetres(rs.getString("horacita_fasetres"));
				absentismo.setAcude_fasetres(rs.getString("acude_fasetres"));
				absentismo.setJustificadacita_fasetres(rs.getString("justificadacita_fasetres"));
				absentismo.setCompromiso_fasetres(rs.getString("compromiso_fasetres"));
				absentismo.setObservacion_fasetres(rs.getString("observacion_fasetres"));
				absentismo.setMes_fasecuatro(rs.getString("mes_fasecuatro"));
				absentismo.setTotalhoras_fasecuatro(rs.getString("totalhoras_fasecuatro"));
				absentismo.setFechacarta_fasecuatro(rs.getString("fechacarta_fasecuatro"));
				absentismo.setObservacion_fasecuatro(rs.getString("observacion_fasecuatro"));
				absentismo.setFase_actual(rs.getString("fase_actual"));
				absentismo.setCaso_resuelto(rs.getString("caso_resuelto"));
				absentismo.setMayor_edad(rs.getString("mayor_edad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return absentismo;
	}
}