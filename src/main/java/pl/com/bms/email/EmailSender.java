package pl.com.bms.email;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Service
public class EmailSender {

    private String mailFrom;
    private String mailTo;

    private WebResource webResource;

    @Autowired
    public EmailSender(@Value("${mailgun.url}") final String mailgunUrl,
                       @Value("${mailgun.key}") final String mailgunKey,
                       @Value("${mail.from}") final String mailFrom,
                       @Value("${mail.to}") final String mailTo) {

        this.mailFrom = mailFrom;
        this.mailTo = mailTo;

        final Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("api", mailgunKey));

        webResource = client.resource(mailgunUrl);
    }

    public void sendEmail(final String subject, final String text) {
        final MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("from", mailFrom);
        formData.add("to", mailTo);
        formData.add("subject", subject);
        formData.add("text", text);

        webResource.type(MediaType.APPLICATION_FORM_URLENCODED)
                .post(ClientResponse.class, formData);
    }
}
