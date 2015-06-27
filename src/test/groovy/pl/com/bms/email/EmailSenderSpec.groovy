package pl.com.bms.email

import com.sun.jersey.api.client.WebResource
import spock.lang.Specification

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap

class EmailSenderSpec extends Specification {

    def "sendEmail should POST to webResource according to the mailgun API"() {
        given:
        def sender = "sender"
        def receiver = "receiver"
        def subject = "subject"
        def body = "body"

        def webResource = Mock(WebResource)
        def webResourceBuilder = Mock(WebResource.Builder)

        def emailSender = new EmailSender("http://ignored/ignored", "ignored", sender, receiver)
        emailSender.webResource = webResource

        when:
        emailSender.sendEmail(subject, body)

        then:
        webResource.type(MediaType.APPLICATION_FORM_URLENCODED) >> webResourceBuilder
        1 * webResourceBuilder.post(_, _) >> ({ c, MultivaluedMap requestEntity ->
            assert requestEntity.get("from")[0].equals(sender)
            assert requestEntity.get("to")[0].equals(receiver)
            assert requestEntity.get("subject")[0].equals(subject)
            assert requestEntity.get("text")[0].equals(body)
        })
    }
}
