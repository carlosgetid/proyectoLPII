package net.consorcio.entidad;

import java.sql.Date;

public class InformeInstalacion {
	
	public int codigo;
	public String nombreTecnico;
	public String apellidoTecnico;
	public String dni;
	public String telefono;
	public String lugar;
	public String nombreArea;
	public Date fechaInstalacion;
	public Date horaInstalacion;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombreTecnico() {
		return nombreTecnico;
	}
	public void setNombreTecnico(String nombreTecnico) {
		this.nombreTecnico = nombreTecnico;
	}
	public String getApellidoTecnico() {
		return apellidoTecnico;
	}
	public void setApellidoTecnico(String apellidoTecnico) {
		this.apellidoTecnico = apellidoTecnico;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	
}