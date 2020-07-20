package net.consorcio.entidad;

import java.io.InputStream;
import java.util.Date;

public class Cotizacion {
	private int codigo;
	private int rucPro;
	private int codUsu;
	private Date fecha;
	private double monto;
	private InputStream documento;
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getRucPro() {
		return rucPro;
	}
	public void setRucPro(int rucPro) {
		this.rucPro = rucPro;
	}
	public int getCodUsu() {
		return codUsu;
	}
	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public InputStream getDocumento() {
		return documento;
	}
	public void setDocumento(InputStream documento) {
		this.documento = documento;
	}
	
		
	
	
	
}
