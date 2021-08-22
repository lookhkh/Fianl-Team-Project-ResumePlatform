package com.green.chodoori;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.green.chodoori.corporate.web.domain.CorporateDetailRegisterForm;
import com.green.chodoori.main.web.domain.SignUpFormVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationTest {
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	@Autowired
	MessageSource ms;
	
	@Test
	public void Schedule(){
		
		
		SignUpFormVO form = new SignUpFormVO();
		form.setBirth("930507");
		form.setCity("수원");
		form.setConfirmedPw("12312");
		form.setPw("123333");
		form.setContact_num("01099321967");
		form.setId("마마마");
		form.setEmail("lookhkh37@gmail.com");
		form.setName("조현일");
		
		
		// 검증
		Set<ConstraintViolation<SignUpFormVO>> violations = validator.validate(form);
		// 검증 결과를 출력
		for (ConstraintViolation<SignUpFormVO> violation : violations) {
		log.error(violation.getMessage());
		}
		

	}
		
		
	
	
	@Test
	public void corporateDetailValidationTest() {
		CorporateDetailRegisterForm test = new CorporateDetailRegisterForm();
		
		test.setSalary("ㅋ");
		test.setStaffNumber(3000);
		test.setSummary(null);
		test.setWlfare(null);

		// 검증
		Set<ConstraintViolation<CorporateDetailRegisterForm>> violations = validator.validate(test);
		// 검증 결과를 출력
		for (ConstraintViolation<CorporateDetailRegisterForm> violation : violations) {
		log.error(violation.getMessage());
		}
		

	}
	
	@Test
	public void test() {
		//System.out.println(ms.getMessage("typeMismatch.corporateDetailRegisterForm.staffNumber", null,null));
	}
	
	
	
}
