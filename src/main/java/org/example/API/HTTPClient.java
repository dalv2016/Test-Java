package org.example.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import org.example.Entities.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HTTPClient {
    private String baseUrl;
    private HttpResponse response = null;
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<User> users = new ArrayList<>();
    @Getter
    boolean responseOk = true;

    public HTTPClient() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public ArrayList<User> getUsers(int size) {

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
            responseOk= true;

            users =  objectMapper.readValue(response.body().toString(), new TypeReference<>() {
            });
        } catch (Exception e) {
            responseOk =false;
            System.out.println(response.body().toString());
        }
        return users;
    }
}
