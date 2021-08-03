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

	private HashMap<String, UserInfoDto> tempStore = new HashMap(); //데이터베이스 사용 후 삭제 예정
	
	@Value("${upload.path}")
	String path;
	
	public UserInfoDto imgUploadAndGenerateSignUpDto(MultipartFile fileVo, SignUpFormVO vo) throws IllegalStateException, IOException {
		String fileName = fileVo.getOriginalFilename();
		String convertedItemName = UUID.randomUUID().toString()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
		
		log.info(path+convertedItemName);
		
		
		File file = new File(path+convertedItemName);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		fileVo.transferTo(file);
		
		UserInfoDto dto = new UserInfoDto();
		dto.setEmail(vo.getEmail());
		dto.setId(vo.getId());
		dto.setImgPath("/img/"+convertedItemName);
		dto.setPw(vo.getPw());
		dto.setName(vo.getName());
		dto.setSort(1);
		
		tempStore.put(vo.getId(), dto);//데이터베이스 사용 후 삭제 예정
		
		
		log.info("회원가입 정보 : {}",dto.toString());
		
		return dto;
		
	}

	//데이터 베이스 사용 시 삭제 예정
	public HashMap<String, UserInfoDto> getTempStore() {
		return tempStore;
	}
	
	public String getPath() {
		return this.path;
	}
	
	
	
}
