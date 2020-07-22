package net.consorcio.entidad;

import java.sql.Timestamp;

public class Software {
	private int codigo;
	private String nombre;
	private double precio;
	private Timestamp fecha;
	private int codigoCertificado;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public int getCodigoCertificado() {
		return codigoCertificado;
	}
	public void setCodigoCertificado(int codigoCertificado) {
		this.codigoCertificado = codigoCertificado;
	}
	
	
		
}
