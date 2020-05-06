package co.com.jardin.servie;

import java.util.List;


import co.com.jardin.entity.UserEntity;

public interface IUserService {

	public List<UserEntity> findAll();
	
	public UserEntity findById(Long id);
	
	public UserEntity save(UserEntity userEntity);
	
	public void deleteById(Long id);
}
