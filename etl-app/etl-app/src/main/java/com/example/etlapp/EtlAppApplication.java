package com.example.etlapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class EtlAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtlAppApplication.class, args);
	}

}
