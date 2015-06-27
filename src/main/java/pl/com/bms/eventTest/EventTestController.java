package pl.com.bms.eventTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.bms.event.EventDispatcher;
import pl.com.bms.event.IdeaCreated;
import pl.com.bms.event.IdeaDownvoted;
import pl.com.bms.event.IdeaUpvoted;

@Controller
public class EventTestController {

    private static final String CONFIRMATION_PAGE = "eventTestConfirmation";

    private final EventDispatcher eventDispatcher;

    @Autowired
    public EventTestController(final EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    @RequestMapping("/eventTest/dispatchIdeaCreated")
    public String dispatchIdeaCreated() {
        eventDispatcher.dispatch(new IdeaCreated("Koszenie trawnika", "Koszenie trawnika raz w miesiącu", "Ogrodnik"));
        return CONFIRMATION_PAGE;
    }

    @RequestMapping("/eventTest/dispatchIdeaUpvoted")
    public String dispatchIdeaUpvoted() {
        eventDispatcher.dispatch(new IdeaUpvoted("Koszenie trawnika", "Koszenie trawnika raz w miesiącu", "Ogrodnik", "Pomocnik ogrodnika"));
        return CONFIRMATION_PAGE;
    }

    @RequestMapping("/eventTest/dispatchIdeaDownvoted")
    public String dispatchIdeaDownvoted() {
        eventDispatcher.dispatch(new IdeaDownvoted("Koszenie trawnika", "Koszenie trawnika raz w miesiącu", "Ogrodnik", "Natalia"));
        return CONFIRMATION_PAGE;
    }
}
