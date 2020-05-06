package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.Secretaryentity;
import co.com.jardin.repository.ISecretaryRepository;
import co.com.jardin.servie.ISecretaryService;

@Service
public class SecretaryServiceImpl implements ISecretaryService {

	private ISecretaryRepository secretaryrepository;
	
	@Autowired
	public SecretaryServiceImpl(ISecretaryRepository secretaryrepository) {
		this.secretaryrepository = secretaryrepository;
	}

	@Override
	public List<Secretaryentity> findAll() {
		return secretaryrepository.findAll();
	}

	@Override
	public Secretaryentity findById(Long id) {
		return secretaryrepository.findById(id).orElse(null);
	}

	@Override
	public Secretaryentity save(Secretaryentity secretaryentity) {
		return secretaryrepository.save(secretaryentity);
	}

	@Override
	public void deleteById(Long id) {
		secretaryrepository.deleteById(id);
	}

}
