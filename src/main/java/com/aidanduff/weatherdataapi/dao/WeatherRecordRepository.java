package com.aidanduff.weatherdataapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.aidanduff.weatherdataapi.entity.WeatherRecord;

public interface WeatherRecordRepository extends CrudRepository<WeatherRecord, String> {

}
