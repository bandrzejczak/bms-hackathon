package pl.com.bms.eventTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.bms.event.*;

@Controller
@RequestMapping("/eventTest")
public class EventTestController {

    private static final String CONFIRMATION_PAGE = "eventTestConfirmation";

    private final EventDispatcher eventDispatcher;

    @Autowired
    public EventTestController(final EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    @RequestMapping("/dispatchIdeaCreated")
    public String dispatchIdeaCreated() {
        eventDispatcher.dispatch(new IdeaCreated("Koszenie trawnika", "Koszenie trawnika raz w miesiącu", "Ogrodnik"));
        return CONFIRMATION_PAGE;
    }

    @RequestMapping("/dispatchIdeaCommented")
    public String dispatchIdeaCommented() {
        eventDispatcher.dispatch(new IdeaCommented("Koszenie trawnika", "Koszenie trawnika raz w miesiącu", "Ogrodnik", "Moim zdaniem nie trzeba go kosić", "Ekspert Ogrodnictwa"));
        return CONFIRMATION_PAGE;
    }

    @RequestMapping("/dispatchIdeaUpvoted")
    public String dispatchIdeaUpvoted() {
        eventDispatcher.dispatch(new IdeaUpvoted("Koszenie trawnika", "Koszenie trawnika raz w miesiącu", "Ogrodnik", "Pomocnik ogrodnika"));
        return CONFIRMATION_PAGE;
    }

    @RequestMapping("/dispatchIdeaDownvoted")
    public String dispatchIdeaDownvoted() {
        eventDispatcher.dispatch(new IdeaDownvoted("Koszenie trawnika", "Koszenie trawnika raz w miesiącu", "Ogrodnik", "Natalia"));
        return CONFIRMATION_PAGE;
    }
}
