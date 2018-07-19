package com.casia.entity;

public class UsuarioEntity {
	private int id_user;
	private String name_user;
	private String pass_user;
	private int Rol_id;
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	public String getPass_user() {
		return pass_user;
	}
	public void setPass_user(String pass_user) {
		this.pass_user = pass_user;
	}
	public int getRol_id() {
		return Rol_id;
	}
	public void setRol_id(int rol_id) {
		Rol_id = rol_id;
	}
}
