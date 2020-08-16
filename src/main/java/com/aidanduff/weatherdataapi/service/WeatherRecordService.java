package com.aidanduff.weatherdataapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidanduff.weatherdataapi.dao.WeatherRecordRepository;
import com.aidanduff.weatherdataapi.entity.WeatherRecord;


@Service
public class WeatherRecordService {
	
	@Autowired
	private WeatherRecordRepository weatherRecordRepository;
	
	public List<WeatherRecord> getAllWeatherRecords(){
		List<WeatherRecord> weatherRecords = new ArrayList<>();
		
		weatherRecordRepository.findAll()
			.forEach(weatherRecords::add);
		
		return weatherRecords;
	}
	
	public WeatherRecord addWeatherRecord(WeatherRecord weatherRecord) {
		return weatherRecordRepository.save(weatherRecord);	
	}
	
	public void deleteAllRecords() {
		weatherRecordRepository.deleteAll();	
	}

}
