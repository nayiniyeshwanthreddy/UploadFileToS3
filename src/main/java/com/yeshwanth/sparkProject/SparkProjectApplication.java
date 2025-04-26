package com.yeshwanth.sparkProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SparkProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparkProjectApplication.class, args);
	}

}
