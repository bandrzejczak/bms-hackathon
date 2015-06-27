package pl.com.bms.ideas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.bms.shared.Idea;
import pl.com.bms.shared.IdeaRepository;

import java.util.Map;

@Controller
class OneIdeaController {
    private final IdeaRepository repo;

    @Autowired
    public OneIdeaController(IdeaRepository repo) {
        this.repo = repo;
    }

    @RequestMapping("/ideadetails")
    public String idea(Map<String, Object> model) {
        Idea idea = getSomeIdea();
        model.put("idea", idea);
        return "ideadetails";
    }

    private Idea getSomeIdea() {
        return repo.findAll().iterator().next();
    }
}
