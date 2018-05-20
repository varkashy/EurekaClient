package com.varkashy.microservices.feign.service.demo;

import com.varkashy.microservices.feign.service.WordClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignDemoServiceController {

    @Autowired
    public void setWordClientInterface(WordClientInterface wordClientInterface) {
        this.wordClientInterface = wordClientInterface;
    }

    WordClientInterface wordClientInterface;

    @GetMapping("/Sentence")
    public String getSentence(){
        return wordClientInterface.getWords();
    }
}
