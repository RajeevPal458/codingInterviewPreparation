package org.spring.cloud.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class DepartmentMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentMicroServiceApplication.class, args);
	}

	@RequestMapping("/")
	public String hello(){
		return "hello";
	}
	
}
