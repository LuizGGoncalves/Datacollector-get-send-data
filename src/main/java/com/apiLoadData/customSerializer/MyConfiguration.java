package com.apiLoadData.customSerializer;

import com.apiLoadData.model.Currency;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class MyConfiguration {

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("custom", Version.unknownVersion());
        module.addSerializer(Currency.class, new CurrencySerializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }

    @Bean
    public HttpClient httpClientCustom(){
        return  HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .build();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(3)).build();
    }
}
