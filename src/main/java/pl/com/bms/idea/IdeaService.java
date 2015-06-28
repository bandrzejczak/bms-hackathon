package pl.com.bms.idea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.bms.event.EventDispatcher;
import pl.com.bms.event.IdeaApproved;
import pl.com.bms.event.IdeaCreated;

@Service
public class IdeaService {

    private final IdeaRepository ideaRepository;
    private final EventDispatcher eventDispatcher;

    @Autowired
    public IdeaService(IdeaRepository ideaRepository, EventDispatcher eventDispatcher) {
        this.ideaRepository = ideaRepository;
        this.eventDispatcher = eventDispatcher;
    }

    public Iterable<Idea> getAll() {
        return ideaRepository.findAll();
    }

    public void approveIdea(String ideaId) {
        Idea idea = ideaRepository.findOne(ideaId);
        idea.approve();
        ideaRepository.save(idea);

        eventDispatcher.dispatch(new IdeaApproved(idea));
    }

    public Idea createNew(Idea idea) {
        Idea createdIdea = ideaRepository.save(idea);
        eventDispatcher.dispatch(new IdeaCreated(createdIdea));
        return createdIdea;
    }

    public Idea get(String ideaId) {
        return ideaRepository.findOne(ideaId);
    }
}
