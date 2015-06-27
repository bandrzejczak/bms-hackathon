package pl.com.bms.shared;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.bms.comments.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, String> {
    List<Comment> findByIdeaIDOrderByDatePostedDesc(String ideaID);
}
