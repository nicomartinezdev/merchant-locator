package com.nicomartinezdev.qless.merchantlocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@EnableAutoConfiguration
public class MerchantLocatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }
}
