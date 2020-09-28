package cl.mineduc.sismologia.models.entity;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
	
	
	@CheckDateFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message ="La fecha inicial debe de ser de largo 10 con formato yyyy-mm-dd")
	@NotNull(message ="La fecha inicial debe de ser de largo 10 con formato yyyy-mm-dd")
	public String starttime;
	
	@CheckDateFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message ="La fecha inicial debe de ser de largo 10 con formato yyyy-mm-dd")
	@NotNull(message ="La fecha inicial debe de ser de largo 10 con formato yyyy-mm-dd")
	public String endtime;

	public Periodo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}



