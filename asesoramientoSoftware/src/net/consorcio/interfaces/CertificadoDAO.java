package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Certificado;

public interface CertificadoDAO {
	public Certificado find(int cod);
	public List<Certificado> listAll();
	public int save(Certificado bean);
	public int update(Certificado bean);
	public int delete(int cod);
}
