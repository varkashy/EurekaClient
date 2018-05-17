package com.varkashy.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class LoadBalancedServiceClient {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return
                getWord("EUREKACLIENT1")
                ;
    }

    public String getWord(String service) {
        return restTemplate.getForObject("http://"+service, String.class);
    }
}
