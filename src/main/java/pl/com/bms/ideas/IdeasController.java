package pl.com.bms.ideas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.com.bms.event.EventDispatcher;
import pl.com.bms.event.IdeaCreated;
import pl.com.bms.shared.Idea;

import java.util.Map;

@Controller
class IdeasController {

    private final EventDispatcher eventDispatcher;

    @Autowired
    public IdeasController(final EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    @RequestMapping("/idea")
    public String idea(Map<String, String> model) {
        return "idea";
    }

    @RequestMapping(value="/idea/add", method=RequestMethod.POST)
    public String addIdea(@ModelAttribute Idea idea,
                          Map<String, String> model) {

        eventDispatcher.dispatch(new IdeaCreated(idea));

        model.put("author", idea.getAuthor());
        model.put("title", idea.getTitle());
        model.put("description", idea.getDescription());

        return "ideaAdded";
    }
}
