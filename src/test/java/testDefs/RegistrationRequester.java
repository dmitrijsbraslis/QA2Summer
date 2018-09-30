package testDefs;

import model.Client;
import model.RegistrationResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.*;

public class RegistrationRequester {
    private final String URL = "http://207.154.242.0:8888/v1/register";

    public RegistrationResponse register(Client client) {
        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.postForEntity(URL, client, RegistrationResponse.class).getBody();
        HttpEntity<Client> request = new HttpEntity<>(client);

        try {
            ResponseEntity<RegistrationResponse> response =  restTemplate.exchange(URL, POST, request, RegistrationResponse.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            return null;
        }

    }
}
