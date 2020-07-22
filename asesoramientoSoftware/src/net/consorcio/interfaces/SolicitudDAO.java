package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Requerimiento;
import net.consorcio.entidad.SolicitudCertificado;
import net.consorcio.fabrica.DAOFactory;

public interface SolicitudDAO {


	
	
	public Requerimiento find(int cod);
	public List<SolicitudCertificado> listAll();
	public int save(SolicitudCertificado bean);
	public int update(SolicitudCertificado bean);
	public int delete(int cod);
	
	
}
