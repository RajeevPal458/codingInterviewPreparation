package org.spring.security.jwt.controller;

import javax.annotation.security.RolesAllowed;

import org.spring.security.jwt.model.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RolesAllowed(Role.USER_ADMIN)
public class ConfirmOrderControler {

	@RequestMapping("/checkpayment")
	public void checkpayment() {
		
	}
}
