package net.consorcio.interfaces;

import java.util.List;
import net.consorcio.entidad.InformeTecnico;

public interface InformeDAO {
	public InformeTecnico find(int cod);
	public List<InformeTecnico> listAll();
	public int save(InformeTecnico bean);
	public int update(InformeTecnico bean);
	public int delete(int cod);
}
