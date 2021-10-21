package com.usdgif.usdgif.service.implementation;

import com.usdgif.usdgif.client.ExchangeClient;
import com.usdgif.usdgif.client.GifClient;
import com.usdgif.usdgif.model.ExchangeModel;
import com.usdgif.usdgif.service.serviceinterface.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class ExchangeServiceImplement implements ExchangeService {
    private ExchangeModel currentRates;
    private ExchangeModel yesterdayRates;
    private String compared;

    @Autowired
    ExchangeClient exchangeClient;
    @Autowired
    GifClient gifClient;

    @Value("${openexchangerates.id}")
    private String appId;
    @Value("${openexchangerates.base}")
    private String base;
    @Value("${gif.key}")
    private String apiKey;

    @Value("${gif.current}")
    private String currentGif;
    @Value("${gif.yesterday}")
    private String yesterdayGif;
    @Value("${gif.same}")
    private String sameGif;


    @Override
    public ResponseEntity<Map> getRates() {
        refreshCurrentRates();
        getYesterdayRates();
       compared = compareRates();
       return (getGif(compared));
    }

    private void refreshCurrentRates() {
            this.currentRates = exchangeClient.getLatestRates(this.appId);
    }

    private void getYesterdayRates(){
        Date date = new Date(System.currentTimeMillis()-24*60*60*1000);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = (String)formatter.format(date);
        yesterdayRates = exchangeClient.getHistoricalRates(dateStr,this.appId);

    }

    private String compareRates(){
        Double curRate = currentRates.getRates().get(base);
        Double yestRate = yesterdayRates.getRates().get(base);
        System.out.println(curRate+" "+yestRate);
        if (curRate>yestRate){
            return currentGif;
        } else if(curRate<yestRate){
            return yesterdayGif;
        } else {
            return sameGif;
        }
    }

    private ResponseEntity<Map> getGif(String tag) {
        System.out.println("getting gif for "+tag);
        ResponseEntity<Map> result = gifClient.getGif(this.apiKey, tag);
        result.getBody().put("comparedRates", compared);
        return result;

    }

}
