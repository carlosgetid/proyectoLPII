package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.Requerimiento;
import net.consorcio.entidad.SolicitudCertificado;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.SolicitudDAO;

public class SolicitudService {
	
	DAOFactory dao=DAOFactory.getDAOFactory(1);
	SolicitudDAO daoSolicitud=dao.getSolicitudDAO();
	
	public Requerimiento buscar(int cod) {
		return daoSolicitud.find(cod);
		
	}
	public List<SolicitudCertificado> listar(){
		return daoSolicitud.listAll();
		
	}
	public int registrar(SolicitudCertificado bean) {
		
		return daoSolicitud.save(bean);
	}
	public int actualizar(SolicitudCertificado bean) {
		return daoSolicitud.update(bean);
	}
	public int eliminar(int cod) {
		return daoSolicitud.delete(cod);
		
	}
	

}
