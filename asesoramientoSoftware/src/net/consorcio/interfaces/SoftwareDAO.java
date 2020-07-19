package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Proveedor;
import net.consorcio.entidad.Software;


public interface SoftwareDAO {
	public List<Software> listSoftwareXNombre(String nom);
	
	
}
