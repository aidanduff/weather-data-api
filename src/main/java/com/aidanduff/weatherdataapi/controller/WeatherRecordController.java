package com.aidanduff.weatherdataapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aidanduff.weatherdataapi.entity.WeatherRecord;
import com.aidanduff.weatherdataapi.service.FilesStorageServiceImpl;
import com.aidanduff.weatherdataapi.service.WeatherRecordService;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "https://rainydays.herokuapp.com" })
@RestController
public class WeatherRecordController {

	@Autowired
	private WeatherRecordService weatherRecordService;
	
	@Autowired
	private FilesStorageServiceImpl filesStorageServiceImpl;
		
	@GetMapping("/weather")
	public ResponseEntity<List<WeatherRecord>> getAllRecords() {
		List<WeatherRecord> weatherRecordList = weatherRecordService.getAllWeatherRecords();
		return weatherRecordList.size() > 0? new ResponseEntity<>(weatherRecordList, HttpStatus.OK): ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete")
	public void deleteAllRecords() {
		filesStorageServiceImpl.deleteAll();
		filesStorageServiceImpl.init();
		weatherRecordService.deleteAllRecords();
		
	}
}
