package cl.mineduc.sismologia.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cl.mineduc.sismologia.models.entity.Periodo;
import cl.mineduc.sismologia.models.entity.Rango;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 
 * Singleton Tools
 * 
 * Este tomara datos del destinatario
 * 
 * @author Alejandro Sandoval S.
 * @version 15-08-2020
 * 
 */
@Component
public class Tools {

	private static Tools instance = null;

	/**
	 * Constructor sin acceso
	 */
	private Tools() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the instance
	 */
	public static Tools getInstance() {
		if (instance == null)
			instance = new Tools();
		return instance;
	}

	public Response responseOkHttp(final String url) {
		Response response = null;
		OkHttpClient client = new OkHttpClient();

		try {
			Request request = new Request.Builder().url(url).method("GET", null).build();
			response = client.newCall(request).execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * 
	 * Validator Periodo
	 * @param periodo
	 * @return
	 */
	public Map<String, Object> isValid(Periodo periodo)
	{
		Map<String, Object> mapret = null;
		List<String> errors = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d_starttime = sdf.parse(periodo.starttime);
			Date d_endtime = sdf.parse(periodo.endtime);
			
			if(d_starttime.after(d_endtime)) {
				mapret = new HashMap<>();
				errors.add("La fecha inicial no puede ser mayor a la fecha final");
				mapret.put("errors", errors);
				
			}
			
		}catch (ParseException e) {
			mapret = new HashMap<>();
			errors.add("La fecha inicial debe de ser de largo 10 con formato yyyy-mm-dd");
			errors.add("La fecha final debe de ser de largo 10 con formato yyyy-mm-dd");
			mapret.put("errors", errors);
		}catch (Exception e) {
			mapret = new HashMap<>();
			errors.add("Problema general atribuido al periodo");
			mapret.put("errors", errors);
		}	
	 	
		return mapret;
	}

	/**
	 * Validator Rango
	 * @param rango
	 * @return
	 */
	public Map<String, Object> isValid(Rango rango)
	{
		 Map<String, Object> mapret = null;
		 List<String> errors = new ArrayList<>();
		
		try {
			
			if(rango.maxmagnitude < rango.minmagnitude) {
				
				mapret = new HashMap<>();
				errors.add("La magnitud mínima no puede ser mayor a la magnitude máxima");
				mapret.put("errors", errors);
			}
			
		}catch (Exception e) {
			mapret = new HashMap<>();
			errors.add("La magnitud mínima debe de ser de largo 2 con formato #.#");
			errors.add("La magnitud máxima debe de ser de largo 2 con formato #.#");
			mapret.put("errors", errors);
		}	
	 	
		return mapret;
	}
	
}