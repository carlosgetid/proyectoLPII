package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.Informe;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.InformeDAO;

public class InformeService {

	DAOFactory dao=DAOFactory.getDAOFactory(1);
	InformeDAO daoInforme=dao.getInformeDAO();
	
	
	public Informe buscar(int cod) {
		return daoInforme.find(cod);
	}
	public List<Informe> listar(){
		return daoInforme.listAll();
	}
	public int registrar(Informe bean) {
		return daoInforme.save(bean);
	}
	public int actualizar(Informe bean) {
		return daoInforme.update(bean);
	}
	public int eliminar(int cod) {
		return daoInforme.delete(cod);
	}
}
