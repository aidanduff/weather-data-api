package com.aidanduff.weatherdataapi;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aidanduff.weatherdataapi.service.FilesStorageService;

@SpringBootApplication
@EnableAutoConfiguration
public class WeatherDataApiApplication implements CommandLineRunner {
	  @Resource
	  FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(WeatherDataApiApplication.class, args);
	}
	
	@Override
	  public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }

}
