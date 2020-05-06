package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.AdministratorEntity;
import co.com.jardin.repository.IAdministratorRepository;
import co.com.jardin.servie.IAdministratorService;

@Service
public class AdministratorServiceImpl implements IAdministratorService {

	private IAdministratorRepository administratoRepository;
	
	@Autowired
	public AdministratorServiceImpl(IAdministratorRepository administratoRepository) {
		this.administratoRepository = administratoRepository;
	}

	@Override
	public List<AdministratorEntity> findAll() {
		return administratoRepository.findAll();
	}

	@Override
	public AdministratorEntity findById(Long id) {
		return administratoRepository.findById(id).orElse(null);
	}

	@Override
	public AdministratorEntity save(AdministratorEntity administratorEntity) {
		return administratoRepository.save(administratorEntity);
	}

	@Override
	public void deleteById(Long id) {
		administratoRepository.deleteById(id);
	}


}
