package pl.com.bms.idea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.bms.event.EventDispatcher;
import pl.com.bms.event.IdeaApproved;
import pl.com.bms.shared.Idea;
import pl.com.bms.shared.IdeaRepository;

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
}
