package com.varkashy.microservices.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("EUREKACLIENT1")
public interface WordClientInterface {

    @RequestMapping(method = RequestMethod.GET,value = "/words")
    String getWords();
}
