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
import com.casia.entity.ReservaDiaSancionEntity;
import com.casia.entity.SancionEntity;

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

	public void updateReserva(ReservaDiaSancionEntity reservaEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE reservadiasancion SET id_sancion=?, fecha_inicio=?, nombre_alum=?,"
							+ "tipo_sancion=?, asistencia=? WHERE id_reserva=?");
			
			preparedStatement.setInt(1, reservaEnt.getId_sancion());
			preparedStatement.setDate(2, new java.sql.Date(reservaEnt.getFecha_inicio().getTime()));
			preparedStatement.setString(3, reservaEnt.getNombre_alum());
			preparedStatement.setString(4, reservaEnt.getTipo_sancion());
			preparedStatement.setString(5, reservaEnt.getAsistencia());
			preparedStatement.setInt(6, reservaEnt.getId_reserva());
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
	
	public ReservaDiaSancionEntity getReservaById(int id_reserva) {

		ReservaDiaSancionEntity reserva = new ReservaDiaSancionEntity();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM reservadiasancion WHERE id_reserva=?");
			preparedStatement.setInt(1, id_reserva);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				reserva.setId_reserva(rs.getInt("id_reserva"));
				reserva.setId_sancion(rs.getInt("id_sancion"));
				reserva.setFecha_inicio(rs.getDate("fecha_inicio"));
				reserva.setNombre_alum(rs.getString("nombre_alum"));
				reserva.setTipo_sancion(rs.getString("tipo_sancion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reserva;
	}

	public List<ReservaDiaSancionEntity> getAllReservas() {
		List<ReservaDiaSancionEntity> reservas = new ArrayList<ReservaDiaSancionEntity>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion ORDER BY fecha_inicio ASC");

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
			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion WHERE tipo_sancion= 'Recreo' AND fecha_inicio like curdate()");

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
			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion WHERE tipo_sancion= 'PROA' AND fecha_inicio like curdate()");

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
	
	public List<SancionEntity> getAllAsistenciaPROAs() {
		List<SancionEntity> proas = new ArrayList<SancionEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM reservadiasancion r INNER JOIN sancion s ON s.id_sancion=r.id_sancion "
							+ "WHERE r.tipo_sancion= 'PROA' AND s.tipo_sancion= 'PROA' AND r.asistencia IS NULL "
							+ "ORDER BY r.fecha_inicio ASC");

			while (rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proas;
	}
	
	public List<SancionEntity> getAllAsistenciaRecreos() {
		List<SancionEntity> recreos = new ArrayList<SancionEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM reservadiasancion r INNER JOIN sancion s ON s.id_sancion=r.id_sancion "
							+ "WHERE r.tipo_sancion= 'Recreo' AND s.tipo_sancion= 'Recreo' AND r.asistencia IS NULL "
							+ "ORDER BY r.fecha_inicio ASC");

			while (rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recreos;
	}

	public static List<SancionEntity> getAllRecreos() {
		List<SancionEntity> recreos = new ArrayList<SancionEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM sancion WHERE tipo_sancion= 'Recreo' ORDER BY fecha_inicio ASC");

			while (rs.next()) {
				SancionEntity recreo = new SancionEntity();
				recreo.setId_sancion(rs.getInt("id_sancion"));
				recreo.setFecha_inicio(rs.getDate("fecha_inicio"));
				recreo.setObservacion(rs.getString("observacion"));
				recreo.setTrabajo(rs.getString("trabajo"));
				recreo.setNombre_alum(rs.getString("nombre_alum"));

				recreos.add(recreo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recreos;
	}

	public SancionEntity getAlumRecreoByIdSancion(int id_sancion) {
		SancionEntity alumrecreo = new SancionEntity();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM sancion WHERE id_sancion=?");
			preparedStatement.setInt(1, id_sancion);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				alumrecreo.setNombre_alum(rs.getString("nombre_alum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumrecreo;
	}

	public List<ReservaDiaSancionEntity> getAllRecreosPendientes() {
		List<ReservaDiaSancionEntity> recreos = new ArrayList<ReservaDiaSancionEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion WHERE tipo_sancion = 'Recreo' AND asistencia IS NULL ORDER BY fecha_inicio ASC");

			while (rs.next()) {
				ReservaDiaSancionEntity recreo = new ReservaDiaSancionEntity();
				recreo.setId_reserva(rs.getInt("id_reserva"));
				recreo.setFecha_inicio(rs.getDate("fecha_inicio"));
				recreo.setNombre_alum(rs.getString("nombre_alum"));

				recreos.add(recreo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recreos;
	}
	
	public List<ReservaDiaSancionEntity> getAllPROAsPendientes() {
		List<ReservaDiaSancionEntity> proas = new ArrayList<ReservaDiaSancionEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM reservadiasancion WHERE tipo_sancion = 'PROA' AND asistencia IS NULL ORDER BY fecha_inicio ASC");

			while (rs.next()) {
				ReservaDiaSancionEntity proa = new ReservaDiaSancionEntity();
				proa.setId_reserva(rs.getInt("id_reserva"));
				proa.setFecha_inicio(rs.getDate("fecha_inicio"));
				proa.setNombre_alum(rs.getString("nombre_alum"));

				proas.add(proa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proas;
	}	
}