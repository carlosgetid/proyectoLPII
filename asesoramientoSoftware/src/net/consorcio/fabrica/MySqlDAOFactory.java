package net.consorcio.fabrica;

import net.consorcio.dao.MySqlInformeDAO;
<<<<<<< HEAD
import net.consorcio.dao.MySqlInformeInstalacionDAO;
import net.consorcio.dao.MySqlRequerimientoDAO;
import net.consorcio.dao.MySqlUsuarioDAO;
import net.consorcio.interfaces.InformeDAO;
import net.consorcio.interfaces.InformeInstalacionDAO;
=======
import net.consorcio.dao.MySqlProveedorDAO;
import net.consorcio.dao.MySqlRequerimientoDAO;
import net.consorcio.dao.MySqlUsuarioDAO;
import net.consorcio.interfaces.InformeDAO;
import net.consorcio.interfaces.ProveedorDAO;
>>>>>>> ad4965f2b1921aae46bc05c03e09b9babe50adb6
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
	public InformeInstalacionDAO getInformeInstalacionDAO() {
		// TODO Auto-generated method stub
		return new MySqlInformeInstalacionDAO();
	}
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return new MySqlProveedorDAO();
	}

}
