package pl.com.bms.ideas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.activation.MimeType;
import java.util.Map;

/**
 * Created by mateusz on 27.06.15.
 */

@Controller
class IdeasController {

    @RequestMapping("/idea")
    public String idea(Map<String, String> model) {
        return "idea";
    }

    @RequestMapping(value="/idea/add", method=RequestMethod.POST)
    public String addIdea(@ModelAttribute Idea idea,
                          Map<String, String> model) {


        model.put("author", idea.getAuthor());
        model.put("title", idea.getTitle());
        model.put("description", idea.getDescription());

        return "ideaAdded";
    }
}
