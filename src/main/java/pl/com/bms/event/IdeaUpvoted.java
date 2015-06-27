package pl.com.bms.event;

public class IdeaUpvoted {

    public final String ideaTitle;
    public final String ideaDescription;
    public final String ideaAuthor;

    public final String voter;

    public IdeaUpvoted(final String ideaTitle, final String ideaDescription, final String ideaAuthor, final String voter) {
        this.ideaTitle = ideaTitle;
        this.ideaDescription = ideaDescription;
        this.ideaAuthor = ideaAuthor;
        this.voter = voter;
    }
}
