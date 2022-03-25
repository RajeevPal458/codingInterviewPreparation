package org.spring.cloud.microservice.service;

import java.util.logging.Logger;

import org.spring.cloud.microservice.entity.Departments;
import org.spring.cloud.microservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	Logger logger = Logger.getLogger("DepartmentController");
	@Autowired
	private DepartmentRepository departmentRepository;

	public Departments saveDepartments(Departments departments) {
		// TODO Auto-generated method stub
		logger.info("inside DepartmentService saveDepartments");
		return departmentRepository.save(departments);
	}

	public Departments findDepartmentById(long id) {
		// TODO Auto-generated method stub
		logger.info("inside DepartmentService findDepartmentById");
		return departmentRepository.findById(id).get();
	}
	
}
