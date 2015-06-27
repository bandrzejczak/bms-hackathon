package pl.com.bms.event;

public class IdeaDownvoted {

    public final String ideaTitle;
    public final String ideaDescription;
    public final String ideaAuthor;

    public final String voter;

    public IdeaDownvoted(final String ideaTitle, final String ideaDescription, final String ideaAuthor, final String voter) {
        this.ideaTitle = ideaTitle;
        this.ideaDescription = ideaDescription;
        this.ideaAuthor = ideaAuthor;
        this.voter = voter;
    }
}
