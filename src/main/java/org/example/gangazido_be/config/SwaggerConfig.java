package org.example.gangazido_be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
			.info(new Info().title("Gangazido API")
				.description("강아지 지도 API 문서")
				.version("1.0"));
	}
}
