package com.aidanduff.weatherdataapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class WeatherRecord {

	@Id
	@GeneratedValue
	private int id;

	private String stationLocation;
	private int yearofRecord;
	private String month;
	private int ind;
	private double rain;
	private double gdf;
	private int rd;
	private int wd;
	
	public WeatherRecord(int year, String month, int indicator, double rain, double gdf, int rd, int wd) {
		super();
		this.stationLocation = stationLocation;
		this.yearofRecord = year;
		this.month = month;
		this.ind = indicator;
		this.rain = rain;
		this.gdf = gdf;
		this.rd = rd;
		this.wd = wd;
	}
	
	public WeatherRecord() {

	}
	
	public String getStationLocation() {
		return stationLocation;
	}

	public void setStationLocation(String stationLocation) {
		this.stationLocation = stationLocation;
	}

	public int getYear() {
		return yearofRecord;
	}

	public void setYear(int year) {
		this.yearofRecord = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getIndicator() {
		return ind;
	}

	public void setIndicator(int indicator) {
		this.ind = indicator;
	}

	public double getRain() {
		return rain;
	}

	public void setRain(double rain) {
		this.rain = rain;
	}

	public double getGdf() {
		return gdf;
	}

	public void setGdf(double gdf) {
		this.gdf = gdf;
	}

	public int getRd() {
		return rd;
	}

	public void setRd(int rd) {
		this.rd = rd;
	}

	public int getWd() {
		return wd;
	}

	public void setWd(int wd) {
		this.wd = wd;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Weather [year=" + yearofRecord + ", month=" + month + ", indicator=" + ind + ", rain=" + rain + ", gdf="
				+ gdf + ", rd=" + rd + ", wd=" + wd + "]";
	}

	
}
