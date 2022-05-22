package com.apiLoadData.customSerializer;

import com.apiLoadData.model.Currency;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CurrencySerializer extends JsonSerializer<Currency> {
    @Override
    public void serialize(Currency currency, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("currencyName", currency.getCurrencyName());
        jsonGenerator.writeNumberField("brlOpen",currency.getBrlOpen());
        jsonGenerator.writeNumberField("usdOpen",currency.getUsdOpen());
        jsonGenerator.writeNumberField("brlClose",currency.getBrlClose());
        jsonGenerator.writeNumberField("usdClose",currency.getUsdClose());
        jsonGenerator.writeEndObject();
    }
}
