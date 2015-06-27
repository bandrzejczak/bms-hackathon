package pl.com.bms.email;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.io.CharStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

@Component
public class EventMailer {

    private final ResourceLoader resourceLoader;
    private final EmailSender emailSender;

    @Autowired
    public EventMailer(final EventBus eventBus,
                       final ResourceLoader resourceLoader,
                       final EmailSender emailSender) {

        this.resourceLoader = resourceLoader;
        this.emailSender = emailSender;

        eventBus.register(this);
    }

    @Subscribe
    public void onEvent(final Object event) {
        final String eventName = event.getClass().getSimpleName();

        final String subject = resourceToString(resourceLoader.getResource(subjectResourceName(eventName)));
        final String body = resourceToString(resourceLoader.getResource(bodyResourceName(eventName)));

        if (subject == null) return;
        if (body == null) return;

        emailSender.sendEmail(subject, body);
    }

    private String subjectResourceName(final String eventName) {
        return "classpath:email/" + eventName + "-subject.txt";
    }

    private String bodyResourceName(final String eventName) {
        return "classpath:email/" + eventName + "-body.txt";
    }

    private String resourceToString(final Resource resource) {
        if (resource == null) return null;
        if (!resource.exists()) return null;

        try {
            return CharStreams.toString(new InputStreamReader(resource.getInputStream(), Charset.forName("utf-8")));
        } catch (IOException e) {
            return null;
        }
    }
}
