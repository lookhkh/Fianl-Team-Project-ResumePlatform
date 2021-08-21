package com.green.chodoori.main.service;

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
					//dto.setId(map.get(key).get(0));
					break;
				}
						
			
				case "position" :{
					
					List<String> list = map.get(key);
					
					if(rangeCheck(list,0)) {
						dto.setPosition_1(list.get(0));
					}
					
					if(rangeCheck(list,1)) {
						dto.setPosition_2(list.get(1));
					}
					
					if(rangeCheck(list,2)) {
						dto.setPosition_3(list.get(2));
					}
					
					if(rangeCheck(list,3)) {
						dto.setPosition_4(list.get(3));
					}
					
					if(rangeCheck(list,4)) {
						dto.setPosition_5(list.get(4));
					}
										
					for(int i=0; i<list.size(); i++) {
						dto.getPosition().add(list.get(i));
					}
					
	
					break;
				}
				case "language":{
					List<String> list = map.get(key);
					
					if(rangeCheck(list, 0)) {
						dto.setLan_1(list.get(0));
					}
					
					if(rangeCheck(list,1)) {
						dto.setLan_2(list.get(1));
					}
					
					if(rangeCheck(list,2)) {
						dto.setLan_3(list.get(2));
					}
					
					for(int i=0; i<list.size(); i++) {
						dto.getLanguage().add(list.get(i));
					}
					
	
					break;
				}
				
				case "framework":{
					List<String> list = map.get(key);
					
					if(rangeCheck(list, 0)) {
						dto.setFramework_1(list.get(0));
					}
					
					if(rangeCheck(list,1)) {
						dto.setFramework_2(list.get(1));
					}
					
					if(rangeCheck(list,2)) {
						dto.setFramework_3(list.get(2));
					}
					
					for(int i=0; i<list.size(); i++) {
						dto.getFramework().add(list.get(i));
					}
					
	
					break;
				}
				
				case "db":{
					List<String> list = map.get(key);
					
					if(rangeCheck(list, 0)) {
						dto.setDbs_1(list.get(0));
					}
					
					if(rangeCheck(list,1)) {
						dto.setDbs_2(list.get(1));
					}
					
					if(rangeCheck(list,2)) {
						dto.setDbs_3(list.get(2));
					}
					
					for(int i=0; i<list.size(); i++) {
						dto.getFramework().add(list.get(i));
					}
					
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
	
	public boolean rangeCheck(List list, Integer i) {
		return list.size()>i?true:false;
	}
	
}
