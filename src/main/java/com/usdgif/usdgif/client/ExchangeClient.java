package com.usdgif.usdgif.client;

import com.usdgif.usdgif.model.ExchangeModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//Подключение к API для получения курса
@FeignClient(name = "Exchange", url = "${openexchangerates.link}")
public interface ExchangeClient {

    @GetMapping("/latest.json")
    ExchangeModel getLatestRates(
            @RequestParam("app_id") String appId
    );

    @GetMapping("/historical/{date}.json")
    ExchangeModel getHistoricalRates(
            @PathVariable String date,
            @RequestParam("app_id") String appId
    );
}