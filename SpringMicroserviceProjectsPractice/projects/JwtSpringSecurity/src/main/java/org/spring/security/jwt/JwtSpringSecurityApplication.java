package org.spring.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
//https://www.toptal.com/spring/spring-security-tutorial

@SpringBootApplication
public class JwtSpringSecurityApplication {

	@Value("${spring.application.name:JwtSpringSecurityApplication}")
	private String name;
	
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecurityApplication.class, args);
	}

	 @RequestMapping(value = "/")
	 public String name() {
	    return name;
	 }
	 
	 @Bean
	 public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
	        return factory -> factory.setContextPath("/JwtSpringSecurityDemo");
	 }
}
