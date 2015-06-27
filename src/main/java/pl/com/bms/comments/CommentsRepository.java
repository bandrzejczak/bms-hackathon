package pl.com.bms.comments;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentsRepository {
    private ListMultimap<String, Comment> comments;

    public CommentsRepository() {
        comments = ArrayListMultimap.create();
        comments.put("111", new Comment("Message here"));
    }

    public void add(String ideaID, Comment comment) {
        comments.put(ideaID, comment);
    }

    public List<Comment> getAllFor(String ideaId) {
        return comments.get(ideaId).stream()
                .sorted((e1, e2) -> e2.datePosted.compareTo(e1.datePosted))
                .collect(Collectors.toList());
    }
}
