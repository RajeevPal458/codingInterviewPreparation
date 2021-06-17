package org.spring.cloud.microservice.controller;

import java.util.logging.Logger;

import org.spring.cloud.microservice.entity.User;
import org.spring.cloud.microservice.service.UserService;
import org.spring.cloud.microservice.vo.ResponceTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	Logger logger = Logger.getLogger("UserController");
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user){
		logger.info("inside UserController saveUser ");
		return userService.saveUser(user);
	}
	
	
	@GetMapping("/{userId}")
	public ResponceTemplateVo getUserWithDepartments(@PathVariable long userId){
		logger.info("inside UserController getUserWithDepartments ");
		return userService.getUserWithDepartments(userId);
	}
	
	/*@GetMapping("/{id}")
	public User findUserById(@PathVariable("id") long id){
		logger.info("inside DepartmentController findDepartmentById ");
		return userService.findUserById(id);
	}*/
	
}
