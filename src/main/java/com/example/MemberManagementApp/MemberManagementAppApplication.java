package com.example.MemberManagementApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info =@Info(title = "Member Management API", version = "1.0", description = "Handles members information on the database."))
@SpringBootApplication
public class MemberManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberManagementAppApplication.class, args);
	}

}
