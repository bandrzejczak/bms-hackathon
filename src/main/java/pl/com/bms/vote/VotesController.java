package pl.com.bms.vote;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by marcin.konarski on 2015-06-27.
 */
@Controller
public class VotesController {

    @RequestMapping(path = "/{ideaID}/votes", method = RequestMethod.GET)
    public String votes(@PathVariable String ideaID, Map<String, Object> model) {
        model.put("message", ideaID);
        return "votes";
    }

    @RequestMapping(path = "/{ideaID}/votelike", method = RequestMethod.GET)
    public String voteLike(@PathVariable String ideaID) {
        return "votes";
    }

    @RequestMapping(path = "/{ideaID}/votehate", method = RequestMethod.GET)
    public String voteHate(@PathVariable String ideaID) {
        return "votes";
    }

    @RequestMapping(path = "/{ideaID}/voteclear", method = RequestMethod.GET)
    public String voteClear(@PathVariable String ideaID) {
        return "votes";
    }

}
