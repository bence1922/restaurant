package bme.restaurant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import bme.restaurant.dto.UserSessionDTO;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@ComponentScan(basePackages = {"bme.restaurant"})
@EnableMongoRepositories(basePackages = {"bme.restaurant"})
@SecurityScheme(name = "sessionId", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER)
public class SpringApp {
	public static List<UserSessionDTO> activeUserSessions = new ArrayList<UserSessionDTO>(); 
	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class, args);
	}

}
