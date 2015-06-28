package pl.com.bms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.com.bms.event.EventDispatcher;
import pl.com.bms.event.IdeaCreated;
import pl.com.bms.idea.IdeaService;
import pl.com.bms.shared.CommentsService;
import pl.com.bms.shared.Idea;
import pl.com.bms.shared.IdeaRepository;

import java.util.Map;

@Controller
class IdeaController {

    private final CommentsService commentsService;
    private final IdeaService ideas;

    @Autowired
    public IdeaController(CommentsService commentsService, IdeaService ideas) {
        this.commentsService = commentsService;
        this.ideas = ideas;
    }

    @RequestMapping(value = {"/", "/idea", "/ideas"})
    public String listIdeas(Map<String, Object> model) {
        model.put("ideaList", ideas.getAll());
        return "ideasList";
    }

    @RequestMapping(value="/idea/add", method=RequestMethod.POST)
    public String addIdea(@ModelAttribute Idea idea,
                          Map<String, String> model) {
        Idea createdIdea = ideas.createNew(idea);

        model.put("author", createdIdea.getAuthor());
        model.put("title", createdIdea.getTitle());
        model.put("description", createdIdea.getDescription());
        return "redirect:/idea/" + createdIdea.getId();
    }

    @RequestMapping("/idea/{ideaId}")
    public String showIdeaDetails(@PathVariable String ideaId, Map<String, Object> model) {
        model.put("idea", ideas.get(ideaId));
        model.put("comments", commentsService.getAllFor(ideaId));
        return "ideaDetails";
    }
}
