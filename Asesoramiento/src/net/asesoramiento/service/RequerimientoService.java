package net.asesoramiento.service;

import java.util.List;

import net.asesoramiento.entidad.Requerimiento;
import net.asesoramiento.fabrica.DAOFactory;
import net.asesoramiento.interfaces.RequerimientoDAO;

public class RequerimientoService {
	//Paso 1:Definir gestor de base de datos e informar a la clase DAOFactory
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	//Paso 2: definir con que DAO se va a trabajar
	RequerimientoDAO daoRequerimiento=fabrica.getRequerimientoDAO();
	
	
	//metedos de servicio
	
	public int registrarRequerimiento(Requerimiento bean) {
	
		return daoRequerimiento.insertRequerimiento(bean);
	}
	
	public List<Requerimiento> listarRequerimientos() {
		return daoRequerimiento.listRequerimiento();
	}
	
}
