package pl.com.bms.doodle;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;

class DoodleFacade {

    private static final String NEW_POLL_URL = "http://doodle.com/np/new-polls/";
    private final HttpClient httpClient = HttpClients.createDefault();

    Doodle createDoodle(DoodleInfo doodleInfo) {
        try {
            HttpPost createDoodleRequest = new HttpPost(NEW_POLL_URL);
            createDoodleRequest.setEntity(doodleInfo.toHtmlEntity());
            HttpResponse response = httpClient.execute(createDoodleRequest);
            return getEntity(response, Doodle.class);

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private <T> T getEntity(HttpResponse response, Class<T> clazz) throws IOException {
        return new Gson().fromJson(
                new InputStreamReader(
                        response.getEntity().getContent()
                ),
                clazz
        );
    }

}
