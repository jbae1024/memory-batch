package com.jincom.batch.jincombatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JincomBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(JincomBatchApplication.class, args);
	}
}
