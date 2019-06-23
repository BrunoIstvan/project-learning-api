package br.com.bicmsystems.project_learning.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.bicmsystems.project_learning"))
				.paths(PathSelectors.regex("/.*"))
				.build()
				.apiInfo(apiEndPointsInfo());
		
	}
	
	private ApiInfo apiEndPointsInfo() {
		
		return new ApiInfoBuilder().title("Project Learning")
	            .description("Project created to learn Spring Boot")
	            .contact(new Contact("Bruno Istvan Campos Monteiro", "", "bruno.istvan@gmail.com"))
	            .license("Apache 2.0")
	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	            .version("1.0.0")
	            .build();
		
	}
	
}
