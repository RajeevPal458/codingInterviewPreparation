package org.spring.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
@EnableEurekaClient
public class DepartmentMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentMicroServiceApplication.class, args);
	}

	@RequestMapping("/")
	public String hello(){
		return "hello";
	}
	
}
