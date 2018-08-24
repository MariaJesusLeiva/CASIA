package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.ReservaDiaSancionEntity;

public class ReservaDiaSancionDao {

	private static Connection connection;

	public ReservaDiaSancionDao() {
		connection = conexionDB.getConnection();
	}

	public void addReserva(ReservaDiaSancionEntity reservaEnt) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO reservadiasancion(id_sancion, fecha_inicio, nombre_alum, tipo_sancion, asistencia) "
							+ "VALUES (?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, reservaEnt.getId_sancion());
			preparedStatement.setDate(2, new java.sql.Date(reservaEnt.getFecha_inicio().getTime()));
			preparedStatement.setString(3, reservaEnt.getNombre_alum());
			preparedStatement.setString(4, reservaEnt.getTipo_sancion());
			preparedStatement.setString(5, reservaEnt.getAsistencia());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteReservaById(int id_sancion) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM reservadiasancion WHERE id_sancion=?");
			preparedStatement.setInt(1, id_sancion);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ReservaDiaSancionEntity> getAllReservas() {
		List<ReservaDiaSancionEntity> reservas = new ArrayList<ReservaDiaSancionEntity>();

		try {
			Statement statement = connection.createStatement();
			/*
			 * ResultSet rs = statement.executeQuery("SELECT * FROM sancion s " +
			 * "INNER JOIN parte p ON s.id_parte=p.id_parte " +
			 * "ORDER BY s.fecha_inicio ASC");
			 */
			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion ORDER BY fecha_inicio ASC");
			/*
			 * ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion r " +
			 * "INNER JOIN sancion s ON s.id_sancion=r.id_sancion " +
			 * "WHERE r.tipo_sancion=s.tipo_sancion " + "ORDER BY r.fecha_inicio ASC");
			 */

			while (rs.next()) {
				ReservaDiaSancionEntity reserva = new ReservaDiaSancionEntity();
				reserva.setId_sancion(rs.getInt("id_sancion"));
				reserva.setId_reserva(rs.getInt("id_reserva"));
				reserva.setTipo_sancion(rs.getString("tipo_sancion"));
				reserva.setNombre_alum(rs.getString("nombre_alum"));
				reserva.setFecha_inicio(rs.getDate("fecha_inicio"));
				reserva.setAsistencia(rs.getString("asistencia"));

				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public List<ReservaDiaSancionEntity> getAllReservasRecreo() {
		List<ReservaDiaSancionEntity> reservas = new ArrayList<ReservaDiaSancionEntity>();

		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion WHERE tipo_sancion = 'Recreo' ORDER BY fecha_inicio ASC");

			while (rs.next()) {
				ReservaDiaSancionEntity reserva = new ReservaDiaSancionEntity();
				reserva.setId_sancion(rs.getInt("id_sancion"));
				reserva.setId_reserva(rs.getInt("id_reserva"));
				reserva.setTipo_sancion(rs.getString("tipo_sancion"));
				reserva.setNombre_alum(rs.getString("nombre_alum"));
				reserva.setFecha_inicio(rs.getDate("fecha_inicio"));
				reserva.setAsistencia(rs.getString("asistencia"));

				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public List<ReservaDiaSancionEntity> getAllReservasPROA() {
		List<ReservaDiaSancionEntity> reservas = new ArrayList<ReservaDiaSancionEntity>();

		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion WHERE tipo_sancion = 'PROA' ORDER BY fecha_inicio ASC");

			while (rs.next()) {
				ReservaDiaSancionEntity reserva = new ReservaDiaSancionEntity();
				reserva.setId_sancion(rs.getInt("id_sancion"));
				reserva.setId_reserva(rs.getInt("id_reserva"));
				reserva.setTipo_sancion(rs.getString("tipo_sancion"));
				reserva.setNombre_alum(rs.getString("nombre_alum"));
				reserva.setFecha_inicio(rs.getDate("fecha_inicio"));
				reserva.setAsistencia(rs.getString("asistencia"));

				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public List<ReservaDiaSancionEntity> getAllRecreoPROA() {
		List<ReservaDiaSancionEntity> reservas = new ArrayList<ReservaDiaSancionEntity>();
		try {
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion r " +
								"INNER JOIN sancion s ON s.id_sancion = r.id_sancion " +
								"ORDER BY r.fecha_inicio ASC");

			while (rs.next()) {
				ReservaDiaSancionEntity reserva = new ReservaDiaSancionEntity();
				reserva.setId_reserva(rs.getInt("id_reserva"));
				reserva.setId_sancion(rs.getInt("id_sancion"));
				reserva.setFecha_inicio(rs.getDate("fecha_inicio"));
				reserva.setNombre_alum(rs.getString("nombre_alum"));
				reserva.setTipo_sancion(rs.getString("tipo_sancion"));
				reserva.setAsistencia(rs.getString("asistencia"));

				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public List<ReservaDiaSancionEntity> getAllRecreosHoy() {
		List<ReservaDiaSancionEntity> reservas = new ArrayList<ReservaDiaSancionEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion r WHERE tipo_sancion= 'Recreo' AND fecha_inicio like curdate()");

			while (rs.next()) {
				ReservaDiaSancionEntity reserva = new ReservaDiaSancionEntity();
				reserva.setId_reserva(rs.getInt("id_reserva"));
				reserva.setNombre_alum(rs.getString("nombre_alum"));

				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public List<ReservaDiaSancionEntity> getAllPROAsHoy() {
		List<ReservaDiaSancionEntity> reservas = new ArrayList<ReservaDiaSancionEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion r WHERE tipo_sancion= 'PROA' AND fecha_inicio like curdate()");

			while (rs.next()) {
				ReservaDiaSancionEntity reserva = new ReservaDiaSancionEntity();
				reserva.setId_reserva(rs.getInt("id_reserva"));
				reserva.setNombre_alum(rs.getString("nombre_alum"));

				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public void updateAsistencia(Integer id_sancion) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE reservadiasancion SET asistencia= 'Sí' WHERE id_sancion=?");
			
			preparedStatement.setInt(1, id_sancion);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
