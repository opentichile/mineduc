package cl.mineduc.sismologia.models.entity;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * Rango de Magnitudes
 * 
 * @author Alejandro Sandoval S.
 *
 */

@Setter
@Getter
public class Rango implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7179732598731034411L;


	 @Value("${rango.magnitude.rango}")
	 private String msg_error_validacion;

	@NotEmpty(message ="{valor.vacio}")
	@Size(min=3, max=5, message="{rango.minmagnitude.size}")
	double minmagnitude;
	
	@NotEmpty(message ="{valor.vacio}")
	@Size(min=3, max=5, message="{rango.maxmagnitude.size}")
	double maxmagnitude;

	public Rango() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String isValid()
	{
		String validation = null;
	 	
		try {
			
			if(maxmagnitude < minmagnitude) {
				
				validation = msg_error_validacion;
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			validation = "Una o las Dos Magnitudes es inválida";
		}	
	 	
		return validation;
	}
	
	
}
