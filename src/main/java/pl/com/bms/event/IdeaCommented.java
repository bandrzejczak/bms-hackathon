package pl.com.bms.event;

public class IdeaCommented {

    public final String ideaTitle;
    public final String ideaDescription;
    public final String ideaAuthor;

    public final String commentText;
    public final String commentAuthor;

    public IdeaCommented(final String ideaTitle,
                         final String ideaDescription,
                         final String ideaAuthor,
                         final String commentText,
                         final String commentAuthor) {

        this.ideaTitle = ideaTitle;
        this.ideaDescription = ideaDescription;
        this.ideaAuthor = ideaAuthor;
        this.commentText = commentText;
        this.commentAuthor = commentAuthor;
    }
}
