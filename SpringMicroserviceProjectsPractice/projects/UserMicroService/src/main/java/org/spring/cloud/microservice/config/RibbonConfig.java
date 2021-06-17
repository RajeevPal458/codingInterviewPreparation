package org.spring.cloud.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

// hear you can configure load balancing rules 
// you can also give static list of servers in yml file instead of choosing dynamically from service registry
@Configuration
public class RibbonConfig {

	@Bean
	public IRule irule(){
		//return new AvailabilityFilteringRule();
		//return new RoundRobinRule();
		return new WeightedResponseTimeRule();
	}
}
