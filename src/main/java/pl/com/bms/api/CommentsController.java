package pl.com.bms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.com.bms.shared.Comment;
import pl.com.bms.shared.CommentsService;

import java.util.Map;


@Controller
class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @RequestMapping(value = "/idea/{ideaID}/comments/add", method = RequestMethod.POST)
    public String addComment(@PathVariable String ideaID, @ModelAttribute Comment comment, Map<String, Object> model) {
        commentsService.save(ideaID, comment);
        return Redirection.toIdeaDetails(ideaID).asString();
    }
}
