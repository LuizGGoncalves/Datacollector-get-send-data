package com.apiLoadData.client;

import com.apiLoadData.model.DataContainer;
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


    public DataContainer getDataContainer(String crypto) {
        org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.set("teste","teste123");
        HttpEntity<Void> entity = new HttpEntity<>(null,httpHeaders);
        String url = getUrl(crypto);
        ResponseEntity<DataContainer> response = restTemplate.exchange(url, HttpMethod.GET, entity, DataContainer.class);
        return response.getBody();

    }

    private String getUrl(String crypto) {
        return UriComponentsBuilder.fromHttpUrl("https://www.alphavantage.co/query")
                .queryParam("function", "DIGITAL_CURRENCY_DAILY")
                .queryParam("symbol", crypto)
                .queryParam("market", "BRL")
                .queryParam("apikey", "3UU5N22LOD0DBK59")
                .toUriString();
    }

}
