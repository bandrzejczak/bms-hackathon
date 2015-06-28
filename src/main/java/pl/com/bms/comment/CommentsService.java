package pl.com.bms.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class CommentsService {

    private final CommentRepository repo;

    @Autowired
    public CommentsService(CommentRepository commentsRepository) {
        this.repo = commentsRepository;
    }

    public void save(String ideaID, Comment comment) {
        comment.setId(UUID.randomUUID().toString());
        comment.setDatePosted(LocalDateTime.now());
        comment.setIdeaID(ideaID);
        repo.save(comment);
    }

    public List<Comment> getAllFor(String ideaID) {
        return repo.findByIdeaIDOrderByDatePostedDesc(ideaID);
    }
}
