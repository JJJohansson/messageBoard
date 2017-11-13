package fi.haagahelia.MessageBoard.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ThreadRepository extends CrudRepository<Thread, Long>{
	List<Thread> findById (long id);
	List<Thread> findByForumId (long forumId);
	List<Thread> findByCreator (String creator);
}
