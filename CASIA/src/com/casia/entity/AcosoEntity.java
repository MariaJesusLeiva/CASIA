/*
 * Nombre aplicación: CASIA
 * Autor: María Jesús Leiva Romera
 * Año: 2018
 */

package com.casia.entity;

import java.util.Date;

public class AcosoEntity {
	
	private Integer id_acoso;
	private Integer codigo;
	private String curso;
	private String grupo;
	private String nombre_alum;
	private String tipo;
	private String grupo2;
	private String nombre_alum2;
	private String tipo2;	
	private Date fecha_reunion;
	private String hora_reunion;
	private String inf_aportada;
	private String medidas;
	private String asistentes;
	private String inicio_protocolo;
	
	public Integer getId_acoso() {
		return id_acoso;
	}
	public void setId_acoso(Integer id_acoso) {
		this.id_acoso = id_acoso;
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
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getNombre_alum() {
		return nombre_alum;
	}
	public void setNombre_alum(String nombre_alum) {
		this.nombre_alum = nombre_alum;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getGrupo2() {
		return grupo2;
	}
	public void setGrupo2(String grupo2) {
		this.grupo2 = grupo2;
	}
	public String getNombre_alum2() {
		return nombre_alum2;
	}
	public void setNombre_alum2(String nombre_alum2) {
		this.nombre_alum2 = nombre_alum2;
	}
	public String getTipo2() {
		return tipo2;
	}
	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}
	public Date getFecha_reunion() {
		return fecha_reunion;
	}
	public void setFecha_reunion(Date fecha_reunion) {
		this.fecha_reunion = fecha_reunion;
	}
	public String getHora_reunion() {
		return hora_reunion;
	}
	public void setHora_reunion(String hora_reunion) {
		this.hora_reunion = hora_reunion;
	}
	public String getInf_aportada() {
		return inf_aportada;
	}
	public void setInf_aportada(String inf_aportada) {
		this.inf_aportada = inf_aportada;
	}
	public String getMedidas() {
		return medidas;
	}
	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}	
	public String getAsistentes() {
		return asistentes;
	}
	public void setAsistentes(String asistentes) {
		this.asistentes = asistentes;
	}
	public String getInicio_protocolo() {
		return inicio_protocolo;
	}
	public void setInicio_protocolo(String inicio_protocolo) {
		this.inicio_protocolo = inicio_protocolo;
	}
}