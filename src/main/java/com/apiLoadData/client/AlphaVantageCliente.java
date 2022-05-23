package com.apiLoadData.client;

import com.apiLoadData.model.DataContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AlphaVantageCliente {
    private final RestTemplate restTemplate;
    public AlphaVantageCliente(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${API_ALPHAVANTAGE_KEY}")
    private String apiKey;

    public ResponseEntity<DataContainer> getDataContainer(String cryptoIdName) {
        org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.set("teste","teste123");
        HttpEntity<Void> entity = new HttpEntity<>(null,httpHeaders);
        String url = UriComponentsBuilder.fromHttpUrl("https://www.alphavantage.co/query")
                .queryParam("function", "DIGITAL_CURRENCY_DAILY")
                .queryParam("symbol", cryptoIdName)
                .queryParam("market", "BRL")
                .queryParam("apikey", apiKey)
                .toUriString();
        return restTemplate.exchange(url, HttpMethod.GET, entity, DataContainer.class);
    }
}
