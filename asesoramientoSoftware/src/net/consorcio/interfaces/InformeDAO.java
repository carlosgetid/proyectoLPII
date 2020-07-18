package net.consorcio.interfaces;

import java.util.List;
import net.consorcio.entidad.Informe;

public interface InformeDAO {
	public Informe find(int cod);
	public List<Informe> listAll();
	public int save(Informe bean);
	public int update(Informe bean);
	public int delete(int cod);
}
