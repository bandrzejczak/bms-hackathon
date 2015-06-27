package pl.com.bms.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.com.bms.shared.CommentsService;

import java.util.Map;


@Controller
class CommentsController {

    private CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @RequestMapping(value = "/{ideaID}/comments", method = RequestMethod.GET)
    public String listComments(@PathVariable String ideaID, Map<String, Object> model) {
        model.put("comments", commentsService.getAllFor(ideaID));
        model.put("ideaID", ideaID);
        return "comments";
    }

   @RequestMapping(value = "/{ideaID}/comments", method = RequestMethod.POST)
   public String addComment(@PathVariable String ideaID, @ModelAttribute Comment comment, Map<String, Object> model) {
       commentsService.save(ideaID, comment);
       return "redirect:/ideadetails";
   }
}
