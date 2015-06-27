package pl.com.bms.doodle;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class DoodleInfo {

    private static final String COUNTRY_CODE = "PL";
    private static final String COUNTRY_LOCALE = "pl_PL";

    private final String title;
    private final String creator;
    private final String creatorEmail;
    private final DoodleType type;
    private final List<String> options;

    DoodleInfo(String title, String creator, String creatorEmail, DoodleType type, List<String> options) {
        this.title = title;
        this.creator = creator;
        this.creatorEmail = creatorEmail;
        this.type = type;
        this.options = options;
    }

    public CompletableFuture<Doodle> createDoodle(){
        return new DoodleFacade().createDoodle(this);
    }

    HttpEntity toHtmlEntity() {
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("title", title));
        parameters.add(new BasicNameValuePair("initiatorAlias", creator));
        parameters.add(new BasicNameValuePair("initiatorEmail", creatorEmail));
        parameters.add(new BasicNameValuePair("optionsMode", type.mode));
        parameters.add(new BasicNameValuePair("type", type.type));
        options.forEach(
            option -> parameters.add(new BasicNameValuePair("options[]", option))
        );
        parameters.add(new BasicNameValuePair("country", COUNTRY_CODE));
        parameters.add(new BasicNameValuePair("locale", COUNTRY_LOCALE));
        try {
            return new UrlEncodedFormEntity(parameters, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException();
        }
    }
}
