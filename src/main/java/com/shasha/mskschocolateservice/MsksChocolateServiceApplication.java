package com.shasha.mskschocolateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsksChocolateServiceApplication {

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(MsksChocolateServiceApplication.class, args);
		System.out.println("End");
	}

}
