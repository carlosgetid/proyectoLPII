package net.consorcio.entidad;

import java.io.InputStream;
import java.sql.Date;

public class InformeInstalacion {
	
	private int codigo;
	private String lugar;
	private String nombreArea;
	private Date fechaInstalacion;
	private Date horaInstalacion;
	private int calificacion;
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
	public Date getHoraInstalacion() {
		return horaInstalacion;
	}
	public void setHoraInstalacion(Date horaInstalacion) {
		this.horaInstalacion = horaInstalacion;
	}
	public InputStream getDocumento() {
		return documento;
	}
	public void setDocumento(InputStream documento) {
		this.documento = documento;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
}