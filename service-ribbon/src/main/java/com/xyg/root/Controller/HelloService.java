package com.xyg.root.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
    
    @Value("${spring.application.name}")
    String serviceName;
    
    @HystrixCommand(fallbackMethod = "hiError") //熔断器
    public String hiService(String name) {
    	System.out.println(serviceName);
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
    
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}