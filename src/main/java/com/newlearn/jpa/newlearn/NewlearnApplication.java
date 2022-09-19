package com.newlearn.jpa.newlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ServletComponentScan
@SpringBootApplication
public class NewlearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewlearnApplication.class, args);
	}

}
