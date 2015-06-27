package pl.com.bms.comments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lk on 27.06.15.
 */
public class CommentsRepository {
    private List<Comment> comments;

    public CommentsRepository() {
        comments = new ArrayList<>();
    }

    public void add(Comment comment) {
        comments.add(comment);
    }

    public int size() {
        return comments.size();
    }
}
