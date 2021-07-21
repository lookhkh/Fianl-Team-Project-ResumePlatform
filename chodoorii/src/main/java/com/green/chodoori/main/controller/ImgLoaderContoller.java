package com.green.chodoori.main.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.green.chodoori.util.fileUpload.ImgUploadAndGenerateSignUpDto;

@RestController
@RequestMapping("/img")
public class ImgLoaderContoller {

	@Autowired
	ImgUploadAndGenerateSignUpDto service;
	
	@GetMapping("/{imgName}")
	public ResponseEntity<Resource> imgLoader(@PathVariable String imgName, ServletWebRequest req) throws IOException {
		System.out.println("이미지 요청 정보 : "+imgName);

		
		
		UrlResource resource = new UrlResource("file:"+service.getPath()+imgName);
		
		if(!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		if(req.checkNotModified(resource.lastModified())) {
			System.out.println("requested Resource is Not Modified");
			return new ResponseEntity<Resource>(HttpStatus.NOT_MODIFIED);
		};

		System.out.println("requested Resource is Modified or New");

		
		return ResponseEntity.ok().header("Last-Modified", String.valueOf(resource.lastModified())).body(resource);
		
	}
}
