package org.spring.security.jwt.controller;

import java.util.List;

import javax.annotation.Resource;

import org.spring.security.jwt.model.Employee;
import org.spring.security.jwt.model.JwtRequest;
import org.spring.security.jwt.model.JwtResponse;
import org.spring.security.jwt.service.EmployeeService;
import org.spring.security.jwt.utill.Constant;
import org.spring.security.jwt.utill.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Resource(name=Constant.EMPLOYEE_SERVICE_RESOURCE)
	private EmployeeService employeeServiice;
	
	@Resource(name="JwtTokenUtil")
	private JwtTokenUtil jwtToken;
	
	@Resource(name="authenticationManagerBean")
	private AuthenticationManager authenticationManager ;

	@Resource(name=Constant.USER_DETAILS_SERVICE_RESOURCE)
	private UserDetailsService userDetailsService;
	
	@GetMapping("/")
	public List<Employee> getAllEmployees(){
		return employeeServiice.getAllEmployees();
	}
	
	//https://www.javainuse.com/spring/boot-jwt
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
					);
		} catch (BadCredentialsException e) {
			 throw new Exception("INVAILID_CREDENTIALS : "+e);
		}
			
		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		final String token = jwtToken.generateToken(userDetails);
		
		return new JwtResponse(token);
	}
}
