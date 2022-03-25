package org.spring.cloud.eureka.gatway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@RequestMapping("/userServiceFallBack")
	public String userServiceFallBackMethod(){
		
		return "User service is taking time longer then as expected"+" please try again later";
	}
	
	@RequestMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod(){
		
		return "department service is taking time longer then as expected"+" please try again later";
	}
}
