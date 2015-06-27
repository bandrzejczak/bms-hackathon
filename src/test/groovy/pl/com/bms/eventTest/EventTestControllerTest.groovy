package pl.com.bms.eventTest

import pl.com.bms.event.EventDispatcher
import pl.com.bms.event.IdeaCreated
import pl.com.bms.event.IdeaDownvoted
import pl.com.bms.event.IdeaUpvoted
import spock.lang.Specification

class EventTestControllerTest extends Specification {

    def eventDispatcher = Mock(EventDispatcher)
    def eventTestController = new EventTestController(eventDispatcher)

    def "should dispatch an IdeaCreated event"() {
        when:
        eventTestController.dispatchIdeaCreated()

        then:
        1 * eventDispatcher.dispatch({ event -> event instanceof IdeaCreated })
    }

    def "should dispatch an IdeaUpvoted event"() {
        when:
        eventTestController.dispatchIdeaUpvoted()

        then:
        1 * eventDispatcher.dispatch({ event -> event instanceof IdeaUpvoted })
    }

    def "should dispatch an IdeaDownvoted event"() {
        when:
        eventTestController.dispatchIdeaDownvoted()

        then:
        1 * eventDispatcher.dispatch({ event -> event instanceof IdeaDownvoted })
    }
}
