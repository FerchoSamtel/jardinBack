package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.UserEntity;
import co.com.jardin.repository.IUserRepository;
import co.com.jardin.servie.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private IUserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	@Override
	public void deleteById(Long id) {
		 userRepository.deleteById(id);
	}
}
