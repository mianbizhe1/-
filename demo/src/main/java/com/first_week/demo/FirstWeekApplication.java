package com.first_week.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.first_week.demo.mapper")
@SpringBootApplication
public class FirstWeekApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstWeekApplication.class, args);
	}

}

