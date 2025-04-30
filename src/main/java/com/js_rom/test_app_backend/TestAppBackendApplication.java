package com.js_rom.test_app_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class}) // Not:resource  /error
public class TestAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAppBackendApplication.class, args);
	}

}
