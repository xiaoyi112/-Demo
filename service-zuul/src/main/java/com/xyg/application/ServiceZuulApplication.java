package com.xyg.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceZuulApplication {
	
	//路由网关zuul及过滤器
	public static void main(String[] args) {
		
		SpringApplication.run(ServiceZuulApplication.class, args);
	}
}
