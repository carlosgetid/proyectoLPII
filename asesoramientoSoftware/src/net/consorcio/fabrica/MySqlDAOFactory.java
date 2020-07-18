package net.consorcio.fabrica;

import net.consorcio.dao.MySqlInformeDAO;
<<<<<<< HEAD
import net.consorcio.dao.MySqlProveedorDAO;
import net.consorcio.dao.MySqlRequerimientoDAO;
import net.consorcio.dao.MySqlUsuarioDAO;
import net.consorcio.interfaces.InformeDAO;
=======
import net.consorcio.dao.MySqlInformeInstalacionDAO;
import net.consorcio.dao.MySqlRequerimientoDAO;
import net.consorcio.dao.MySqlUsuarioDAO;
import net.consorcio.dao.MySqlProveedorDAO;
import net.consorcio.interfaces.InformeDAO;
import net.consorcio.interfaces.InformeInstalacionDAO;
>>>>>>> 0e7b5ac78a7a07be9c22679d060ca3be0601144d
import net.consorcio.interfaces.ProveedorDAO;
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

	@Override
<<<<<<< HEAD
=======
	public InformeInstalacionDAO getInformeInstalacionDAO() {
		// TODO Auto-generated method stub
		return new MySqlInformeInstalacionDAO();
	}
	@Override
>>>>>>> 0e7b5ac78a7a07be9c22679d060ca3be0601144d
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return new MySqlProveedorDAO();
	}

}
