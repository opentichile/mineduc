package cl.mineduc.sismologia.api.rest.impl;

import java.io.IOException;

/**
 * 
 * Definición de Servicios a Implementar
 * 
 * @author Alejandro Sandoval S.
 *
 */
public interface ServiceControllerImpl {

	
	
	/**
	 * 
	 * Servicio earthquakes Filtro Rango Fechas 
	 * 
	 * @param starttime
	 * @param endtime
	 * @return
	 * @throws IOException
	 */
	String earthquakes(String starttime, String endtime) throws IOException;

	/**
	 * 
	 * Servicio earthquakes Filtro Rango Magnitudes
	 * 
	 * @param minMagnitude
	 * @param maxMagnitude
	 * @return
	 * @throws IOException
	 */
	String earthquakes(Double minMagnitude, Double maxMagnitude) throws IOException;

	

}
