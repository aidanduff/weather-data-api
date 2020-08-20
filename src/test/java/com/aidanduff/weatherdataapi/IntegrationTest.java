package com.aidanduff.weatherdataapi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.util.LinkedMultiValueMap;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void fileShouldBeUploaded() throws IOException {	
	    LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
	    parameters.add("file", new org.springframework.core.io.ClassPathResource("mly129.csv")); 
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
	    HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);	
	    ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/upload", HttpMethod.POST, entity, String.class, "");	

	    assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void shouldGetAllData() throws IOException {	
	    LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
	    parameters.add("file", new org.springframework.core.io.ClassPathResource("mly129.csv")); 
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
	    HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);	
	    restTemplate.exchange("http://localhost:" + port + "/upload", HttpMethod.POST, entity, String.class, "");	

	    ResponseEntity<List> result = this.restTemplate.getForEntity("http://localhost:" + port + "/weather", List.class);
		assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void shouldDeleteAllData() throws IOException {	
	    LinkedMultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
	    parameters.add("file", new org.springframework.core.io.ClassPathResource("mly129.csv")); 
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
	    HttpEntity<LinkedMultiValueMap<String, Object>> entity = new HttpEntity<LinkedMultiValueMap<String, Object>>(parameters, headers);	
	    restTemplate.exchange("http://localhost:" + port + "/upload", HttpMethod.POST, entity, String.class, "");	

	    ResponseEntity<Object> result = restTemplate.exchange("http://localhost:" + port + "/delete", HttpMethod.DELETE, entity, Object.class);
		assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void nothingAddedShouldReturnNoContent() {
		ResponseEntity<List> result = this.restTemplate.getForEntity("http://localhost:" + port + "/weather", List.class);
		assertEquals(204, result.getStatusCodeValue());
		
	}
}
