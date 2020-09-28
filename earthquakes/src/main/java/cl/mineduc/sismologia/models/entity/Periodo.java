package cl.mineduc.sismologia.models.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import cl.mineduc.sismologia.validator.CheckDateFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Parámetro de Entrada : Periodos de Fechas  
 * 
 * @author Alejandro Sandoval S.
 *
 */

@Setter
@Getter
public class Periodo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5989884373180214949L;
	
	 @Value("${periodo.date.rango}")
	 private String msg_error_validacion;
	
	
	@CheckDateFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message ="{periodo.starttime.size}")
	@NotNull
	String starttime;
	
	@CheckDateFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message ="{periodo.endtime.size}")
	@NotNull
	String endtime;

	public Periodo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String isValid()
	{
		String validation = null;
	 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d_starttime = sdf.parse(this.starttime);
			Date d_endtime = sdf.parse(this.endtime);
			
			if(d_starttime.after(d_endtime)) {
				
				validation = msg_error_validacion;
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			validation = "Una o las Dos Fechas son inválidas";
		}	
	 	
		return validation;
	}
	
}



