package com;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class MainApp  {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class,args);
    }


}
