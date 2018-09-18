/*
 * Nombre aplicación: CASIA
 * Autor: María Jesús Leiva Romera
 * Año: 2018
 */

package com.casia.entity;

import java.util.Date;

public class InfMedicaEntity {
	
	private Integer id_medica;
	private String curso;
	private String grupo;
	private Date fecha_nacimiento;
	private String nombre_alum;
	private String inf_medica;
	private String documentacion;
	private String medicacion;
	
	
	public Integer getId_medica() {
		return id_medica;
	}
	public void setId_medica(Integer id_medica) {
		this.id_medica = id_medica;
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
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getNombre_alum() {
		return nombre_alum;
	}
	public void setNombre_alum(String nombre_alum) {
		this.nombre_alum = nombre_alum;
	}
	public String getInf_medica() {
		return inf_medica;
	}
	public void setInf_medica(String inf_medica) {
		this.inf_medica = inf_medica;
	}
	public String getDocumentacion() {
		return documentacion;
	}
	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}
	public String getMedicacion() {
		return medicacion;
	}
	public void setMedicacion(String medicacion) {
		this.medicacion = medicacion;
	}
}