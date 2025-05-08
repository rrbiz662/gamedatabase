package com.rrbiz662.gamedatabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI gameDatabaseOpenAPI() {
		return new OpenAPI()
				.info(new Info()
				.title("Game REST API")
				.description("My games")
				.version("1.0"));
	}

}
