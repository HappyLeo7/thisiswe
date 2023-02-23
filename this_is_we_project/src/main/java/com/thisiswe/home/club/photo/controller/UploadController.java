package com.thisiswe.home.club.photo.controller;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UploadController {

	@Value("${com.thisiswe.upload.path}")
	private String uploadPath;
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> getFile(String fileName, String size){
		
		log.info("이미지 파일이름"+fileName);
		log.info("이미지 크기"+size);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			String srcFileName = URLDecoder.decode(fileName, "UTF-8");
			
			log.info("fileName(srcFileName) : " + srcFileName);
			
			File file = new File(uploadPath + File.separator + srcFileName);
			
			if(size !=null && size.equals("1")) {
				file = new File(file.getParent(), file.getName().substring(2));
			}
			
			log.info(file);
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(
					FileCopyUtils.copyToByteArray(file), 
					header, 
					HttpStatus.OK);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
