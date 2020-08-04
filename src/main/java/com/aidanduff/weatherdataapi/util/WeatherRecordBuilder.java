package com.aidanduff.weatherdataapi.util;

import com.aidanduff.weatherdataapi.entity.WeatherRecord;

public class WeatherRecordBuilder {
	private String[] dataArray;

	public WeatherRecordBuilder(String[] dataArray) {
		super();
		this.dataArray = dataArray;
	}
	
	public WeatherRecord build() {
		WeatherRecord weatherRecord = new WeatherRecord();
		int index = 0;
		try {
			weatherRecord.setYear(Integer.parseInt(dataArray[index++]));
			weatherRecord.setMonth(dataArray[index++]);
			weatherRecord.setIndicator(Integer.parseInt(dataArray[index++]));
			weatherRecord.setRain(Double.parseDouble(dataArray[index++]));
			weatherRecord.setGdf(Double.parseDouble(dataArray[index++]));
			weatherRecord.setWd(Integer.parseInt(dataArray[index++]));
		} catch(NumberFormatException e) {}
		
		return weatherRecord;	
	}
}
