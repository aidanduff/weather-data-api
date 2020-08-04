package com.aidanduff.weatherdataapi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.aidanduff.weatherdataapi.entity.WeatherRecord;
import com.aidanduff.weatherdataapi.service.WeatherRecordService;

@Component
public class CSVReader {
//	private static CSVReader instance = null; 
	static BufferedReader reader;
	
	@Autowired
	private WeatherRecordService weatherRecordService;
	
//	private CSVReader() throws IOException {
//		this.readData();
//	}
	
	public CSVReader() throws IOException {
//		this.readData();
	}
	
//	public static synchronized CSVReader getInstance() throws IOException { 
//        if (instance == null) 
//            instance = new CSVReader(); 
//  
//        return instance; 
//    }
	
	public void readData() throws IOException {
		Set<String> words = new HashSet<>();
		
		File file = ResourceUtils.getFile("classpath:mly129.csv");
		
//		Path file = Paths.get("mly129.csv");
			
		reader = Files.newBufferedReader(file.toPath());
		
		reader.lines()
		.sequential()
		.map(l -> l.split(","))
		.filter(o -> o.length > 6)
		.map(WeatherRecordBuilder::new)
		.map(WeatherRecordBuilder::build)
		.filter(w -> w.getYear() > 0)
		.filter(x -> x!=null)
//		.peek(System.out::println)
//		.forEach(a -> System.out.print(""));
		.forEach(wr -> weatherRecordService.addWeatherRecord(wr));
		
//		weatherRecordService.addWeatherRecord(new WeatherRecord());

//		weathers.forEach(weatherRecord -> weatherRecordService.addItem(weatherRecord));
	}

}
