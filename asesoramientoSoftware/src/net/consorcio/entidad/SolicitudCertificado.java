package net.consorcio.entidad;

import java.io.InputStream;

public class SolicitudCertificado {
	private int codigo;
	private String objetivo;
	private double monto;
	private String area;
	private InputStream documento;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public InputStream getDocumento() {
		return documento;
	}
	public void setDocumento(InputStream documento) {
		this.documento = documento;
	}
	
	
}
