package org.spring.cloud.config.server.fallback;

import org.spring.cloud.config.server.model.GatewayClientResponse;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// reference https://www.baeldung.com/spring-zuul-fallback-route

import com.netflix.hystrix.exception.HystrixTimeoutException;

@RestController
public class FallBackMethodForAllServices implements FallbackProvider {

	private static final String DEFAULT_MESSAGE ="User service is taking time longer then as expected"+" please try again later";
	
	 @Override
	    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
	        if (cause instanceof HystrixTimeoutException) {
	            return new GatewayClientResponse(HttpStatus.GATEWAY_TIMEOUT, DEFAULT_MESSAGE);
	        } else {
	            return new GatewayClientResponse(HttpStatus.INTERNAL_SERVER_ERROR, DEFAULT_MESSAGE);
	        }
	    }

	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		return "*"; // it will routs for all microservices 
	}
}
