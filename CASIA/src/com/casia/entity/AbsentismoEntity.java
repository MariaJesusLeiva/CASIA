package com.casia.entity;

import java.util.Date;

public class AbsentismoEntity {
	private Integer id_absentismo;
	private Integer codigo_absen;
	private String grupo;
	private String curso;
	private String nombre_alum;
	private Date fecha_nacimiento;

	private String mes_faseuno;
	private String mes_fasedos;
	private String mes_fasetres;
	private String mes_fasecuatro;

	private String totalhoras_faseuno;
	private String totalhoras_fasedos;
	private String totalhoras_fasetres;
	private String totalhoras_fasecuatro;

	/*private Integer totalhoras_faseuno;
	private Integer totalhoras_fasedos;
	private Integer totalhoras_fasetres;
	private Integer totalhoras_fasecuatro;*/

	private String justificada_faseuno;
	private String justificada_fasedos;

	private String horacita_fasedos;
	private String horacita_fasetres;
	private String observacion_faseuno;
	private String observacion_fasedos;
	private String observacion_fasetres;
	private String observacion_fasecuatro;

	// private Integer totalhoras_fasedos;
	// private Date fechacarta_fasedos;
	// private Date fechacita_fasedos;

	private String acude_fasedos;
	private String acude_fasetres;
	private String justificadacita_fasedos;
	private String justificadacita_fasetres;
	private String compromiso_fasedos;
	private String compromiso_fasetres;
	private String justificada_fasetres;

	// private Integer totalhoras_fasetres;
	// private Date fechacarta_fasetres;
	// private Date fechacita_fasetres;
	// private Date fechacarta_fasecuatro;

	private String fase_actual;
	private String caso_resuelto;
	private String mayor_edad;

	private String fechacarta_faseuno;
	private String fechacarta_fasedos;
	private String fechacarta_fasetres;
	private String fechacarta_fasecuatro;
	private String fechacita_fasedos;
	private String fechacita_fasetres;
	
	public Integer getId_absentismo() {
		return id_absentismo;
	}
	public void setId_absentismo(Integer id_absentismo) {
		this.id_absentismo = id_absentismo;
	}
	public Integer getCodigo_absen() {
		return codigo_absen;
	}
	public void setCodigo_absen(Integer codigo_absen) {
		this.codigo_absen = codigo_absen;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getNombre_alum() {
		return nombre_alum;
	}
	public void setNombre_alum(String nombre_alum) {
		this.nombre_alum = nombre_alum;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getMes_faseuno() {
		return mes_faseuno;
	}
	public void setMes_faseuno(String mes_faseuno) {
		this.mes_faseuno = mes_faseuno;
	}
	public String getMes_fasedos() {
		return mes_fasedos;
	}
	public void setMes_fasedos(String mes_fasedos) {
		this.mes_fasedos = mes_fasedos;
	}
	public String getMes_fasetres() {
		return mes_fasetres;
	}
	public void setMes_fasetres(String mes_fasetres) {
		this.mes_fasetres = mes_fasetres;
	}
	public String getMes_fasecuatro() {
		return mes_fasecuatro;
	}
	public void setMes_fasecuatro(String mes_fasecuatro) {
		this.mes_fasecuatro = mes_fasecuatro;
	}
	public String getTotalhoras_faseuno() {
		return totalhoras_faseuno;
	}
	public void setTotalhoras_faseuno(String totalhoras_faseuno) {
		this.totalhoras_faseuno = totalhoras_faseuno;
	}
	public String getTotalhoras_fasedos() {
		return totalhoras_fasedos;
	}
	public void setTotalhoras_fasedos(String totalhoras_fasedos) {
		this.totalhoras_fasedos = totalhoras_fasedos;
	}
	public String getTotalhoras_fasetres() {
		return totalhoras_fasetres;
	}
	public void setTotalhoras_fasetres(String totalhoras_fasetres) {
		this.totalhoras_fasetres = totalhoras_fasetres;
	}
	public String getTotalhoras_fasecuatro() {
		return totalhoras_fasecuatro;
	}
	public void setTotalhoras_fasecuatro(String totalhoras_fasecuatro) {
		this.totalhoras_fasecuatro = totalhoras_fasecuatro;
	}
	public String getJustificada_faseuno() {
		return justificada_faseuno;
	}
	public void setJustificada_faseuno(String justificada_faseuno) {
		this.justificada_faseuno = justificada_faseuno;
	}
	public String getJustificada_fasedos() {
		return justificada_fasedos;
	}
	public void setJustificada_fasedos(String justificada_fasedos) {
		this.justificada_fasedos = justificada_fasedos;
	}
	public String getHoracita_fasedos() {
		return horacita_fasedos;
	}
	public void setHoracita_fasedos(String horacita_fasedos) {
		this.horacita_fasedos = horacita_fasedos;
	}
	public String getHoracita_fasetres() {
		return horacita_fasetres;
	}
	public void setHoracita_fasetres(String horacita_fasetres) {
		this.horacita_fasetres = horacita_fasetres;
	}
	public String getObservacion_faseuno() {
		return observacion_faseuno;
	}
	public void setObservacion_faseuno(String observacion_faseuno) {
		this.observacion_faseuno = observacion_faseuno;
	}
	public String getObservacion_fasedos() {
		return observacion_fasedos;
	}
	public void setObservacion_fasedos(String observacion_fasedos) {
		this.observacion_fasedos = observacion_fasedos;
	}
	public String getObservacion_fasetres() {
		return observacion_fasetres;
	}
	public void setObservacion_fasetres(String observacion_fasetres) {
		this.observacion_fasetres = observacion_fasetres;
	}
	public String getObservacion_fasecuatro() {
		return observacion_fasecuatro;
	}
	public void setObservacion_fasecuatro(String observacion_fasecuatro) {
		this.observacion_fasecuatro = observacion_fasecuatro;
	}
	public String getAcude_fasedos() {
		return acude_fasedos;
	}
	public void setAcude_fasedos(String acude_fasedos) {
		this.acude_fasedos = acude_fasedos;
	}
	public String getAcude_fasetres() {
		return acude_fasetres;
	}
	public void setAcude_fasetres(String acude_fasetres) {
		this.acude_fasetres = acude_fasetres;
	}
	public String getJustificadacita_fasedos() {
		return justificadacita_fasedos;
	}
	public void setJustificadacita_fasedos(String justificadacita_fasedos) {
		this.justificadacita_fasedos = justificadacita_fasedos;
	}
	public String getJustificadacita_fasetres() {
		return justificadacita_fasetres;
	}
	public void setJustificadacita_fasetres(String justificadacita_fasetres) {
		this.justificadacita_fasetres = justificadacita_fasetres;
	}
	public String getCompromiso_fasedos() {
		return compromiso_fasedos;
	}
	public void setCompromiso_fasedos(String compromiso_fasedos) {
		this.compromiso_fasedos = compromiso_fasedos;
	}
	public String getCompromiso_fasetres() {
		return compromiso_fasetres;
	}
	public void setCompromiso_fasetres(String compromiso_fasetres) {
		this.compromiso_fasetres = compromiso_fasetres;
	}
	public String getJustificada_fasetres() {
		return justificada_fasetres;
	}
	public void setJustificada_fasetres(String justificada_fasetres) {
		this.justificada_fasetres = justificada_fasetres;
	}
	public String getFase_actual() {
		return fase_actual;
	}
	public void setFase_actual(String fase_actual) {
		this.fase_actual = fase_actual;
	}
	public String getCaso_resuelto() {
		return caso_resuelto;
	}
	public void setCaso_resuelto(String caso_resuelto) {
		this.caso_resuelto = caso_resuelto;
	}
	public String getMayor_edad() {
		return mayor_edad;
	}
	public void setMayor_edad(String mayor_edad) {
		this.mayor_edad = mayor_edad;
	}
	public String getFechacarta_faseuno() {
		return fechacarta_faseuno;
	}
	public void setFechacarta_faseuno(String fechacarta_faseuno) {
		this.fechacarta_faseuno = fechacarta_faseuno;
	}
	public String getFechacarta_fasedos() {
		return fechacarta_fasedos;
	}
	public void setFechacarta_fasedos(String fechacarta_fasedos) {
		this.fechacarta_fasedos = fechacarta_fasedos;
	}
	public String getFechacarta_fasetres() {
		return fechacarta_fasetres;
	}
	public void setFechacarta_fasetres(String fechacarta_fasetres) {
		this.fechacarta_fasetres = fechacarta_fasetres;
	}
	public String getFechacarta_fasecuatro() {
		return fechacarta_fasecuatro;
	}
	public void setFechacarta_fasecuatro(String fechacarta_fasecuatro) {
		this.fechacarta_fasecuatro = fechacarta_fasecuatro;
	}
	public String getFechacita_fasedos() {
		return fechacita_fasedos;
	}
	public void setFechacita_fasedos(String fechacita_fasedos) {
		this.fechacita_fasedos = fechacita_fasedos;
	}
	public String getFechacita_fasetres() {
		return fechacita_fasetres;
	}
	public void setFechacita_fasetres(String fechacita_fasetres) {
		this.fechacita_fasetres = fechacita_fasetres;
	}
	/*public Integer getTotalhoras_faseuno() {
		return totalhoras_faseuno;
	}
	public void setTotalhoras_faseuno(Integer totalhoras_faseuno) {
		this.totalhoras_faseuno = totalhoras_faseuno;
	}
	public Integer getTotalhoras_fasedos() {
		return totalhoras_fasedos;
	}
	public void setTotalhoras_fasedos(Integer totalhoras_fasedos) {
		this.totalhoras_fasedos = totalhoras_fasedos;
	}
	public Integer getTotalhoras_fasetres() {
		return totalhoras_fasetres;
	}
	public void setTotalhoras_fasetres(Integer totalhoras_fasetres) {
		this.totalhoras_fasetres = totalhoras_fasetres;
	}
	public Integer getTotalhoras_fasecuatro() {
		return totalhoras_fasecuatro;
	}
	public void setTotalhoras_fasecuatro(Integer totalhoras_fasecuatro) {
		this.totalhoras_fasecuatro = totalhoras_fasecuatro;
	}*/

	
}