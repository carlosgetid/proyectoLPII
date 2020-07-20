package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.Certificado;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.CertificadoDAO;
import net.consorcio.interfaces.ProveedorDAO;

public class CertificadoService {
	DAOFactory dao=DAOFactory.getDAOFactory(1);
	CertificadoDAO daoCertificado=dao.getCertificadoDAO();
	
	public Certificado find(int cod) {
		return daoCertificado.find(cod);
	}
	public List<Certificado> listAll(){
		return daoCertificado.listAll();
	}
	public int save(Certificado bean) {
		return daoCertificado.save(bean);
	}
	public int update(Certificado bean) {
		return daoCertificado.update(bean);
	}
	public int delete(int cod) {
		return daoCertificado.delete(cod);
	}
}
