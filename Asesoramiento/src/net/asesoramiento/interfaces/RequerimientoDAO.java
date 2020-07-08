package net.asesoramiento.interfaces;

import java.util.List;

import net.asesoramiento.entidad.Requerimiento;

public interface RequerimientoDAO {

	public int insertRequerimiento(Requerimiento bean);
	public int updateRequerimiento(Requerimiento bean);
	public int deleteRequerimiento(int cod);
	public Requerimiento findRequerimiento(int cod);
	public List<Requerimiento> listRequerimiento();
	public List<Requerimiento> listRequerimiento(String ori);
	
}
