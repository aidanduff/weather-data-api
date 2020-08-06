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
			weatherRecord.setMonth(getMonth(dataArray[index++]));
			weatherRecord.setIndicator(Integer.parseInt(dataArray[index++]));
			weatherRecord.setRain(Double.parseDouble(dataArray[index++]));
			weatherRecord.setGdf(Double.parseDouble(dataArray[index++]));
			weatherRecord.setRd(Integer.parseInt(dataArray[index++]));
			weatherRecord.setWd(Integer.parseInt(dataArray[index++]));
		} catch(NumberFormatException e) {}
		
		return weatherRecord;	
	}
	
	private String getMonth(String month) {
		switch(month) {
			case "1" : return "Jan";
			case "2" : return "Feb";
			case "3" : return "Mar";
			case "4" : return "Apr";
			case "5" : return "May";
			case "6" : return "Jun";
			case "7" : return "Jul";
			case "8" : return "Aug";
			case "9" : return "Sep";
			case "10" : return "Oct";
			case "11" : return "Nov";
			case "12" : return "Dec";
			default : return "MonthError";
		}
	}
}
