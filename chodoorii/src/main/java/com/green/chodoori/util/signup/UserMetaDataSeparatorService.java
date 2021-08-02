package com.green.chodoori.util.signup;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVo;

@Service
public class UserMetaDataSeparatorService {
	
	public IndividualSginUpMetadataFormVo separatorForUserMetadata(MultiValueMap<String,String> map){
		Set<String> keys = map.keySet();
	
		IndividualSginUpMetadataFormVo dto = new IndividualSginUpMetadataFormVo();
		
	
		
		for(String key : keys) {
			switch(key) {
				
				case "id":{
					dto.setId(map.get(key).get(0));
					break;
				}
						
			
				case "position" :{
					
					List<String> list = map.get(key);
					for(int i=0; i<list.size(); i++) {
						dto.getPosition().add(list.get(i));
					}
					
	
					break;
				}
				case "language":{
					List<String> list = map.get(key);
					for(int i=0; i<list.size(); i++) {
						dto.getLanguage().add(list.get(i));
					}
					
	
					break;
				}
				
				case "framework":{
					List<String> list = map.get(key);
					for(int i=0; i<list.size(); i++) {
						dto.getFramework().add(list.get(i));
					}
					
	
					break;
				}
				
				case "db":{
					List<String> list = map.get(key);
					for(int i=0; i<list.size(); i++) {
						dto.getDb().add(list.get(i));
					}
					
	
	
					break;
				}
				
				case "exp" : {
					List<String> list = map.get(key);
					for(int i=0; i<list.size(); i++) {
						dto.setExp(list.get(i));
					}
					
	
					
					break;
				}
				case "period" :{
					List<String> period = map.get(key);
					if(period!=null) {
						dto.setPeriod(period.get(0));
					}									
				}
			}
		}
				return dto;
		}
	
}
