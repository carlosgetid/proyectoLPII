package net.consorcio.entidad;

import java.io.InputStream;

public class Requerimiento {

	private int codigo;
	private String descripcion;
	private String origen;
	private String area;
	private String criticidad;
	private String estado;
	private InputStream documento;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCriticidad() {
		return criticidad;
	}
	public void setCriticidad(String criticidad) {
		this.criticidad = criticidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public InputStream getDocumento() {
		return documento;
	}
	public void setDocumento(InputStream documento) {
		this.documento = documento;
	}

}
