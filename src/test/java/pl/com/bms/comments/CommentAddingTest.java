package pl.com.bms.comments;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by lk on 27.06.15.
 */
public class CommentAddingTest {
    @Test
    public void shouldAddComment() {
        //given
        CommentsRepository commentRepository = new CommentsRepository();
        //when
        Comment comment = new Comment(null, null, null);
        commentRepository.add(comment);
        //then
        assertThat(commentRepository.size()).isEqualTo(1);
    }
}
