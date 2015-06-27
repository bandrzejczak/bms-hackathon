package pl.com.bms.event;

import pl.com.bms.shared.Idea;

public class IdeaDownvoted {

    public final Idea idea;
    public final String voter;

    public IdeaDownvoted(final Idea idea, final String voter) {
        this.idea = idea;
        this.voter = voter;
    }
}
