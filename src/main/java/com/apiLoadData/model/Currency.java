package com.apiLoadData.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    private String currencyName;
    @JsonProperty("1a. open (BRL)")
    private Double brlOpen;
    @JsonProperty("1b. open (USD)")
    private Double usdOpen;
    @JsonProperty("4a. close (BRL)")
    private Double brlClose;
    @JsonProperty("4b. close (USD)")
    private Double usdClose;

    public Currency(String currencyName, Double brlOpen, Double usdOpen, Double brlClose, Double usdClose) {
        this.currencyName = currencyName;
        this.brlOpen = brlOpen;
        this.usdOpen = usdOpen;
        this.brlClose = brlClose;
        this.usdClose = usdClose;
    }
}
