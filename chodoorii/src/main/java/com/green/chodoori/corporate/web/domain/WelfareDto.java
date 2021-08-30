package com.green.chodoori.corporate.web.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Embeddable
public class WelfareDto {
	
	

	public WelfareDto() {
		

	}


	private String welfare_first;
	private String welfare_second;
	private String welfare_third;
	private String welfare_forth;


	@Transient
	private List<String> welfareLists;
	
	public void makeDto(List<String> lists) {
		
		if(lists==null) {
			return;
		}
		
		String[] index = {"first","second","third","forth"};
		
		for(int i=0; i<lists.size(); i++) {
			if(i==0) {
				this.welfare_first = lists.get(i);
				}
			if(i==1) {
				this.welfare_second = lists.get(i);
			}
			if(i==2) {
				this.welfare_third = lists.get(i);
			}
			if(i==3) {
				this.welfare_forth = lists.get(i);
			}
			
			
			
		}

		
	}
	
	public List<String> makeList() {
		this.welfareLists = new ArrayList<>();
		this.welfareLists.add(this.welfare_first);
		this.welfareLists.add(this.welfare_second);
		this.welfareLists.add(this.welfare_third);
		this.welfareLists.add(this.welfare_forth);
		return this.welfareLists;
	}
	
}
