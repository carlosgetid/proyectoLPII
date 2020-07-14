package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Proveedor;

public interface ProveedorDAO {

	
	public Proveedor fin(int cod);
	public List<Proveedor> listAll();
	public int save(Proveedor bean);
	public int update(Proveedor bean);
	public int delete(int cod);
	
}
