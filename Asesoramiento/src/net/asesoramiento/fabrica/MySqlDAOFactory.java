package net.asesoramiento.fabrica;

import net.asesoramiento.dao.MySqlRequerimientoDAO;
import net.asesoramiento.interfaces.RequerimientoDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public RequerimientoDAO getRequerimientoDAO() {
		// TODO Auto-generated method stub
		return new MySqlRequerimientoDAO();
	}

}
