package com.jay.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Account ms REST API Documentation",
				description = "Microservice course Account ms REST API Documentation ",
				version = "v1",
				contact = @Contact(
						name = "Jay Mishra",
						email = "Jay@mail.com",
						url = "http://www.jaymishra.com"
				),
				license = @License(
						name = "Tomcat 2.0",
						url = "http://www.jaymishra.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Microservice course Account ms REST API Documentation ",
				url = "http://www.jaymishra.com"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
