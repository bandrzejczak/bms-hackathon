package pl.com.bms.event;

import pl.com.bms.idea.Idea;

public class IdeaCommented {

    public final Idea idea;
    public final String commentText;
    public final String commentAuthor;

    public IdeaCommented(final Idea idea,
                         final String commentText,
                         final String commentAuthor) {

        this.idea = idea;
        this.commentText = commentText;
        this.commentAuthor = commentAuthor;
    }
}
