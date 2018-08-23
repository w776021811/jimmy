package com.jimmy.rdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {
		"com.jimmy.rdf.*.config",
		"com.jimmy.rdf.*.controller",
		"com.jimmy.rdf.*.service"})
public class JimmyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JimmyApplication.class, args);
	}
}
