/*
 * Nombre aplicación: CASIA
 * Autor: María Jesús Leiva Romera
 * Año: 2018
 */

package com.casia.entity;

import java.util.Date;

public class ParteEntity {
	private Integer id_parte;
	private Integer codigo;
	private String curso;
	private String tipo_sancion;
	private Date fecha_parte;
	private String nombre_profe;
	private String nombre_alum;
	private String grupo;
	private String motivo_parte;
	
	
	public Integer getId_parte() {
		return id_parte;
	}
	public void setId_parte(Integer id_parte) {
		this.id_parte = id_parte;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getTipo_sancion() {
		return tipo_sancion;
	}
	public void setTipo_sancion(String tipo_sancion) {
		this.tipo_sancion = tipo_sancion;
	}
	public Date getFecha_parte() {
		return fecha_parte;
	}
	public void setFecha_parte(Date fecha_parte) {
		this.fecha_parte = fecha_parte;
	}
	public String getNombre_profe() {
		return nombre_profe;
	}
	public void setNombre_profe(String nombre_profe) {
		this.nombre_profe = nombre_profe;
	}
	public String getNombre_alum() {
		return nombre_alum;
	}
	public void setNombre_alum(String nombre_alum) {
		this.nombre_alum = nombre_alum;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getMotivo_parte() {
		return motivo_parte;
	}
	public void setMotivo_parte(String motivo_parte) {
		this.motivo_parte = motivo_parte;
	}
}