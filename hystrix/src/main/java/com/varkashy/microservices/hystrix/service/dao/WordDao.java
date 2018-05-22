package com.varkashy.microservices.hystrix.service.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("EUREKACLIENT1")
public interface WordDao {

    @RequestMapping(method = RequestMethod.GET,value="/words")
    public String getWords();
}
