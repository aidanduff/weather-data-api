package com.aidanduff.weatherdataapi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.aidanduff.weatherdataapi.entity.WeatherRecord;
import com.aidanduff.weatherdataapi.service.WeatherRecordService;

@Component
public class CSVReader {
	
	@Autowired
	private WeatherRecordService weatherRecordService;
		
	public void readData() throws IOException {			
		BufferedReader reader = Files.newBufferedReader( ResourceUtils.getFile("classpath:mly129.csv").toPath());
		
		reader.lines()
		.sequential()
		.map(l -> l.split(","))
		.filter(o -> o.length >= 7)
		.map(WeatherRecordBuilder::new)
		.map(WeatherRecordBuilder::build)
		.filter(w -> w.getYear() > 0)
		.filter(x -> x!=null)
		.forEach(wr -> weatherRecordService.addWeatherRecord(wr));
	}

}
