package pl.com.bms.doodle;

import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DoodleInfo {

    public Doodle createDoodle(){
        HttpClient httpClient = HttpClients.createDefault();
        DoodleResponse doodleResponse;
        try {
            HttpPost createDoodleRequest = new HttpPost("http://doodle.com/np/new-polls/");
            List<NameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair("title", "dupa"));
            parameters.add(new BasicNameValuePair("initiatorAlias", "dupa"));
            parameters.add(new BasicNameValuePair("initiatorEmail", "dupa@wp.pl"));
            parameters.add(new BasicNameValuePair("optionsMode", "text"));
            parameters.add(new BasicNameValuePair("options[]", "Lasagne"));
            parameters.add(new BasicNameValuePair("options[]", "Pizza"));
            parameters.add(new BasicNameValuePair("type", "TEXT"));
            parameters.add(new BasicNameValuePair("country", "PL"));
            parameters.add(new BasicNameValuePair("locale", "pl_PL"));
            createDoodleRequest.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));
            InputStream content = httpClient.execute(createDoodleRequest).getEntity().getContent();
            doodleResponse = new Gson().fromJson(new InputStreamReader(content), DoodleResponse.class);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return new Doodle(doodleResponse.id, doodleResponse.adminKey);
    }

}
