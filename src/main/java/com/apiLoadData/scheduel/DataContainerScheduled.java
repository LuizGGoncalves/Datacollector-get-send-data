package com.apiLoadData.scheduel;

import com.apiLoadData.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DataContainerScheduled {

    @Autowired
    CurrencyService currencyService;

    @Scheduled(fixedDelay = 1000 * 60 * 20)
    public void getBtcData() throws IOException, InterruptedException {
        currencyService.sendDataApiStore("BTC");
    }

    @Scheduled(fixedDelay = 1000 * 60 * 20)
    public void getDashData() throws IOException, InterruptedException {
        currencyService.sendDataApiStore("DASH");
    }

    @Scheduled(fixedDelay = 1000 * 60 * 20)
    public void getDogeData() throws IOException, InterruptedException {
        currencyService.sendDataApiStore("DOGE");
    }

    @Scheduled(fixedDelay = 1000 * 60 * 20)
    public void getEthData() throws IOException, InterruptedException {
        currencyService.sendDataApiStore("ETH");
    }
}
