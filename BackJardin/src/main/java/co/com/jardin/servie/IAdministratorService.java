package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.AdministratorEntity;

public interface IAdministratorService {

	public List<AdministratorEntity> findAll();
	
	public AdministratorEntity findById(Long id);
	
	public AdministratorEntity save(AdministratorEntity administratorEntity);
	
	public void deleteById(Long id);
}
