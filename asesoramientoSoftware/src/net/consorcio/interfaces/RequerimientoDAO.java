package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Requerimiento;

public interface RequerimientoDAO {
	public Requerimiento fin(int cod);
	public List<Requerimiento> listAll();
	public int save(Requerimiento bean);
	public int update(Requerimiento bean);
	public int delete(int cod);
	
	
}
