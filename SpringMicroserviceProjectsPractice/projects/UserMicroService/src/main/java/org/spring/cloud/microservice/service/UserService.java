package org.spring.cloud.microservice.service;

import java.util.logging.Logger;

import org.spring.cloud.microservice.entity.User;
import org.spring.cloud.microservice.repository.UserRepository;
import org.spring.cloud.microservice.vo.Departments;
import org.spring.cloud.microservice.vo.ResponceTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	Logger logger = Logger.getLogger("UserService");
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	
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

	
	public ResponceTemplateVo getUserWithDepartments(long userId) {
		// TODO Auto-generated method stub
		logger.info("inside UserService getUserWithDepartments");
		ResponceTemplateVo responce = new ResponceTemplateVo();
		User user = userRepository.findById(userId).get();
		Departments departments= restTemplate.getForObject(BASE_USER_DEPARTMENT+user.getDepartmentId(), Departments.class);
		responce.setUser(user);
		responce.setDepartment(departments);
		return responce;
	}
	
}
