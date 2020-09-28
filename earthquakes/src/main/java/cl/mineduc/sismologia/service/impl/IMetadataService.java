package cl.mineduc.sismologia.service.impl;

import java.util.List;
import cl.mineduc.sismologia.models.entity.Metadata; 

public interface IMetadataService {

	public List<Metadata> findAll();
	
	public Metadata findById(Long id);
	
	public Metadata save(Metadata metadata);
	
	public void delete(Long id);

}
