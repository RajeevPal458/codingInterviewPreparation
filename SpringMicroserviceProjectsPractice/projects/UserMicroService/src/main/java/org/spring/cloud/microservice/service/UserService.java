package org.spring.cloud.microservice.service;

import java.util.logging.Logger;

import org.spring.cloud.microservice.entity.User;
import org.spring.cloud.microservice.feign.clients.DepartmentFeignClient;
import org.spring.cloud.microservice.repository.UserRepository;
import org.spring.cloud.microservice.vo.Departments;
import org.spring.cloud.microservice.vo.ResponceTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {
	Logger logger = Logger.getLogger("UserService");
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private DepartmentFeignClient departmentFeignClient;
	
	private static final String BASE_USER_DEPARTMENT ="http://DEPARTMENT-SERVICE/department/" ;
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		logger.info("inside UserService saveDepartments");
		return userRepository.save(user);
	}

	public User findUserById(long id) {
		// TODO Auto-generated method stub
		logger.info("inside UserService findDepartmentById");
		return userRepository.findById(id).get();
	}
/*
	@HystrixCommand(fallbackMethod="fallBackMethodOnException")
	public ResponceTemplateVo getUserWithDepartments(long userId) {
		// TODO Auto-generated method stub
		logger.info("inside UserService getUserWithDepartments");
		ServiceInstance instance = loadBalancerClient.choose("DEPARTMENT-SERVICE");
		int portOfDepartService =instance.getPort() ;
		logger.info("calling instance of DepartmentService PORT:-"+portOfDepartService);
		ResponceTemplateVo responce = new ResponceTemplateVo();
		User user = userRepository.findById(userId).get();
		Departments departments= restTemplate.getForObject(BASE_USER_DEPARTMENT+user.getDepartmentId(), Departments.class);
		responce.setUser(user);
		responce.setDepartment(departments);
		return responce;
	}*/
	
	@HystrixCommand(fallbackMethod="fallBackMethodOnException")
	public ResponceTemplateVo getUserWithDepartments(long userId) {
		// TODO Auto-generated method stub
		logger.info("inside UserService getUserWithDepartments");
		ServiceInstance instance = loadBalancerClient.choose("DEPARTMENT-SERVICE");
		int portOfDepartService =instance.getPort() ;
		logger.info("calling instance of DepartmentService PORT:-"+portOfDepartService);
		ResponceTemplateVo responce = new ResponceTemplateVo();
		User user = userRepository.findById(userId).get();
		//Departments departments= restTemplate.getForObject(BASE_USER_DEPARTMENT+user.getDepartmentId(), Departments.class);
		Departments departments= departmentFeignClient.getDepartment(userId);
		responce.setUser(user);
		responce.setDepartment(departments);
		return responce;
	}
	
	
	public ResponceTemplateVo fallBackMethodOnException(long userId)  {
		return new ResponceTemplateVo();
	}
	
}
