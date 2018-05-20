package com.varkashy.microservices.feign.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.varkashy.microservices.feign"})
@ComponentScan(basePackages = {"com.varkashy.microservices.feign"})
public class FeignDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignDemoApplication.class,args);
    }
}
