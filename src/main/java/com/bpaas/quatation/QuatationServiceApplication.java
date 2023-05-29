package com.bpaas.quatation;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Slf4j
@EnableAutoConfiguration
@SpringBootApplication
@EnableFeignClients
@Controller
public class QuatationServiceApplication {

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		log.info("*****************\n Spring boot application running in UTC timezone: "  + TimeZone.getDefault().getDisplayName(Locale.ENGLISH));
		log.info("*****************\n Spring boot application running at " + new Date());
		log.info(".....");
	}
	public static void main(String[] args) {
		SpringApplication.run(QuatationServiceApplication.class, args);
	}

	@GetMapping(path = "/")
	public String home() {
		return "redirect:swagger-ui.html";
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		// Allow anyone and anything access. Probably ok for Swagger spec
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");

		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Bean
	public MultipartProperties multipartProperties() {
		MultipartProperties multipartProperties = new MultipartProperties();
		multipartProperties.setMaxFileSize(DataSize.ofGigabytes(10));
		multipartProperties.setMaxRequestSize(DataSize.ofGigabytes(10));
		return multipartProperties;
	}
}
