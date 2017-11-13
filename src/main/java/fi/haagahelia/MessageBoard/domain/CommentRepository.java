package fi.haagahelia.MessageBoard.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.MessageBoard.domain.Comment;


public interface CommentRepository extends CrudRepository<Comment, Long> {
	List<Comment> findById (long id);
	List<Comment> findByThreadId (long threadId);
	List<Comment> findByCreator (String creator);
}
