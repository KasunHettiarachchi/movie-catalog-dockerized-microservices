package com.data.rating.movies.movieratingdataservice;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@RibbonClient(
		name = "ping-a-server",
		configuration = RibbonConfiguration.class)
@EnableEurekaClient
public class MovieRatingDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingDataServiceApplication.class, args);
	}

}

class RibbonConfiguration {

	@Autowired
	IClientConfig ribbonClientConfig;

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new WeightedResponseTimeRule();
	}
}
