package pl.com.bms.email

import com.google.common.eventbus.EventBus
import org.springframework.core.io.ClassRelativeResourceLoader
import pl.com.bms.event.IdeaCommented
import pl.com.bms.event.IdeaCreated
import pl.com.bms.event.IdeaDownvoted
import pl.com.bms.event.IdeaUpvoted
import pl.com.bms.shared.Idea
import spock.lang.Shared
import spock.lang.Specification

class MailTemplateSpec extends Specification {

    def emailSender = Mock(EmailSender)
    def eventMailer = new EventMailer(Mock(EventBus), new ClassRelativeResourceLoader(getClass()), emailSender)

    static idea = new Idea(null, "Tytuł", "Opis", "Autor")

    def "should correctly use template and send an e-mail for a set of events"() {
        when:
        eventMailer.handleEvent(event)

        then:
        1 * emailSender.sendEmail(_, _)

        where:
        event << [
                new IdeaCreated(idea),
                new IdeaCommented(idea, "Komentarz", "Autor komentarza"),
                new IdeaUpvoted(idea, "Głosujący"),
                new IdeaDownvoted(idea, "Głosujący")
        ]
    }
}
