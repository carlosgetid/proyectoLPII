package net.consorcio.entidad;

import java.io.InputStream;
import java.sql.Date;
<<<<<<< HEAD
=======
import java.sql.Time;
>>>>>>> 0e7b5ac78a7a07be9c22679d060ca3be0601144d

public class InformeInstalacion {
	
	private int codigo;
	private String lugar;
	private String nombreArea;
	
//	datos ingresados por el usuario
	private Date fechaInstalacion;
<<<<<<< HEAD
	private Date horaInstalacion;
	
	private int calificacion;
	private InputStream documento;
	
=======
	private Time horaInstalacion;
	
	private int estado;
	private InputStream documento;
>>>>>>> 0e7b5ac78a7a07be9c22679d060ca3be0601144d
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
<<<<<<< HEAD
	public Date getHoraInstalacion() {
		return horaInstalacion;
	}
	public void setHoraInstalacion(Date horaInstalacion) {
		this.horaInstalacion = horaInstalacion;
	}
=======
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
>>>>>>> 0e7b5ac78a7a07be9c22679d060ca3be0601144d
	public InputStream getDocumento() {
		return documento;
	}
	public void setDocumento(InputStream documento) {
		this.documento = documento;
	}
<<<<<<< HEAD
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
=======
>>>>>>> 0e7b5ac78a7a07be9c22679d060ca3be0601144d
	
}