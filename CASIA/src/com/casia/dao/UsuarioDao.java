package com.casia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.casia.config.conexionDB;

public class UsuarioDao {
	
	private static Connection connection;
	
	public UsuarioDao() {
		connection = conexionDB.getConnection();
	}
	
	//Metodo para comprobar si el usuario y contraseña se encuentran en la bd
	
/*    public boolean siCuentaExiste(String name_user, String pass_user) throws SQLException
    {
        String sql = "SELECT * FROM usuario WHERE name_user ='"+name_user+"' AND pass_user ='"+pass_user+"'";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        return rs.next();
    }*/
	public static boolean validarLogin(String name_user, String pass_user) throws SQLException
    {
		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("SELECT * FROM usuario WHERE name_user=? AND pass_user=?");
			ps.setString(1, name_user);
			ps.setString(2, pass_user);
			rs = ps.executeQuery();
			status = rs.next();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
    }
	
	public static Integer ObtenerRol(String name_user) throws SQLException
	{
		PreparedStatement ps = null;
		ps = connection.prepareStatement("SELECT `Rol_id` FROM `usuario` WHERE `name_user` =:name_user");
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
            return rs.getInt("Rol_id");
        }
        
        return null;
    }
	    
    
    //Metodo para comprobar si el nombre de usuario recibido ya esta registrado
    public boolean siNombreUsuarioExiste(String name_user) throws SQLException
    {
        String sql = "SELECT * FROM usuario WHERE name_user ='"+name_user+"'";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
 
        return rs.next();
    }
    
    //Metodo para registrar un usuario
    public void registrarUser(String name_user, String pass_user) throws SQLException
    {
        String sql = "INSERT INTO usuario(name_user, pass_user) VALUES ('"+name_user+"','"+pass_user+"')";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
    }

}
