package cl.mineduc.sismologia.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cl.mineduc.sismologia.models.entity.Metadata;

@Repository
public interface IMetadataDao extends CrudRepository<Metadata, Long>  {



}
