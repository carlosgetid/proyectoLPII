package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Menu;
import net.consorcio.entidad.Usuario;

public interface UsuarioDAO {
	
	public Usuario iniciarSesion(String login, String clave);
	public List<Menu> traerMenuPorUsuario(int codUsu);
	

}
