
package com.green.chodoori.dto;

import com.green.chodoori.main.domain.AlramDto;

import lombok.Data;

@Data
public class ResponseMessage extends AlramDto {
	private String content;

	public ResponseMessage() {

	}

	public ResponseMessage(String content) {
		this.content = getFromwhom() + "님이 이력서를 보냈습니다.";
	}

}