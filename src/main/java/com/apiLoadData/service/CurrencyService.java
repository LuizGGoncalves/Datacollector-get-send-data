package com.apiLoadData.service;

import java.io.IOException;

public interface CurrencyService {
    void sendDataApiStore(String crypto) throws IOException, InterruptedException;

}
