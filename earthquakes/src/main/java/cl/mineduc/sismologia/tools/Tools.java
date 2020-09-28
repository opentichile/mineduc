package cl.mineduc.sismologia.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	
	public boolean isValid(Periodo periodo)
	{
		boolean validation = true;
	 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d_starttime = sdf.parse(periodo.starttime);
			Date d_endtime = sdf.parse(periodo.endtime);
			
			if(d_starttime.after(d_endtime)) {
				
				validation = false;
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			validation = false;
		}	
	 	
		return validation;
	}

	
	public boolean isValid(Rango rango)
	{
		boolean validation = true;
	 	
		try {
			
			if(Double.parseDouble(rango.maxmagnitude) < Double.parseDouble(rango.minmagnitude)) {
				
				validation = false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			validation = false;
		}	
	 	
		return validation;
	}
	
}