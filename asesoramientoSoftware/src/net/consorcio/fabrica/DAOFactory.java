package net.consorcio.fabrica;

import net.consorcio.interfaces.InformeDAO;
<<<<<<< HEAD
=======
import net.consorcio.interfaces.InformeInstalacionDAO;
>>>>>>> 0e7b5ac78a7a07be9c22679d060ca3be0601144d
import net.consorcio.interfaces.ProveedorDAO;
import net.consorcio.interfaces.RequerimientoDAO;
import net.consorcio.interfaces.UsuarioDAO;

public abstract class DAOFactory {
<<<<<<< HEAD
	// los posibles orígenes de datos
=======
	// los posibles orï¿½genes de datos
>>>>>>> 0e7b5ac78a7a07be9c22679d060ca3be0601144d
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
<<<<<<< HEAD
    // Existirá un método get por cada DAO que exista en el sistema
=======
    // Existirï¿½ un mï¿½todo get por cada DAO que exista en el sistema
>>>>>>> 0e7b5ac78a7a07be9c22679d060ca3be0601144d
    // Ejemplo:
    //public abstract ArticuloDAO getArticuloDAO();
    // registramos nuestros daos
    public abstract RequerimientoDAO getRequerimientoDAO();
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract InformeDAO getInformeDAO();
<<<<<<< HEAD
    public abstract ProveedorDAO getProveedorDAO();
   
   
=======
    public abstract InformeInstalacionDAO getInformeInstalacionDAO();
    public abstract ProveedorDAO getProveedorDAO();

>>>>>>> 0e7b5ac78a7a07be9c22679d060ca3be0601144d
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
