package pl.com.bms.email

import com.google.common.eventbus.EventBus
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import spock.lang.Specification

class EventMailerTest extends Specification {

    def eventBus = Mock(EventBus)
    def resourceLoader = Mock(ResourceLoader)
    def emailSender = Mock(EmailSender)

    def eventMailer = new EventMailer(eventBus, resourceLoader, emailSender)

    class TestEvent {
        public String firstVariable;
        public String secondVariable;
    }

    def "should register with the event bus"() {
        when:
        new EventMailer(eventBus, null, null)

        then:
        1 * eventBus.register(_)
    }

    def "should not send an e-mail when neither subject not body are available"() {
        when:
        eventMailer.onEvent(new TestEvent())

        then:
        0 * emailSender.sendEmail(_, _)
    }

    def "should not send an e-mail when no subject is available for the event"() {
        given:
        resourceLoader.getResource("classpath:email/TestEvent-body.txt") >> createResource("Some body")

        when:
        eventMailer.onEvent(new TestEvent())

        then:
        0 * emailSender.sendEmail(_, _)
    }

    def "should not send an e-mail when no body is available for the event"() {
        given:
        resourceLoader.getResource("classpath:email/TestEvent-subject.txt") >> createResource("Some subject")

        when:
        eventMailer.onEvent(new TestEvent())

        then:
        0 * emailSender.sendEmail(_, _)
    }

    def "should send an e-mail if subject and body are available for the event"() {
        given:
        resourceLoader.getResource("classpath:email/TestEvent-subject.txt") >> createResource("Some subject")
        resourceLoader.getResource("classpath:email/TestEvent-body.txt") >> createResource("Some body")

        when:
        eventMailer.onEvent(new TestEvent())

        then:
        1 * emailSender.sendEmail("Some subject", "Some body")
    }

    def "should replace parameter values in subject and body"() {
        given:
        resourceLoader.getResource("classpath:email/TestEvent-subject.txt") >> createResource("Subject {{firstVariable}}")
        resourceLoader.getResource("classpath:email/TestEvent-body.txt") >> createResource("Body {{firstVariable}} {{secondVariable}}")

        when:
        eventMailer.onEvent(new TestEvent(firstVariable: "aaa", secondVariable: "bbb"))

        then:
        1 * emailSender.sendEmail("Subject aaa", "Body aaa bbb")
    }

    private Resource createResource(final String text) {
        new ByteArrayResource(new String(text).getBytes("utf-8"))
    }
}
