package pl.com.bms.event;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher {

    private final EventBus eventBus;

    @Autowired
    public EventDispatcher(final EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void dispatch(final Object event) {
        eventBus.post(event);
    }
}
