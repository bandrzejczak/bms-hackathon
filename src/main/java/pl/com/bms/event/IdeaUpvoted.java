package pl.com.bms.event;

import pl.com.bms.shared.Idea;

public class IdeaUpvoted {

    public final Idea idea;
    public final String voter;

    public IdeaUpvoted(final Idea idea, final String voter) {
        this.idea = idea;
        this.voter = voter;
    }
}
