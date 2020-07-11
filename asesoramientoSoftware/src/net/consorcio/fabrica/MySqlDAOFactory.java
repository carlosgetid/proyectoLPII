package net.consorcio.fabrica;

import net.consorcio.dao.MySqlInformeDAO;
import net.consorcio.dao.MySqlRequerimientoDAO;
import net.consorcio.dao.MySqlUsuarioDAO;
import net.consorcio.interfaces.InformeDAO;
import net.consorcio.interfaces.RequerimientoDAO;
import net.consorcio.interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public RequerimientoDAO getRequerimientoDAO() {
		// TODO Auto-generated method stub
		return new MySqlRequerimientoDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public InformeDAO getInformeDAO() {
		// TODO Auto-generated method stub
		return new MySqlInformeDAO();
	}

}
