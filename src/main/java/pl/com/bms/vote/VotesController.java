package pl.com.bms.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.com.bms.idea.Idea;
import pl.com.bms.idea.IdeaRepository;

import java.util.Map;

/**
 * Created by marcin.konarski on 2015-06-27.
 */
@Controller
public class VotesController {

    @Autowired
    private IdeaRepository ideaRepository;

    @RequestMapping(path = "/{ideaID}/votes", method = RequestMethod.GET)
    public String votes(@PathVariable String ideaID, Map<String, Object> model) {
        model.put("message", ideaID);
        return "votes";
    }

    @RequestMapping(path = "/{ideaID}/votelike", method = RequestMethod.GET)
    public @ResponseBody Idea voteLike(@PathVariable String ideaID) {
        Idea idea = ideaRepository.findOne(ideaID);
        idea.setUpVoteCount(idea.getUpVoteCount() + 1);
        ideaRepository.save(idea);
        return idea;
    }

    @RequestMapping(path = "/{ideaID}/votehate", method = RequestMethod.GET)
    public @ResponseBody Idea voteHate(@PathVariable String ideaID) {
        Idea idea = ideaRepository.findOne(ideaID);
        idea.setDownVoteCount(idea.getDownVoteCount() + 1);
        ideaRepository.save(idea);
        return idea;
    }

    @RequestMapping(path = "/{ideaID}/voteclear", method = RequestMethod.GET)
    public String voteClear(@PathVariable String ideaID) {
        return "votes";
    }

}
