package com.nicomartinezdev.qless.merchantlocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@EnableAutoConfiguration
public class MerchantLocatorApplication {

    public static void main(String[] args) {
        Object[] sources = {ApplicationConfig.class, SecurityConfig.class};
        SpringApplication.run(sources, args);
    }
}
