/*
 * Nombre aplicación: CASIA
 * Autor: María Jesús Leiva Romera
 * Año: 2018
 */

package com.casia.entity;

import java.util.Date;

public class SancionEntity {
	private Integer id_sancion;
	private Integer id_parte;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Integer total_dias;
	private String tipo_sancion;
	private String observacion;
	private String trabajo;
	private String nombre_alum;
	private String asignado_dias;
	
	public Integer getId_sancion() {
		return id_sancion;
	}
	public void setId_sancion(Integer id_sancion) {
		this.id_sancion = id_sancion;
	}
	public Integer getId_parte() {
		return id_parte;
	}
	public void setId_parte(Integer id_parte) {
		this.id_parte = id_parte;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public Integer getTotal_dias() {
		return total_dias;
	}
	public void setTotal_dias(Integer total_dias) {
		this.total_dias = total_dias;
	}
	public String getTipo_sancion() {
		return tipo_sancion;
	}
	public void setTipo_sancion(String tipo_sancion) {
		this.tipo_sancion = tipo_sancion;
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
	public String getNombre_alum() {
		return nombre_alum;
	}
	public void setNombre_alum(String nombre_alum) {
		this.nombre_alum = nombre_alum;
	}
	public String getAsignado_dias() {
		return asignado_dias;
	}
	public void setAsignado_dias(String asignado_dias) {
		this.asignado_dias = asignado_dias;
	}
}