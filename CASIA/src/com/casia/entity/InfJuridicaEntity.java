/*
 * Nombre aplicación: CASIA
 * Autor: María Jesús Leiva Romera
 * Año: 2018
 */

package com.casia.entity;

import java.util.Date;

public class InfJuridicaEntity {
	
	private Integer id_juridica;
	private String curso;
	private String grupo;
	private Date fecha_nacimiento;
	private String nombre_alum;
	private String inf_juridica;
	private String documentacion;
	
	public Integer getId_juridica() {
		return id_juridica;
	}
	public void setId_juridica(Integer id_juridica) {
		this.id_juridica = id_juridica;
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
	public String getInf_juridica() {
		return inf_juridica;
	}
	public void setInf_juridica(String inf_juridica) {
		this.inf_juridica = inf_juridica;
	}
	public String getDocumentacion() {
		return documentacion;
	}
	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}
}