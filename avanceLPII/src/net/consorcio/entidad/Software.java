package net.consorcio.entidad;

import java.io.InputStream;

public class Software {
	private int codigo;
	private String nombre;
	private String version;
	private InputStream documento;
	
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public InputStream getDocumento() {
		return documento;
	}
	public void setDocumento(InputStream documento) {
		this.documento = documento;
	}
	
}
