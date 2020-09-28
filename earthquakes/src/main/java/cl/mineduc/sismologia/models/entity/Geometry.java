package cl.mineduc.sismologia.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 
 * Entidad Geometría Integrable  
 * 
 * @author Alejandro Sandoval S.
 *
 */
@Data
@AllArgsConstructor
@Embeddable
public class Geometry implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 2297737595699594859L;

		@Column(name="type")
		private String type;
		
	    private Double[] coordinates;

		public Geometry() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
}
