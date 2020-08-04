package com.aidanduff.weatherdataapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class WeatherDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherDataApiApplication.class, args);
	}

}
