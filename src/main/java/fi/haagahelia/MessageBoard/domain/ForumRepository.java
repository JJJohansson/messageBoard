package fi.haagahelia.MessageBoard.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ForumRepository extends CrudRepository<Forum, Long>{
	List<Forum> findById (long id);
}
