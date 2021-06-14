package org.spring.cloud.microservice.repository;

import org.spring.cloud.microservice.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Long>{

}
