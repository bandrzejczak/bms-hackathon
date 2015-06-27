package pl.com.bms.comments;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Repository
public class CommentsRepository {
    private ListMultimap<String, Comment> comments;

    public CommentsRepository() {
        comments = ArrayListMultimap.create();;
        comments.put("111", new Comment("Message here"));
    }

    public void add(String ideaID, Comment comment) {
        comments.put(ideaID, comment);
    }

    public List<Comment> getAllFor(String ideaId) {
        return comments.get(ideaId);
    }
}
