package com.green.chodoori.corporate.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageableVo {

	private Integer pageNumber;
	private Integer totalPages;
	
	
}
