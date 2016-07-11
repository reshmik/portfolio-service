package io.pivotal.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * SpringBoot application for the portfolio microservice.
 * 
 * Responsible for managing the portfolio as well as providing the API.
 * 
 * @author Reshmi Krishna
 *
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PortfolioApplication {
	
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

		@Bean
		public AlwaysSampler defaultSampler() {
			return new AlwaysSampler();
		}

	
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
}
