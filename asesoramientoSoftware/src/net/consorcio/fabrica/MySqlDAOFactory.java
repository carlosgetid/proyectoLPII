package net.consorcio.fabrica;

import net.consorcio.dao.MySqlCertificadoDAO;
import net.consorcio.dao.MySqlCotizacionDAO;
import net.consorcio.dao.MySqlInformeDAO;
import net.consorcio.dao.MySqlInformeInstalacionDAO;
import net.consorcio.dao.MySqlRequerimientoDAO;
import net.consorcio.dao.MySqlSoftwareDAO;
import net.consorcio.dao.MySqlUsuarioDAO;
import net.consorcio.dao.MySqlProveedorDAO;
import net.consorcio.interfaces.CertificadoDAO;
import net.consorcio.interfaces.CotizacionDAO;
import net.consorcio.interfaces.InformeDAO;
import net.consorcio.interfaces.InformeInstalacionDAO;
import net.consorcio.interfaces.ProveedorDAO;
import net.consorcio.interfaces.RequerimientoDAO;
import net.consorcio.interfaces.SoftwareDAO;
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
	@Override
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return new MySqlProveedorDAO();
	}

	@Override
	public SoftwareDAO getSoftwareDAO() {
		// TODO Auto-generated method stub
		return new MySqlSoftwareDAO();
	}

	@Override
	public CotizacionDAO getCotizacionDAO() {
		// TODO Auto-generated method stub
		return new MySqlCotizacionDAO();
	}

	@Override
	public CertificadoDAO getCertificadoDAO() {
		// TODO Auto-generated method stub
		return new MySqlCertificadoDAO();
	}

}
