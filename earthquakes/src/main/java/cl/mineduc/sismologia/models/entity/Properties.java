package cl.mineduc.sismologia.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * Entidad Properties  
 * 
 * @author Alejandro Sandoval S.
 *
 */
@Embeddable
public class Properties implements Serializable {
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 536187115548228664L;

		@JsonProperty("mag")
		private Double mag;
		
		@JsonProperty("place")
	    private String place;
		
		@Column(name="time")
		private Long time;
		
		@Column(name="updated")
		private Long updated;
	    
		@Column(name="tz")
		private int tz;
	    
		@Column(name="url")
		private String url;
	    
		@Column(name="detail")
		private String detail;
	    
		@Column(name="felt")
		private int felt;
	    
		@Column(name="cdi")
		private Double cdi;
	    
		@Column(name="mmi")
		private int mmi;
	
		@Column(name="alert")
		private String alert;
	    
		@Column(name="status")
		private String status;
	    
		@Column(name="tsunami")
		private int tsunami;
	    
		@Column(name="sig")
		private int sig;
	    
		@Column(name="net")
		private String net;
	    
		@Column(name="code")
		private String code;
	    
		@Column(name="ids")
		private String ids;
	    
		@Column(name="sources")
		private String sources;
	    
		@Column(name="types")
		private String types;
	    
		@Column(name="nst")
		private int nst;
	    
		@Column(name="dmin")
		private Double dmin;
	    
		@Column(name="rms")
		private Double rms;
	    
		@Column(name="gap")
		private int gap;
	    
		@Column(name="magType")
		private String magType;
	    
		@Column(name="type")
		private String type;
	    
		@Column(name="title")
		private String title;

		public Properties() {
			super();
			// TODO Auto-generated constructor stub
		} 

		
}
