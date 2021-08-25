package com.green.chodoori.corporate.web.domain;

import java.util.List;

import com.green.chodoori.developer.domain.ResumeDto;
import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVo;

import lombok.Data;

@Data
public class UserMetadataAndUserResumeVo {

	private List<ResumeDto> resume;
	private List<IndividualSginUpMetadataFormVo> metadata;
	
}
