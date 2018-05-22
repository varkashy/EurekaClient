package com.varkashy.microservices.hystrix.service.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.varkashy.microservices.hystrix.service.dao.WordDao;
import com.varkashy.microservices.hystrix.service.service.HystrixDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

@Service
public class HystrixDemoServiceImpl implements HystrixDemoService {

    @Autowired
    WordDao wordDao;

    @Override
    @HystrixCommand(fallbackMethod = "getDefaultWords",
    commandProperties = {
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
            //This property means it will allow 20% failures as soon as 20 reach, the circuit breaker will open
            ,
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000")
            //Retry the flow after 1 sec
    })
    public String getSentence() {
        return wordDao.getWords();
    }

    public String getDefaultWords(){
        return "defaultWords";
    }
}
