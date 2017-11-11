package fi.haagahelia.MessageBoard.domain;

import org.springframework.data.repository.CrudRepository;
import fi.haagahelia.MessageBoard.domain.Comment;


public interface CommentRepository extends CrudRepository<Comment, Long> {
	Comment findById (long id);
}
