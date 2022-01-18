package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = { "com.example.demo.*" })
@EnableAutoConfiguration
@EnableAsync
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner showUpAndRunning(ApplicationContext ctx) {
		return args -> {
			System.out.println("====== Demo Application is starting ==========");
		};
	}

}
