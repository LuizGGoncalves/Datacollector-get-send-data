package com.apiLoadData.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


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

    public Currency() {
    }

    public Currency(String currencyName, Double brlOpen, Double usdOpen, Double brlClose, Double usdClose) {
        this.currencyName = currencyName;
        this.brlOpen = brlOpen;
        this.usdOpen = usdOpen;
        this.brlClose = brlClose;
        this.usdClose = usdClose;
    }

    public Double getBrlOpen() {
        return brlOpen;
    }

    public void setBrlOpen(Double brlOpen) {
        this.brlOpen = brlOpen;
    }

    public Double getUsdOpen() {
        return usdOpen;
    }

    public void setUsdOpen(Double usdOpen) {
        this.usdOpen = usdOpen;
    }

    public Double getBrlClose() {
        return brlClose;
    }

    public void setBrlClose(Double brlClose) {
        this.brlClose = brlClose;
    }

    public Double getUsdClose() {
        return usdClose;
    }

    public void setUsdClose(Double usdClose) {
        this.usdClose = usdClose;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

}
