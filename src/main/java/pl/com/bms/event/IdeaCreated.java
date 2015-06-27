package pl.com.bms.event;

public class IdeaCreated {

    public final String ideaTitle;
    public final String ideaDescription;
    public final String ideaAuthor;

    public IdeaCreated(final String ideaTitle, final String ideaDescription, final String ideaAuthor) {
        this.ideaTitle = ideaTitle;
        this.ideaDescription = ideaDescription;
        this.ideaAuthor = ideaAuthor;
    }
}
