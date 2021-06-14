package org.spring.cloud.microservice.controller;

import java.util.logging.Logger;

import org.spring.cloud.microservice.entity.Departments;
import org.spring.cloud.microservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	Logger logger = Logger.getLogger("DepartmentController");
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Departments saveDepartments(@RequestBody Departments departments){
		logger.info("inside DepartmentController saveDepartments ");
		return departmentService.saveDepartments(departments);
	}
	
	@GetMapping("/{id}")
	public Departments findDepartmentById(@PathVariable("id") long id){
		logger.info("inside DepartmentController findDepartmentById ");
		return departmentService.findDepartmentById(id);
	}
	
}
