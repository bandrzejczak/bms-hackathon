package pl.com.bms.event;

import pl.com.bms.shared.Idea;

public class IdeaApproved {

    public final Idea idea;

    public IdeaApproved(final Idea idea) {
        this.idea = idea;
    }
}
