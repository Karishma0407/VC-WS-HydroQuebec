package dev.webservices.hydroquebec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {
		"dev.webservices.addresses.Entity",
		"dev.webservices.employeelib.Entity"
})
@EnableAutoConfiguration
public class HydroquebecApplication {

	public static void main(String[] args) {
		SpringApplication.run(HydroquebecApplication.class, args);
	}

}
