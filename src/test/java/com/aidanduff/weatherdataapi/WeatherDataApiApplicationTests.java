package com.aidanduff.weatherdataapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aidanduff.weatherdataapi.controller.FilesController;
import com.aidanduff.weatherdataapi.controller.WeatherRecordController;
import com.aidanduff.weatherdataapi.service.FilesStorageService;
import com.aidanduff.weatherdataapi.service.WeatherRecordService;

@SpringBootTest
class WeatherDataApiApplicationTests {
	
	@Autowired
	WeatherRecordController weatherRecordController;
	
	@Autowired
	WeatherRecordService weatherRecordService;
	
	@Autowired
	FilesController filesController;
	
	@Autowired
	FilesStorageService filesStorageService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void filesContollerLoads() throws Exception {
		assertThat(filesController).isNotNull();
	}
	
	@Test
	public void weatherRecordControllerLoads() throws Exception {
		assertThat(weatherRecordController).isNotNull();
	}
	
	@Test
	public void filesStorageServiceLoads() throws Exception {
		assertThat(filesStorageService).isNotNull();
	}
	
	@Test
	public void weatherRecordServiceLoads() throws Exception {
		assertThat(weatherRecordService).isNotNull();
	}

}
