package io.spring.api.controller;

import org.springframework.stereotype.Component;

@Component
public class Weather {
    Main main=new Main();
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
