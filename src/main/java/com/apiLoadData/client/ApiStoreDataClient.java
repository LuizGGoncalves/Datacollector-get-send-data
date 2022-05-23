package com.apiLoadData.client;

import com.apiLoadData.model.DataContainer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;

@Component
public class ApiStoreDataClient {
    @Value("${API_ALPHAVANTAGE_KEY}")
    private String apiKey;

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ApiStoreDataClient(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public int postCurreny(DataContainer data,LocalDate today) throws IOException, InterruptedException {
        String json = objectMapper.writeValueAsString(data.getDatas().get(today.toString()));
        HttpRequest requestSend = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("http://localhost:8081/"))
                //.uri(URI.create("http://host.docker.internal:8081/"))
                .header("Content-Type", "application/json")
                .timeout(Duration.ofSeconds(3))
                .build();
        HttpResponse<String> responseSend = httpClient.send(requestSend, HttpResponse.BodyHandlers.ofString());
        return responseSend.statusCode();
    }

    public DataContainer getContainerUseHttpRequest(String crypto) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_DAILY&symbol="
                        + crypto + "&market=BRL&apikey=" + apiKey))
                .timeout(Duration.ofSeconds(3))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), DataContainer.class);
    }
}
