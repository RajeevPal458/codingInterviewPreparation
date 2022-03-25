package org.spring.cloud.microservice.vo;

import org.spring.cloud.microservice.entity.User;

public class ResponceTemplateVo {

	private User user ;
	private Departments department ;
	
	
	public ResponceTemplateVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ResponceTemplateVo(User user, Departments department) {
		super();
		this.user = user;
		this.department = department;
	}


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Departments getDepartment() {
		return department;
	}
	public void setDepartment(Departments department) {
		this.department = department;
	}
	
}
