package pl.com.bms.ideas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.bms.shared.CommentsService;
import pl.com.bms.shared.Idea;
import pl.com.bms.shared.IdeaRepository;

import java.util.Map;

@Controller
class OneIdeaController {
    private final IdeaRepository repo;
    private final CommentsService commentsService;

    @Autowired
    public OneIdeaController(IdeaRepository repo, CommentsService commentsService) {
        this.repo = repo;
        this.commentsService = commentsService;
    }

    @RequestMapping("/ideadetails")
    public String idea(Map<String, Object> model) {
        Idea idea = getSomeIdea();
        model.put("comments", commentsService.getAllFor(idea.getId()));
        model.put("idea", idea);
        return "ideadetails";
    }

    private Idea getSomeIdea() {
        return repo.findAll().iterator().next();
    }
}
