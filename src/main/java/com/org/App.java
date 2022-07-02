package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class);
	}
}
