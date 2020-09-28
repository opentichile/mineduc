package cl.mineduc.sismologia.models.entity;


import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 * Entidad Sismo  
 * 
 * @author Alejandro Sandoval S.
 *
 */
@Embeddable
public class Features implements Serializable {

	   /**
		 * 
		 */
		private static final long serialVersionUID = 1469316998935263774L;
	  
		@JsonProperty("type")
	    private String type;
		
		@Embedded
	    private Properties properties;	    
	    
		@Embedded
	    private Geometry geometry;
		
	    
	    public Features() {
			super();
			// TODO Auto-generated constructor stub
		} 

   	    
}
