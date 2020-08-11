package com.aidanduff.weatherdataapi.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {

	public void init();

	public void save(MultipartFile file);
	
	public Resource load(String filename);

	public void deleteAll();
}
