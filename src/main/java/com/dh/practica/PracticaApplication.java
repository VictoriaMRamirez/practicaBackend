package com.dh.practica;

import org.apache.log4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticaApplication {

	public static void main(String[] args) {

		SpringApplication.run(PracticaApplication.class, args);
		PropertyConfigurator.configure("log4j.properties");
	}
}
