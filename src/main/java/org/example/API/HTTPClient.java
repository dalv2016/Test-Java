package org.example.API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HTTPClient {
    private String baseUrl;
    private HttpResponse response = null;

    public String getUsers(int size){

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        try {
            baseUrl ="https://random-data-api.com/api/v2/users?size="+size;
            URI uri = URI.create(baseUrl);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            response =client.send(request,HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body().toString();
    }


}
