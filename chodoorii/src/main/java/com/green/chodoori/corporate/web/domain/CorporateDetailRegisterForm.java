package com.green.chodoori.corporate.web.domain;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class CorporateDetailRegisterForm {

	@NotNull(message = "필수 입렵값입니다")
	@Range(max = 300, message = "최대 300명입니다")
	private Integer staffNumber;
	@NotNull(message="필수 입력값입니다.")
	private String salary;
	@NotNull(message="필수 입력값입니다.")
	private List<String> wlfare;
	@NotNull(message="필수 입력값입니다.")
	@NotBlank(message = "필수 입력값입니다.")
	private String summary;
	


}
