/*
 * Nombre aplicación: CASIA
 * Autor: María Jesús Leiva Romera
 * Año: 2018
 */

package com.casia.entity;

import java.util.Date;

public class ReservaDiaSancionEntity {
	private Integer id_sancion;
	private Integer id_reserva;
	private Date fecha_inicio;
	private String nombre_alum;
	private String tipo_sancion;
	private String asistencia;
	
	public Integer getId_sancion() {
		return id_sancion;
	}
	public void setId_sancion(Integer id_sancion) {
		this.id_sancion = id_sancion;
	}
	public Integer getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getNombre_alum() {
		return nombre_alum;
	}
	public void setNombre_alum(String nombre_alum) {
		this.nombre_alum = nombre_alum;
	}
	public String getTipo_sancion() {
		return tipo_sancion;
	}
	public void setTipo_sancion(String tipo_sancion) {
		this.tipo_sancion = tipo_sancion;
	}
	public String getAsistencia() {
		return asistencia;
	}
	public void setAsistencia(String asistencia) {
		this.asistencia = asistencia;
	}	
}