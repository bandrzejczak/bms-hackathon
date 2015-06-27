package pl.com.bms.event

import com.google.common.eventbus.EventBus
import spock.lang.Specification

class EventDispatcherSpec extends Specification {

    def eventBus = Mock(EventBus)
    def eventDispatcher = new EventDispatcher(eventBus)

    def "should dispatch events to the event bus"() {
        given:
        def event = new Object()

        when:
        eventDispatcher.dispatch(event)

        then:
        1 * eventBus.post(event)
    }
}
