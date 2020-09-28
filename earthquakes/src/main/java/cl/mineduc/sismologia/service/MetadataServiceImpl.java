package cl.mineduc.sismologia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.mineduc.sismologia.models.dao.IMetadataDao;
import cl.mineduc.sismologia.models.entity.Metadata;
import cl.mineduc.sismologia.service.impl.IMetadataService;


@Service
public class MetadataServiceImpl implements IMetadataService {

	
	
	@Autowired
	private IMetadataDao metadataDao;

	@Override
	@Transactional(readOnly = true)
	public List<Metadata> findAll() {
		return (List<Metadata>) metadataDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Metadata findById(Long id) {
		return metadataDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Metadata save(Metadata metadata) {
		return metadataDao.save(metadata);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		metadataDao.deleteById(id);
	}


}
