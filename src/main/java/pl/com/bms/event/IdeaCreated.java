package pl.com.bms.event;

import pl.com.bms.shared.Idea;

public class IdeaCreated {

    public final Idea idea;

    public IdeaCreated(final Idea idea) {
        this.idea = idea;
    }
}
