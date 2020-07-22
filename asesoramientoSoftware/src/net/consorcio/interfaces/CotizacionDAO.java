package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Cotizacion;
import net.consorcio.entidad.Detalle;
import net.consorcio.entidad.InformeTecnico;

public interface CotizacionDAO {
	
	public int registrarCotizacion(Cotizacion bean, List<Detalle> lista);
	
	public List<Cotizacion> listAll();

}
