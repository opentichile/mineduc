package cl.mineduc.sismologia.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

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


	@Range(min = (long) 0.0, max = (long) 10.0, message="La magnitud mínima 0 hasta 10")
	public double minmagnitude;
	

	@Range(min = (long) 0.0, max = (long) 10.0, message="La magnitud mínima 0 hasta 10")
	public double maxmagnitude;

	public Rango() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
