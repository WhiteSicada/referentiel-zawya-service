package com.referentiel.zawya;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition
public class ZawyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZawyaApplication.class, args);
	}

}
