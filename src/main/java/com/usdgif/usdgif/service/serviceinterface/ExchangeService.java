package com.usdgif.usdgif.service.serviceinterface;

import org.springframework.http.ResponseEntity;

import java.util.Map;
//Интерфейс сервиса
public interface ExchangeService {
    ResponseEntity<Map> getRates();
}
