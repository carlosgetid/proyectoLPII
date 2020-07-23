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
	
	private int codigoEstado;
	private String nombreEstado;
	private int codigoUsuario;
	private int codigoSoftware;
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
	public int getCodigoEstado() {
		return codigoEstado;
	}
	public void setCodigoEstado(int codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public int getCodigoSoftware() {
		return codigoSoftware;
	}
	public void setCodigoSoftware(int codigoSoftware) {
		this.codigoSoftware = codigoSoftware;
	}
	
	
}
	
	