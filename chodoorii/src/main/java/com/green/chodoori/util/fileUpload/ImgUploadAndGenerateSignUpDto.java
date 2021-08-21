package com.green.chodoori.util.fileUpload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.web.domain.SignUpFormVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImgUploadAndGenerateSignUpDto {

	@Value("${upload.path}")
	String path;
	
	public String imgUploadAndGenerateSignUpDto(MultipartFile fileVo) throws IllegalStateException, IOException {
		String fileName = fileVo.getOriginalFilename();
		String convertedItemName = UUID.randomUUID().toString()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
				
		log.info(path+convertedItemName);
		
		
		File file = new File(path+convertedItemName);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		fileVo.transferTo(file);
		
			
		return "/img/"+convertedItemName;
		
	}

	public String getPath() {
		return this.path;
	}
	
	
	
}
