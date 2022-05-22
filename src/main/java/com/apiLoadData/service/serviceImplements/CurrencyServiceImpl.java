package com.apiLoadData.service.serviceImplements;

import com.apiLoadData.client.AlphaVantageCliente;
import com.apiLoadData.client.ApiStoreDataClient;
import com.apiLoadData.model.DataContainer;
import com.apiLoadData.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final AlphaVantageCliente alphaVantageCliente;
    private final ApiStoreDataClient apiStoreDataClient;

    public CurrencyServiceImpl(AlphaVantageCliente alphaVantageCliente, ApiStoreDataClient apiStoreDataClient) {
        this.alphaVantageCliente = alphaVantageCliente;
        this.apiStoreDataClient = apiStoreDataClient;
    }

    @Override
    public void sendDataApiStore(String crypto) throws IOException, InterruptedException {
        LocalDate today = LocalDate.now();
//      DataContainer data = getContainerUseHttpRequest(crypto);
        DataContainer data = alphaVantageCliente.getDataContainer(crypto);
        data.getDatas().get(today.toString()).setCurrencyName(data.getMeta().get("3. Digital Currency Name"));
        System.out.println(apiStoreDataClient.postCurreny(data,today)+" - "
                + data.getMeta().get("3. Digital Currency Name")
                +  " - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
    }

}
