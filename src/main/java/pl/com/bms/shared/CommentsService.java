package pl.com.bms.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.bms.comments.Comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        return repo.findByIdeaID(ideaID).stream()
                .sorted((e1, e2) -> e2.compareByPostedDate(e1))
                .collect(Collectors.toList());
    }
}
