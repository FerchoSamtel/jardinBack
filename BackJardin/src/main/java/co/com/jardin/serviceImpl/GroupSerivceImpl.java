package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.GroupEntity;
import co.com.jardin.repository.IGroupRepository;
import co.com.jardin.servie.IGroupService;

@Service
public class GroupSerivceImpl implements IGroupService {

	private IGroupRepository grouprepository;
	
	@Autowired
	public GroupSerivceImpl(IGroupRepository grouprepository) {
		this.grouprepository = grouprepository;
	}

	@Override
	public List<GroupEntity> findAll() {
		return grouprepository.findAll();
	}

	@Override
	public GroupEntity findById(Long id) {
		return grouprepository.findById(id).orElse(null);
	}

	@Override
	public GroupEntity save(GroupEntity groupEntity) {
		return grouprepository.save(groupEntity);
	}

	@Override
	public void deleteById(Long id) {
		grouprepository.deleteById(id);
	}

}
