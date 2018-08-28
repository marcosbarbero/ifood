package com.marcosbarbero.ifood.advanced;

import com.marcosbarbero.ifood.advanced.config.properties.IFoodProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableOAuth2Sso
@SpringBootApplication
@EnableConfigurationProperties(IFoodProperties.class)
public class AdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

}
