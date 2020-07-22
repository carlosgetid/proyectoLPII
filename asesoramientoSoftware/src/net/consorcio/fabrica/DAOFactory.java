package net.consorcio.fabrica;

import net.consorcio.interfaces.CertificadoDAO;
import net.consorcio.interfaces.CotizacionDAO;
import net.consorcio.interfaces.InformeDAO;
import net.consorcio.interfaces.InformeInstalacionDAO;
import net.consorcio.interfaces.ProveedorDAO;
import net.consorcio.interfaces.RequerimientoDAO;
import net.consorcio.interfaces.SoftwareDAO;
import net.consorcio.interfaces.SolicitudDAO;
import net.consorcio.interfaces.UsuarioDAO;

public abstract class DAOFactory {
	// los posibles or�genes de datos
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    // Existir� un m�todo get por cada DAO que exista en el sistema
    // Ejemplo:
    //public abstract ArticuloDAO getArticuloDAO();
    // registramos nuestros daos
    public abstract RequerimientoDAO getRequerimientoDAO();
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract InformeDAO getInformeDAO();

    public abstract InformeInstalacionDAO getInformeInstalacionDAO();
    public abstract ProveedorDAO getProveedorDAO();
    public abstract SoftwareDAO getSoftwareDAO();
    public abstract CotizacionDAO getCotizacionDAO();
    public abstract CertificadoDAO getCertificadoDAO();
    public abstract SolicitudDAO getSolicitudDAO();
    

    public static DAOFactory getDAOFactory(int whichFactory){
        switch(whichFactory){
       	case MYSQL:
        	   return new MySqlDAOFactory();
        	case XML:
        	    //return new XmlDAOFactory();
        	case ORACLE:
        	    //return new OracleDAOFactory();
        	/*case DB2:
        	    return new Db2DAOFactory();*/
        	case SQLSERVER:
        	    return null;
        	/*case XML:
        	    return new XmlDAOFactory();*/
        	default:
        	    return null;
        }
     }
}
