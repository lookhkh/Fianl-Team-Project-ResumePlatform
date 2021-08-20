package com.green.chodoori.main.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.green.chodoori.main.web.domain.SignUpFormVO;


@Service
public class SignValidator implements Validator {

	private static final String emailRegExp =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";//이메일 유효성 검사

	private static final String idRegExp = "^[0-9a-z]+$";	//아이디 유효성 검사

	private Pattern emailpattern;	//이메일 패턴 변수

	private Pattern idpattern;		//아이디 패턴 변수

	public SignValidator() {
		emailpattern = Pattern.compile(emailRegExp);	//이메일 유효성 검사를 변수에 저장
		idpattern = Pattern.compile(idRegExp);			//아이디 유효성 검사를 변수에 저장 
	}

	@Override
	public boolean supports(Class<?> clazz) {	//인자로 넘어온 클래스가 Event인지를 검사하는 로직
		return SignUpFormVO.class.isAssignableFrom(clazz);	
	}

	// 파라미터로 전달받은 clazz객체가 RegisterRequest클래스로 타입이 변환될수 있는지 검사
	@Override
	public void validate(Object obj, Errors errors) {	//객체의 오류정보들을 저장하여
													// errors에 에러정보를 담는 로직 구현
		SignUpFormVO user = (SignUpFormVO) obj;	//

		// 아이디 유효성 체크 (아이디는 영어 또는 숫자만 한글은 받지않음)
		String userid = user.getId();
		if (userid == null || userid.trim().isEmpty()) {
			errors.rejectValue("id", "require","아이디를 입력해주세요");
		} else if (userid.length() < 5) {
			errors.rejectValue("id", "length","5글자 이상 입력해주세요");
		} else {
			Matcher matcher = idpattern.matcher(user.getId());
			if (!matcher.matches()) {
				errors.rejectValue("id","null","아이디는 영문,숫자로만 구성되어야합니다.");
			}
		}
		// 이름 입력
		String name = user.getName();
		if (name == null || name.trim().isEmpty()) {
			errors.rejectValue("name", "require","이름을 입력해주세요");
		}
		// 패스워드 검증
		String pw = user.getPw();
		ValidationUtils.rejectIfEmpty(errors, "pw", "require", "패스워드를 입력하세요");
		ValidationUtils.rejectIfEmpty(errors, "confirmedPw", "require", "패스워드를 확인해주세요");
		if (!pw.isEmpty()) {
			if (!user.checkPwWithConfirmPw()) {
				errors.rejectValue("confirmedPw", "nomatch", "패스워드가 일치하지 않습니다.");
			} else if (pw.length() < 6) {
				errors.rejectValue("pw", "패스워드는 최소 6자리입니다.");
			}
		}
		// 이메일 검증
		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "require");
			System.out.println("메일을 입력하세요.");
		} else {
			Matcher matcher = emailpattern.matcher(user.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad");
				
			}
		}
	}
}
