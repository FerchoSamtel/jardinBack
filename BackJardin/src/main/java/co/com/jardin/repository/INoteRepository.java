package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.NoteEntity;

@Repository
public interface INoteRepository extends JpaRepository<NoteEntity, Long> {

}
