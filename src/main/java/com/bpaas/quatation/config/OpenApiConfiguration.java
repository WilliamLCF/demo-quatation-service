package com.bpaas.quatation.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {

	String env = "dev";

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI().info(new Info()
			.title(String.format("Quatation-Service-%s", StringUtils.defaultString(env).toUpperCase()))
			.description("DEMO Quatation Service")
			.version("v1.0"));
	}

}
