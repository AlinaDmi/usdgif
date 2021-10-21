package com.usdgif.usdgif.controller;

import com.usdgif.usdgif.service.serviceinterface.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//Главный контроллер для получения курса и гиф
@RestController
public class USDController {

    private ExchangeService exchangeService;

    @Autowired
    public USDController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @RequestMapping(value="/getCur")
    public ResponseEntity<Map> getCur(){
        return (exchangeService.getRates());
    }
}