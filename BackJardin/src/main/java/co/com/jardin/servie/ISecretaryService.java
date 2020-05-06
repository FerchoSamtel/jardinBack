package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.Secretaryentity;

public interface ISecretaryService {

	public List<Secretaryentity> findAll();
	
	public Secretaryentity findById(Long id);
	
	public Secretaryentity save(Secretaryentity secretaryentity);
	
	public void deleteById(Long id);
}
