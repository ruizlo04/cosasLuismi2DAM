package com.example.monumentos_CarlosRuiz;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
		@Info(description = "Api de ejemplo para dammers",
		version = "1.0",
		contact = @Contact(email = "carlos.ruiz@gmail.com",
		name = "Carlos"))
)
public class MonumentosCarlosRuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonumentosCarlosRuizApplication.class, args);
	}

}
