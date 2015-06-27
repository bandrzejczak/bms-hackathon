package pl.com.bms.ideas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.com.bms.event.EventDispatcher;
import pl.com.bms.event.IdeaCreated;
import pl.com.bms.shared.Idea;
import pl.com.bms.shared.IdeaRepository;

import java.util.Map;

@Controller
class IdeasController {

    private final EventDispatcher eventDispatcher;
    private final IdeaRepository ideaRepo;

    @Autowired
    public IdeasController(final EventDispatcher eventDispatcher, IdeaRepository ideaRepo) {
        this.eventDispatcher = eventDispatcher;
        this.ideaRepo = ideaRepo;
    }

    @RequestMapping("/idea")
    public String idea(Map<String, String> model) {
        return "idea";
    }

    @RequestMapping(value="/idea/add", method=RequestMethod.POST)
    public String addIdea(@ModelAttribute Idea idea,
                          Map<String, String> model) {
        ideaRepo.save(idea);
        eventDispatcher.dispatch(new IdeaCreated(idea));

        model.put("author", idea.getAuthor());
        model.put("title", idea.getTitle());
        model.put("description", idea.getDescription());
        return "ideaAdded";
    }

    @RequestMapping("/idea/list")
    public String ideasList(Map<String, Object> model) {
        model.put("ideaList", ideaRepo.findAll());
        return "listIdeas";
    }

}
