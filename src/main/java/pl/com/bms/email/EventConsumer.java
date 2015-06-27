package pl.com.bms.email;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.bms.email.EmailSender;
import pl.com.bms.event.IdeaCreated;

@Component
public class EventConsumer {

    private final EmailSender emailSender;

    @Autowired
    public EventConsumer(final EventBus eventBus, final EmailSender emailSender) {
        this.emailSender = emailSender;
        eventBus.register(this);
    }

    @Subscribe
    public void onTestEvent(final IdeaCreated ideaCreated) {
        emailSender.sendEmail(ideaCreated.ideaTitle, ideaCreated.ideaDescription);
    }

}
