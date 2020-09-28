package cl.mineduc.sismologia.models.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Entidad Metadata Integrable 
 * 
 * @author Alejandro Sandoval S.
 *
 */
@Entity
@Table(name="metadata")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Metadata implements Serializable{
		
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 2077443014763486766L;

		@Id
		@Column(name = "ID")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	
		@Column(nullable=false)
		private long generated;
		
		@Column(nullable=false)
		private String url;
		
		@Column(nullable=false)
		private String title;
		
		@Column(nullable=false)
		private int status;
		
		@Column(nullable=false)
		private String api;
		
		@Column(nullable=false)
		private int count;
		
//		public Metadata() {
//			super();
//		// TODO Auto-generated constructor stub
//		}
			
}
