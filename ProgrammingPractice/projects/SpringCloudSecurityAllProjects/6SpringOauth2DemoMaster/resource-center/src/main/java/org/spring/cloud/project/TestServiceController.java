package org.spring.cloud.project;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getTokenDetails(@RequestHeader HttpHeaders headers) {
		return headers.toString();
	}

}