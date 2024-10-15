package com.example.twitsnapappsgateway;

import com.example.twitsnapappsgateway.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitSnapGatewayApplication{
    public static void main(String[] args){
        Config.setEnv();
        SpringApplication.run(TwitSnapGatewayApplication.class, args);
    }
}
