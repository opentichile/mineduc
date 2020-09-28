package cl.mineduc.sismologia.models.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


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
	    
//	    @JoinColumn(name = "fk_sismo", nullable = false)
//	    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	    private Sismo sismo;
	    
   	    
}
