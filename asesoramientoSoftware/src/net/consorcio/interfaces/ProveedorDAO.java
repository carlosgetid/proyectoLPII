package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Proveedor;

public interface ProveedorDAO {

	
	public Proveedor fin(long cod);
	public List<Proveedor> listAll();
	public int save(Proveedor bean);
	public int update(Proveedor bean);
	public int delete(long cod);
	public List<Proveedor> listProveedorXApellidos(String ape);
}
