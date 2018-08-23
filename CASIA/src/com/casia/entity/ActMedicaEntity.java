package com.casia.entity;

import java.util.Date;

public class ActMedicaEntity {
	private Integer id_actuacion;
	private String curso;
	private String grupo;
	private Date fecha_actuacion;
	private String nombre_alum;
	private String observacion;
	
	
	public Integer getId_actuacion() {
		return id_actuacion;
	}
	public void setId_actuacion(Integer id_actuacion) {
		this.id_actuacion = id_actuacion;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public Date getFecha_actuacion() {
		return fecha_actuacion;
	}
	public void setFecha_actuacion(Date fecha_actuacion) {
		this.fecha_actuacion = fecha_actuacion;
	}
	public String getNombre_alum() {
		return nombre_alum;
	}
	public void setNombre_alum(String nombre_alum) {
		this.nombre_alum = nombre_alum;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}