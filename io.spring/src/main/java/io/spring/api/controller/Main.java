package io.spring.api.controller;

import java.math.BigDecimal;

public class Main {

    private String temp_max;
    private String temp_min;
    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return kelvinToCel(temp_max).toString()+"°C";
    }


    public String getTemp_min() {
        return kelvinToCel(temp_min).toString()+"°C";
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    // convert kelvin to celcius temperature

    private BigDecimal kelvinToCel(String kelvinTemp)
    {
        BigDecimal kelvin=new BigDecimal(kelvinTemp);
        BigDecimal baseValue=new BigDecimal("273.15");

        return kelvin.subtract(baseValue);
    }
}
