package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.Menu;
import net.consorcio.entidad.Usuario;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.UsuarioDAO;

public class UsuarioService {
	
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	UsuarioDAO daoUsuario=fabrica.getUsuarioDAO();
	
	public Usuario iniciarSesion(String login, String clave) {
		return daoUsuario.iniciarSesion(login, clave);
	}
	
	public List<Menu> traerMenuPorUsuario(int codUsu){
		return daoUsuario.traerMenuPorUsuario(codUsu);
	}

}
