package pl.com.bms.comments;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Repository
public class CommentsRepository {
    private List<Comment> comments;

    public CommentsRepository() {
        comments = new ArrayList<>();
        comments.add(new Comment(new Author("Zenon"), LocalDateTime.now(), "Message here"));
    }

    public void add(Comment comment) {
        comments.add(comment);
    }

    public int size() {
        return comments.size();
    }

    public List<Comment> getAll() {
        return unmodifiableList(comments);
    }
}
