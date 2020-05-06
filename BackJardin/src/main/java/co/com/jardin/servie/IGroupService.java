package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.GroupEntity;

public interface IGroupService {

	public List<GroupEntity> findAll();
	
	public GroupEntity findById(Long id);
	
	public GroupEntity save(GroupEntity groupEntity);
	
	public void deleteById(Long id);
}
