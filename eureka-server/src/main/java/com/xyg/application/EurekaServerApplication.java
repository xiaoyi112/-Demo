package com.xyg.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(value="{com.xyg.*}")
public class EurekaServerApplication {
	
	//服务注册中心
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
