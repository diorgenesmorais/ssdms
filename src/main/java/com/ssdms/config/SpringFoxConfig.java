package com.ssdms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	Docket apiDocket() {
		return new Docket(DocumentationType.OAS_30)
				.apiInfo(this.apiInfo())
				.select()
					.apis(RequestHandlerSelectors.any())
					.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Store API")
				.description("Estoque de produtos")
				.version("1.0.1")
				.contact(new Contact("DMS software", "https://github.com/diorgenesmorais/consumer", "diorgenesmorais@gmail.com"))
				.build();
	}
}
