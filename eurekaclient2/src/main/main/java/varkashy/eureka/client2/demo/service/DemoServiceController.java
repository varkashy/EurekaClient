package varkashy.eureka.client2.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class DemoServiceController {

    @Autowired
    DiscoveryClient client;

    @RequestMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return
                getWord("EUREKACLIENT1")
                ;
    }

    public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            String url=uri.toString()+"/words";
            if (url != null) {
                return (new RestTemplate()).getForObject(url, String.class);
            }
        }
        return null;
    }

}
