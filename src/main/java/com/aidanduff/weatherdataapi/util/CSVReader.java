package com.aidanduff.weatherdataapi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.aidanduff.weatherdataapi.service.FilesStorageServiceImpl;
import com.aidanduff.weatherdataapi.service.WeatherRecordService;

@Component
public class CSVReader {
	
	@Autowired
	private WeatherRecordService weatherRecordService;
	
	@Autowired
	private FilesStorageServiceImpl filesStorageServiceImpl;
		
	public void readData(File file) throws IOException {		
		BufferedReader reader = Files.newBufferedReader(file.toPath());
		
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
