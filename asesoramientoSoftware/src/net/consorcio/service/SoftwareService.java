package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.Software;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.SoftwareDAO;

public class SoftwareService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	SoftwareDAO daoSoftware = fabrica.getSoftwareDAO();
	
	public Software buscar(int cod) {
		return daoSoftware.find(cod);
	}
	public List<Software> listar(String nom){
		return daoSoftware.listSoftwareXNombre(nom);
	}
	public int registrar(Software bean) {
		return daoSoftware.save(bean);
	}
	public int actualizar(Software bean) {
		return daoSoftware.update(bean);
	}
	public int eliminar(int cod) {
		return daoSoftware.delete(cod);
	}
}
