package com.usdgif.usdgif.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
//Подключение к API для получения гиф
@FeignClient(name = "GifClient", url = "${gif.link}")
public interface GifClient {

    @GetMapping("/random")
    ResponseEntity<Map> getGif(
            @RequestParam("api_key") String apiKey,
            @RequestParam("tag") String tag
    );

}
