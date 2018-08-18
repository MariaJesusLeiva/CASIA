package com.casia.entity;

import java.util.Date;

public class RecreoEntity {
	private Integer id_recreo;
	private Integer id_sancion;
	private Date fecha_inicio;
	private String observacion;
	private String trabajo;
	private String asistencia;
	private String nombre_alum;
	public Integer getId_recreo() {
		return id_recreo;
	}
	public void setId_recreo(Integer id_recreo) {
		this.id_recreo = id_recreo;
	}
	public Integer getId_sancion() {
		return id_sancion;
	}
	public void setId_sancion(Integer id_sancion) {
		this.id_sancion = id_sancion;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	public String getAsistencia() {
		return asistencia;
	}
	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}
	public String getNombre_alum() {
		return nombre_alum;
	}
	public void setNombre_alum(String nombre_alum) {
		this.nombre_alum = nombre_alum;
	}
	
	

}
