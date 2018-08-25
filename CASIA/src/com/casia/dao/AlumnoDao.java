package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.casia.config.conexionDB;
import com.casia.entity.AbsentismoEntity;
import com.casia.entity.AcosoEntity;
import com.casia.entity.ActMedicaEntity;
import com.casia.entity.InfJuridicaEntity;
import com.casia.entity.InfMedicaEntity;
import com.casia.entity.ParteEntity;
import com.casia.entity.SancionEntity;

public class AlumnoDao {
	
	private static Connection connection;

	public AlumnoDao() {
		connection = conexionDB.getConnection();
	}
	
	public List<ParteEntity> getAlumParte(String nombre_alum) {
		List<ParteEntity> partes = new ArrayList<ParteEntity>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM parte WHERE nombre_alum=?");
			preparedStatement.setString(1, nombre_alum);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				ParteEntity parte = new ParteEntity();
				parte.setTipo_sancion(rs.getString("tipo_sancion"));
				parte.setNombre_profe(rs.getString("nombre_profe"));
				parte.setFecha_parte(rs.getDate("fecha_parte"));
				parte.setCodigo(rs.getInt("codigo"));
				parte.setId_parte(rs.getInt("id_parte"));
				partes.add(parte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return partes;
	}
	
	public List<SancionEntity> getAlumSancion(String nombre_alum) {
		List<SancionEntity> sanciones = new ArrayList<SancionEntity>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM sancion WHERE nombre_alum=?");
			preparedStatement.setString(1, nombre_alum);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				SancionEntity sancion = new SancionEntity();
				sancion.setTipo_sancion(rs.getString("tipo_sancion"));
				sancion.setTotal_dias(rs.getInt("total_dias"));
				sancion.setId_sancion(rs.getInt("id_sancion"));
				sanciones.add(sancion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sanciones;
	}
	
	public List<AbsentismoEntity> getAlumAbsentismo(String nombre_alum) {
		List<AbsentismoEntity> absentismos = new ArrayList<AbsentismoEntity>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM absentismo WHERE nombre_alum=?");
			preparedStatement.setString(1, nombre_alum);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				AbsentismoEntity absentismo = new AbsentismoEntity();
				absentismo.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				absentismo.setCaso_resuelto(rs.getString("caso_resuelto"));
				absentismo.setCodigo_absen(rs.getInt("codigo_absen"));
				absentismo.setId_absentismo(rs.getInt("id_absentismo"));
				absentismos.add(absentismo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return absentismos;
	}
	
	public List<ActMedicaEntity> getAlumActMedica(String nombre_alum) {
		List<ActMedicaEntity> actmedicas = new ArrayList<ActMedicaEntity>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM actmedica WHERE nombre_alum=?");
			preparedStatement.setString(1, nombre_alum);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ActMedicaEntity actmedicaEnt = new ActMedicaEntity();
				actmedicaEnt.setFecha_actuacion(rs.getDate("fecha_actuacion"));
				actmedicaEnt.setId_actuacion(rs.getInt("id_actuacion"));
				actmedicas.add(actmedicaEnt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actmedicas;
	}
	
	public List<InfMedicaEntity> getAlumInfMedica(String nombre_alum) {
		List<InfMedicaEntity> medicas = new ArrayList<InfMedicaEntity>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM infmedica WHERE nombre_alum=?");
			preparedStatement.setString(1, nombre_alum);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				InfMedicaEntity infmedica = new InfMedicaEntity();
				infmedica.setId_medica(rs.getInt("id_medica"));
				infmedica.setDocumentacion(rs.getString("documentacion"));
				infmedica.setMedicacion(rs.getString("medicacion"));
				medicas.add(infmedica);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medicas;
		}
	
	public List<InfJuridicaEntity> getAlumInfJuridica(String nombre_alum) {
		List<InfJuridicaEntity> juridicas = new ArrayList<InfJuridicaEntity>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM infjuridica WHERE nombre_alum=?");
			preparedStatement.setString(1, nombre_alum);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				InfJuridicaEntity infjuridica = new InfJuridicaEntity();
				infjuridica.setId_juridica(rs.getInt("id_juridica"));
				infjuridica.setDocumentacion(rs.getString("documentacion"));
				juridicas.add(infjuridica);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return juridicas;
	}
	
	public List<AcosoEntity> getAlumAcoso(String nombre_alum) {
		List<AcosoEntity> acosos = new ArrayList<AcosoEntity>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM acoso WHERE nombre_alum=? OR nombre_alum2=?");
			preparedStatement.setString(1, nombre_alum);
			preparedStatement.setString(2, nombre_alum);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				AcosoEntity acoso = new AcosoEntity();
				acoso.setNombre_alum(rs.getString("nombre_alum"));
				acoso.setNombre_alum2(rs.getString("nombre_alum2"));
				acoso.setCodigo(rs.getInt("codigo"));
				acoso.setInf_aportada(rs.getString("inf_aportada"));
				acoso.setInicio_protocolo(rs.getString("inicio_protocolo"));				
				acoso.setId_acoso(rs.getInt("id_acoso"));
				acosos.add(acoso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acosos;
	}

}
