package com.catalog.services;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EcommerceAppApplication {
	static Logger logger = Logger.getLogger(EcommerceAppApplication.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceAppApplication.class, args);
	}

}
