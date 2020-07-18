package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.InformeInstalacion;

public interface InformeInstalacionDAO {
	public InformeInstalacion find(int cod);
	public List<InformeInstalacion> listAll();
	public int save(InformeInstalacion bean);
	public int update(InformeInstalacion bean);
	public int delete(int cod);
}
