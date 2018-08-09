package com.xyg.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
@ComponentScan(value="{com.xyg.application}")
public class ServerApplication {
	
	//注册服务1
	public static void main(String[] args) {
        SpringApplication.run( ServerApplication.class, args );
    }
	@Value("${server.port}")
    String port;
	
	@RequestMapping("/hi")
    public String home(@RequestParam(value = "order", defaultValue = "YiDongHui") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
