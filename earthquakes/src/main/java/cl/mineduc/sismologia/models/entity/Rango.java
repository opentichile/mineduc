package cl.mineduc.sismologia.models.entity;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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


	@NotEmpty(message ="La magnitud mínima debe de ser de largo 1 con formato #.#")
	@Size(min=1, max=3, message="La magnitud mínima debe de ser de largo 2 con formato #.#")
	public String minmagnitude;
	
	@NotEmpty(message ="La magnitud mínima debe de ser de largo 1 con formato #.#")
	@Size(min=1, max=3, message="La magnitud mínima debe de ser de largo 2 con formato #.#")
	public String maxmagnitude;

	public Rango() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
