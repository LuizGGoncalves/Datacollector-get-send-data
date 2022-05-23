package com.apiLoadData.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataContainer {
    @JsonProperty("Meta Data")
    private Map<String,String> meta;
    @JsonProperty("Time Series (Digital Currency Daily)")
    private Map<String,Currency> datas;


    public DataContainer(Map<String, String> meta, Map<String, Currency> datas) {
        this.meta = meta;
        this.datas = datas;
    }
}
