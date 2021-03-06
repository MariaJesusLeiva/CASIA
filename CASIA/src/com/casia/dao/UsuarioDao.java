/*
 * Nombre aplicaci�n: CASIA
 * Autor: Mar�a Jes�s Leiva Romera
 * A�o: 2018
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
import com.casia.entity.UsuarioEntity;

public class UsuarioDao {

	private static Connection connection;

	public UsuarioDao() {
		connection = conexionDB.getConnection();
	}

	public void addUsuario(UsuarioEntity usuarioEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO usuario(name_user, pass_user, rol_user) VALUES (?, ?, ?)");

			preparedStatement.setString(1, usuarioEnt.getName_user());
			preparedStatement.setString(2, usuarioEnt.getPass_user());
			preparedStatement.setString(3, usuarioEnt.getRol_user());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUsuarioById(int id_user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM usuario WHERE id_user=?");
			preparedStatement.setInt(1, id_user);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String ObtenerRol(UsuarioEntity userEnt) throws SQLException {
		PreparedStatement ps = null;
		String name_user = userEnt.getName_user();
		String pass_user = userEnt.getPass_user();

		ps = connection.prepareStatement("SELECT name_user, pass_user, rol_user FROM usuario");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String name_userDB = rs.getString("name_user");
			String pass_userDB = rs.getString("pass_user");
			String rol_userDB = rs.getString("rol_user");

			if (name_user.equals(name_userDB) && pass_user.equals(pass_userDB) && rol_userDB.equals("admin")) {
				return "admin";
			} else if (name_user.equals(name_userDB) && pass_user.equals(pass_userDB)
					&& rol_userDB.equals("directiva")) {
				return "directiva";
			}

		}
		return " * Usuario o contrase&ntilde;a inv&aacute;lidos";
	}

	public boolean siNombreUsuarioExiste(String name_user) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE name_user ='" + name_user + "'";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		return rs.next();
	}

	public List<UsuarioEntity> getAllUsuarios() {
		List<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();

		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(
					"SELECT * FROM usuario WHERE rol_user = 'directiva' ORDER BY rol_user DESC");
			while (rs.next()) {
				UsuarioEntity usuario = new UsuarioEntity();
				usuario.setId_user(rs.getInt("id_user"));
				usuario.setName_user(rs.getString("name_user"));
				usuario.setPass_user(rs.getString("pass_user"));
				usuario.setRol_user(rs.getString("rol_user"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public void updateUsuario(UsuarioEntity usuarioEnt) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE usuario SET name_user=?, pass_user=? WHERE id_user=?");

			preparedStatement.setString(1, usuarioEnt.getName_user());
			preparedStatement.setString(2, usuarioEnt.getPass_user());
			preparedStatement.setInt(3, usuarioEnt.getId_user());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UsuarioEntity getUsuarioById(int id_user) {
		UsuarioEntity usuario = new UsuarioEntity();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usuario WHERE id_user=?");
			preparedStatement.setInt(1, id_user);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				usuario.setId_user(rs.getInt("id_user"));
				usuario.setName_user(rs.getString("name_user"));
				usuario.setPass_user(rs.getString("pass_user"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
}