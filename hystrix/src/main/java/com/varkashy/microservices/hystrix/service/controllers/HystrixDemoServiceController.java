package com.varkashy.microservices.hystrix.service.controllers;

import com.varkashy.microservices.hystrix.service.service.HystrixDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HystrixDemoServiceController {

    @Resource
    HystrixDemoService hystrixDemoService;

    @GetMapping("/sentence")
    public String getSentence(){
        return hystrixDemoService.getSentence();
    }

}
