package pl.com.bms.email

import com.google.common.eventbus.EventBus
import org.springframework.core.io.ClassRelativeResourceLoader
import pl.com.bms.event.IdeaCommented
import pl.com.bms.event.IdeaCreated
import pl.com.bms.event.IdeaDownvoted
import pl.com.bms.event.IdeaUpvoted
import spock.lang.Specification

class MailTemplateTest extends Specification {

    def emailSender = Mock(EmailSender)
    def eventMailer = new EventMailer(Mock(EventBus), new ClassRelativeResourceLoader(getClass()), emailSender)

    def "should correctly use template and send an e-mail for a set of events"() {
        when:
        eventMailer.onEvent(event)

        then:
        1 * emailSender.sendEmail(_, _)

        where:
        event << [
                new IdeaCreated("Tytuł", "Opis", "Autor"),
                new IdeaCommented("Tytuł", "Opis", "Autor", "Komentarz", "Autor komentarza"),
                new IdeaUpvoted("Tytuł", "Opis", "Autor", "Głosujący"),
                new IdeaDownvoted("Tytuł", "Opis", "Autor", "Głosujący")
        ]
    }
}
