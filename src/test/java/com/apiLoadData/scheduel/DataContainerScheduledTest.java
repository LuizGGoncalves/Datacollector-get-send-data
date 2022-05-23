package com.apiLoadData.scheduel;

import com.apiLoadData.ApiLoadDataApplication;
import com.apiLoadData.client.AlphaVantageCliente;
import com.apiLoadData.client.ApiStoreDataClient;
import com.apiLoadData.model.Currency;
import com.apiLoadData.model.DataContainer;
import com.apiLoadData.service.serviceImplements.CurrencyServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest(classes = ApiLoadDataApplication.class)
@RunWith(MockitoJUnitRunner.class)

class DataContainerScheduledTest {
    @Mock
    AlphaVantageCliente alphaVantageCliente;
    @Mock
    ApiStoreDataClient apiStoreDataClient;
    @InjectMocks
    private CurrencyServiceImpl currencyService;


    @Before
    public void setupMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getBtcData() throws IOException, InterruptedException {
        Currency currency = new Currency("BitCoin",35d,40d,50d,50d);
        Map<String,Currency> currencyMap = new HashMap<>();
        Map<String,String> meta = new HashMap<>();
        meta.put("3. Digital Currency Name","BitCoin");
        currencyMap.put(LocalDate.now().toString(),currency);
        DataContainer dataContainer = new DataContainer(meta,currencyMap);
        ResponseEntity<DataContainer> response = ResponseEntity.status(200).body(dataContainer);

        Mockito.when(alphaVantageCliente.getDataContainer("BitCoin")).thenReturn(ResponseEntity.status(201).body(dataContainer));
        Mockito.when(apiStoreDataClient.postCurreny(dataContainer, LocalDate.now())).thenReturn(201);

        currencyService.sendDataApiStore("BitCoin");
    }

}