package com.green.chodoori;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.green.chodoori.main.Validator.SignValidator;
import com.green.chodoori.main.web.domain.SignUpFormVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SignUpValidationTest {
	
	SignValidator valid = new SignValidator();
    private static ValidatorFactory factory;
    private static Validator validator;
	 @BeforeAll
	    public static void init(){
	        factory = Validation.buildDefaultValidatorFactory();
	        validator = factory.getValidator();
	    }
	
	@Test
	public void Schedule(){
		
		BindingResult error = new BeanPropertyBindingResult(SignUpFormVO.class, "form");
		
		SignUpFormVO form = new SignUpFormVO();
		form.setBirth("930507");
		form.setCity("수원");
		form.setConfirmedPw("12312");
		form.setPw("123333");
		form.setContact_num("01099321967");
		form.setId("마마마");
		form.setEmail("lookhkh37@gmail.com");
		form.setName("조현일");
		
		
        Set<ConstraintViolation<SignUpFormVO>> violations = 
        		validator.validate(form);
		
        violations.forEach(a->System.out.println(a));
		
		
		
		
		
	}
}
