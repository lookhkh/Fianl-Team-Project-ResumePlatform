package com.green.chodoori.util.mail;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository
public class MailAuthManageRepository {

	private HashMap<String, MailAuthInfoDto> store;
	
	public MailAuthManageRepository() {
		
		store = new HashMap();
	}
	
	
	
}
