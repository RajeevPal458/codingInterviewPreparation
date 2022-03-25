package org.spring.security.jwt.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.spring.security.jwt.model.Employee;
import org.spring.security.jwt.service.EmployeeService;
import org.spring.security.jwt.utill.Constant;
import org.springframework.stereotype.Service;

@Service(Constant.EMPLOYEE_SERVICE_RESOURCE)
public class EmployeeServiceImpl implements EmployeeService{
	
	
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		Employee emp=new Employee();
		emp.setEmployeeId("1234");
		emp.setEmployeeName("Raajeev");
		emp.setEmployeeEmail("rajeevkumar.lp100@gmail.com");
		emp.setEmployeePhone("9718221617");
		employeeList.add(emp);
		return employeeList;
	}
	

}
