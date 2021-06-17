package org.spring.cloud.microservice.feign.clients;

import org.spring.cloud.microservice.vo.Departments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface DepartmentFeignClient {

	 @GetMapping("/department/{id}")
	 public Departments getDepartment(@PathVariable("id") long id);
}
