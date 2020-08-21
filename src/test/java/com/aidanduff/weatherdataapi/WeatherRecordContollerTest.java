package com.aidanduff.weatherdataapi;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.aidanduff.weatherdataapi.controller.WeatherRecordController;
import com.aidanduff.weatherdataapi.entity.WeatherRecord;
import com.aidanduff.weatherdataapi.service.FilesStorageServiceImpl;
import com.aidanduff.weatherdataapi.service.WeatherRecordService;
import com.aidanduff.weatherdataapi.util.CSVReader;

@WebMvcTest
@RunWith(SpringRunner.class)
public class WeatherRecordContollerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WeatherRecordController weatherRecordController;
	
	@MockBean
	private WeatherRecordService weatherRecordService;
	
	@MockBean
	private FilesStorageServiceImpl filesStorageServiceImpl;
	
	@MockBean
	private CSVReader csvReader;
	
	@Test
	public void listShouldbeReturnedFromGetAll() throws Exception {
		WeatherRecord weatherRecord = new WeatherRecord(1985, "Dec", 10, 17.5, 12.5, 5, 8);
		weatherRecord.setStationLocation("Athlone");
		List<WeatherRecord> weatherRecordList = new ArrayList<>();
		weatherRecordList.add(weatherRecord);

		when(weatherRecordService.getAllWeatherRecords()).thenReturn(weatherRecordList);
		
		this.mockMvc.perform(get("/weather"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));	
	
		assertEquals(ArrayList.class, weatherRecordService.getAllWeatherRecords().getClass());
		
	}

}
