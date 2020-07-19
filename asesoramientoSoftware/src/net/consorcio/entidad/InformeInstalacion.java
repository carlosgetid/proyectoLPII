package net.consorcio.entidad;

import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;

public class InformeInstalacion {
	
	private int codigo;
	private String lugar;
	private String nombreArea;
	
//	datos ingresados por el usuario
	private Date fechaInstalacion;
	private Time horaInstalacion;
	
	private int estado;
	private InputStream documento;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getNombreArea() {
		return nombreArea;
	}
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}
	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}
	public Time getHoraInstalacion() {
		return horaInstalacion;
	}
	public void setHoraInstalacion(Time horaInstalacion) {
		this.horaInstalacion = horaInstalacion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public InputStream getDocumento() {
		return documento;
	}
	public void setDocumento(InputStream documento) {
		this.documento = documento;
	}
	
}
	
	