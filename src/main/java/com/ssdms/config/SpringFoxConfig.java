package com.ssdms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	Docket apiDocket() {
		return new Docket(DocumentationType.OAS_30)
				.apiInfo(this.apiInfo())
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.ssdms.api.resources"))
					.build()
				.tags(
					new Tag("Contas", "Nomes das contas"),
					new Tag("Categorias", "Nomes das contegorias"),
					new Tag("Produtos", "detalhes dos produtos"),
					new Tag("Fornecedores", "detalhes dos fornecedores"),
					new Tag("Taxas", "detalhes das taxas"),
					new Tag("Produtos por fornecedor", "detalhes dos produtos por fornecedor"),
					new Tag("Unidades", "detalhes das unidades"),
					new Tag("Usuários", "detalhes dos usuários")
				);
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Store API")
				.description("Estoque de produtos")
				.version("1.0.2")
				.contact(new Contact("DMS software", "https://github.com/diorgenesmorais/ssdms", "diorgenesmorais@gmail.com"))
				.build();
	}
}
