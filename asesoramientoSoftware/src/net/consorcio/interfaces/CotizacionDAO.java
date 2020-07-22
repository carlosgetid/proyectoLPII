package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Cotizacion;
import net.consorcio.entidad.Detalle;

public interface CotizacionDAO {
	public Cotizacion find(int cod); 
	public int registrarCotizacion(Cotizacion bean, List<Detalle> lista);
	public int update(Cotizacion bean);
	public List<Cotizacion> listAll();
	public int delete(int cod);
}
