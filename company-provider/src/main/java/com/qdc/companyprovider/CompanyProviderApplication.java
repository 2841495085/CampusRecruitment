package com.qdc.companyprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CompanyProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyProviderApplication.class, args);
    }

}
