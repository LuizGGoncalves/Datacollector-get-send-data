package com.apiLoadData.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DataContainer {
    @JsonProperty("Meta Data")
    private Map<String,String> meta;
    @JsonProperty("Time Series (Digital Currency Daily)")
    private Map<String,Currency> datas;

    public DataContainer() {
    }

    public DataContainer(Map<String, String> meta, Map<String, Currency> datas) {
        this.meta = meta;
        this.datas = datas;
    }

    public Map<String, Currency> getDatas() {
        return datas;
    }

    public void setDatas(Map<String, Currency> datas) {
        this.datas = datas;
    }

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }
}
