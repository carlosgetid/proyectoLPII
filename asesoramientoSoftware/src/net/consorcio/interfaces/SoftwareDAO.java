package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Software;


public interface SoftwareDAO {
	public Software find(int cod);
	public List<Software> listSoftwareXNombre(String nom);
	public int save(Software bean);
	public int update(Software bean);
	public int delete(int cod);
	
}
